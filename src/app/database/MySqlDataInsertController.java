package app.database;

import app.database.databaseInterfaces.DataInsertController;
import app.pojo.*;

import java.sql.*;

public class MySqlDataInsertController implements DataInsertController {
    private static String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";
    private static String DB_TEST = "jdbc:mysql://localhost:3306/test";
    private static String USERNAME_TEST = "root";
    private static String PASSWORD_TEST = "dupeczka1.";


    public boolean insertSubmission(Submission submission){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO submissions(title, abstract, draft_article, author_id) " +
                    "VALUES(?,?,?,?);")){
            preparedStatement.setString(1, submission.getTitle());
            preparedStatement.setString(2, submission.getAbstractText());
            preparedStatement.setString(3, submission.getDraftArticle());
            preparedStatement.setInt(4, submission.getAuthorId());
            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean insertUser(String title, String forname, String surname, String university, String email, String password){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO users(title, forname, surname, university, email, password) " +
                    "VALUES(?,?,?,?,?,?);")){
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, forname);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, university);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }



    public boolean insertAuthor(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO authors(user_id) " +
                    "VALUES(?);")){
            preparedStatement.setInt(1, userId );
            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    public boolean insertEditor(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO editors(user_id) " +
                    "VALUES(?);")){
            preparedStatement.setInt(1, userId );
            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    public boolean insertJournal(Journal journal){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO journals(ISSN, name_of_journal, number_of_volumes, chief_editor_id) " +
                    "VALUES(?,?,?,?);")){
            preparedStatement.setString(1, journal.getIssn());
            preparedStatement.setString(2, journal.getName());
            preparedStatement.setInt(3, journal.getNumberOfVolumes());
            preparedStatement.setInt(4, journal.getChiefEditorId());

            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertJournalEditor(Journal journal, Editor editor) {
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO journal_editor(ISSN, editor_id) " +
                    "VALUES(?,?);")){

            preparedStatement.setString(1, journal.getIssn());
            preparedStatement.setInt(2, editor.getId());

            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertSubmission(String title, String abstractText, String draftArticle, Integer authorId, String issn) {
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO submissions(title, abstract, draft_article, ISSN, author_id) " +
                    "VALUES(?,?,?,?,?);")){

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, abstractText);
            preparedStatement.setString(3, draftArticle);
            preparedStatement.setString(4, issn);
            preparedStatement.setInt(5, authorId);

            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertCoAuthor(Integer submissionId, Integer authorId) {
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
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
