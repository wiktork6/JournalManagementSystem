package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.Tools.BlobFileConverter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Article;
import app.pojo.Author;
import app.pojo.Submission;
import app.pojo.User;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class SubmissionDataAccessController extends GenericDataAccessController<Submission> {
    @Override
    protected String getTableName() {
        return "submissions";
    }

    @Override
    protected String getAllFields() {
        return getTableName() + ".id, " + getTableName() + ".title, abstract, draft_article, journal_id, "+getTableName()+".author_id, status, reviews_selected";
    }

    @Override
    protected String getIndexFields(){
        return "id, title";
    }

    @Override
    protected Submission readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
        if(id == 0){
            return null;
        }
        String title = res.getString(2);
        String abstractText = res.getString(3);
        File draftArticle;
        try {
            draftArticle = BlobFileConverter.getFileFromBlob(res.getBlob(4), id.toString() + ".pdf");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Integer journal_id = res.getInt(5);
        Integer author_id = res.getInt(6);
        String status = res.getString(7);
        Integer reviewsSelected = res.getInt(8);
        return new Submission(id,abstractText,title,draftArticle,author_id,journal_id,status,reviewsSelected);
    }

    @Override
    protected String getInsertFields() {
        return "title, abstract, draft_article, journal_id, author_id, status, reviews_selected";

    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Submission submission) throws SQLException {
        preparedStatement.setString(1, submission.getTitle());
        preparedStatement.setString(2, submission.getAbstractText());
        try {
            preparedStatement.setBlob(3, new ByteArrayInputStream(BlobFileConverter.getByteArrayFromFile(submission.getDraftArticle())));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        preparedStatement.setInt(4, submission.getJournalId());
        preparedStatement.setInt(5, submission.getAuthorId());
        preparedStatement.setString(6, submission.getStatus());
        preparedStatement.setInt(7, submission.getReviewsSelected());
        return 7;
    }

    public ArrayList<Author> getSubmissionsCoAuthors(Integer submissionId) {
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, a.author_id, u.title, u.forname FROM Submission_Author s INNER JOIN Author a ON a.Author_id=s.author_id INNER JOIN User u ON u.userID=a.userID")){
            preparedStatement.setInt(1, submissionId);
            ResultSet res = preparedStatement.executeQuery();
            while(res.next()){

            }
            Integer editorId =  res.getInt(1);

            res.close();
            return new ArrayList<Author>();

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public boolean insertCoAuthor(Integer submissionId, Integer authorId) {
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO submission_author(submission_id, author_id) " +
                    "VALUES(?,?);")){

            preparedStatement.setInt(1, submissionId);
            preparedStatement.setInt(2, authorId);

            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Submission> getReviewerSubmissions(String university, Integer reviewerId, Integer authorId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("users.university", university));
        filters.add(new KVPair("reviews.reviewer_id", reviewerId));
        filters.add(new KVPair("sa.author_id", authorId));
        filters.add(new KVPair("submissions.author_id", authorId));
        return super.getItems("SELECT DISTINCT " + getAllFields() + " FROM " + getTableName()
                + " INNER JOIN authors as a ON a.id = " + getTableName() + ".author_id"
                + " INNER JOIN submission_author as sa ON sa.submission_id = " + getTableName() + ".id"
                + " INNER JOIN authors ON authors.id = sa.author_id"
                + " INNER JOIN users ON users.id = a.user_id OR users.id = authors.user_id"
                + " LEFT JOIN reviews ON reviews.submission_id = " + getTableName() + ".id"
                + " WHERE LOWER(users.university) <> LOWER(?) " // where there are no uni affiliations overlapping
                + " AND (reviews.reviewer_id <> ? OR reviews.reviewer_id IS NULL)" // where user is not already reviewing
                + " AND sa.author_id <> ? AND " + getTableName() + ".author_id <> ?" // where user is not author or coauthor
                + " GROUP BY " + getTableName() + ".id"
                + " HAVING COUNT(DISTINCT reviews.id) < 3"// with less than 3 reviews
                , filters);
    }

    public ArrayList<Submission> getSelectedSubmissions(Integer reviewerId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("reviews.reviewer_id", reviewerId));
        return super.getItems("SELECT " + getAllFields() + " FROM " + getTableName()
                + " INNER JOIN reviews ON reviews.submission_id = " + getTableName() + ".id"
                + " WHERE reviews.reviewer_id = ?", filters);
    }

//    public ArrayList<Submission> getSubmissions(Author author){
//        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
//            PreparedStatement preparedStatement = conn.prepareStatement("SELECT " + getAllFields() + " FROM submissions s WHERE author_id = ?;")){
//            preparedStatement.setInt(1, author.getId());
//            ArrayList<Submission> submissionsList = new ArrayList<>();
//            ResultSet res = preparedStatement.executeQuery();
//            while(res.next()){
//                Submission submission = readItem(res);
//                submissionsList.add(submission);
//            }
//
//            return submissionsList;
//        }catch(SQLException ex){
//            ex.printStackTrace();
//            return null;
//        }
//
//    }

    public ArrayList<Submission> getAuthorSubmissions(Author author){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT s.id, s.title, s.abstract, s.draft_article, s.journal_id, s.author_id, s.status, s.reviews_selected  FROM submissions s  INNER JOIN submission_author sa ON s.id =sa.submission_id WHERE sa.author_id = ?")){
            preparedStatement.setInt(1, author.getId());
            ResultSet res = preparedStatement.executeQuery();
            ArrayList<Submission> submissionArrayList = new ArrayList<>();
            while(res.next()){
                Submission submission = readItem(res);
                submissionArrayList.add(submission);
            }


            res.close();
            return submissionArrayList;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Integer unansweredReviewQuestions(Integer submissionId){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(*) FROM submissions " +
                            "LEFT JOIN reviews ON reviews.submission_id = submissions.id " +
                            "LEFT JOIN questions ON questions.review_id = reviews.id " +
                            "WHERE questions.is_answered = False " +
                            "AND submissions.id = ? ")){
            preparedStatement.setInt(1, submissionId);

            ResultSet res = preparedStatement.executeQuery();
            res.next();
            return res.getInt(1);
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }




    public ArrayList<Submission> getPossibleSubmissionsWhereUni(User user){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT s.id, s.title, s.abstract, s.draft_article, s.journal_id, s.author_id, s.status, s.reviews_selected  FROM submissions s  JOIN submission_author sa ON s.id =sa.submission_id JOIN authors a ON sa.author_id = a.id JOIN users u ON a.user_id = u.id WHERE u.university = ?;")){
            preparedStatement.setString(1, user.getUniversity());
            ResultSet res = preparedStatement.executeQuery();
            ArrayList<Submission> submissionArrayList = new ArrayList<>();
            while(res.next()){
                Submission submission = readItem(res);
                submissionArrayList.add(submission);
            }


            res.close();
            return submissionArrayList;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Integer removeSubmissionAuthors(Integer submissionId){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE authors FROM authors" +
                            "INNER JOIN submissions ON submissions.author_id = authors.id" +
                            "INNER JOIN submission_author AS sa ON sa.author_id = authors.id" +
                            "WHERE submissions.id = ? OR sa.submission_id = ?")){
            preparedStatement.setInt(1, submissionId);
            preparedStatement.setInt(2, submissionId);

            return preparedStatement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
