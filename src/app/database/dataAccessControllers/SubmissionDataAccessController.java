package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Author;
import app.pojo.Submission;

import java.sql.*;
import java.util.ArrayList;

public class SubmissionDataAccessController extends GenericDataAccessController<Submission> {
    @Override
    protected String getTableName() {
        return "submissions";
    }

    @Override
    protected String getAllFields() {
        return "id, title, abstract, draft_article, journal_id, author_id, status";
    }

    @Override
    protected String getIndexFields(){
        return "id, title";
    }

    @Override
    protected Submission readItem(ResultSet res) throws SQLException {
        return null;
    }

    @Override
    protected String getInsertFields() {
        return "title, abstract, draft_article, journal_id, author_id, status";

    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Submission submission) throws SQLException {
        preparedStatement.setString(1, submission.getTitle());
        preparedStatement.setString(2, submission.getAbstractText());
        preparedStatement.setString(3, submission.getDraftArticle());
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
}
