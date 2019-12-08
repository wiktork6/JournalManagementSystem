package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.Tools.BlobFileConverter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Article;
import app.pojo.Author;
import app.pojo.Submission;

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
        return getTableName() + ".id, " + getTableName() + ".title, abstract, draft_article, journal_id, "+getTableName()+".author_id, status";
    }

    @Override
    protected String getIndexFields(){
        return "id, title";
    }

    @Override
    protected Submission readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
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
        return new Submission(id,abstractText,title,draftArticle,journal_id,author_id,status);
    }

    @Override
    protected String getInsertFields() {
        return "title, abstract, draft_article, journal_id, author_id, status";

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
        return 5;
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

    public ArrayList<Submission> getReviewerSubmissions(String university, Integer reviewerId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("users.university", university));
        filters.add(new KVPair("reviews.reviewer_id", reviewerId));
        return super.getItems("SELECT DISTINCT " + getAllFields() + " FROM " + getTableName()
                + " INNER JOIN authors as a ON a.id = " + getTableName() + ".author_id"
                + " INNER JOIN submission_author as sa ON sa.submission_id = " + getTableName() + ".id"
                + " INNER JOIN authors ON authors.id = sa.author_id"
                + " INNER JOIN users ON users.id = a.user_id or users.id = authors.user_id"
                + " LEFT JOIN reviews ON reviews.submission_id = " + getTableName() + ".id"
                + " WHERE LOWER(users.university) <> LOWER(?) "
                + " AND (reviews.reviewer_id <> ? OR reviews.reviewer_id IS NULL)", filters);
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
}
