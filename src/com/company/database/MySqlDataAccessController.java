package com.company.database;

import com.company.article.Article;
import com.company.database.databaseInterfaces.DataAccessController;
import com.company.edition.Edition;
import com.company.journal.Journal;
import com.company.question.Question;
import com.company.review.Review;
import com.company.users.User;
import com.company.volume.Volume;

import java.sql.*;
import java.util.ArrayList;

public class MySqlDataAccessController implements DataAccessController {
    private static String DB = "jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";
    private static String DB_TEST = "jdbc:mysql://localhost:3306/test";
    private static String USERNAME_TEST = "root";
    private static String PASSWORD_TEST = "dupeczka1.";

    public MySqlDataAccessController() {
    }

    private static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
    }

    private static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public boolean insertUser(User user) {
        Connection conn = null;
        try {
            conn = openConnection();
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO users(email, title, forname, surname, university, password) " +
                    "VALUES('" + user.getEmail() + "', '" + user.getTitle() + "', '" + user.getForname() + "', '" + user.getSurname() + "', '" + user.getUniversity() + "', '" + user.getPassword() + "');");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (conn != null)
                closeConnection(conn);
        }
    }


    public ArrayList<String> getUsers() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {

            ResultSet res = statement.executeQuery("SELECT email FROM users;");
            ArrayList<String> listOfUsers = new ArrayList<>();

            while (res.next()) {
                listOfUsers.add(res.getString(1));
            }
            res.close();
            return listOfUsers;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Integer getUserId(String email) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {

            ResultSet res = statement.executeQuery("SELECT id FROM users WHERE email = '" + email + "';");
            int userId = 0;

            while (res.next()) {
                userId = res.getInt(1);
            }
            res.close();
            return userId;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Journal> getJournals() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM journals;");
            ArrayList<Journal> listOfJournals = new ArrayList<>();

            while (res.next()) {
                String issn = res.getString(1);
                Integer numberOfVolumes = res.getInt(2);
                Integer chiefEditorId = res.getInt(3);
                Journal journal = new Journal(issn, numberOfVolumes, chiefEditorId);
                listOfJournals.add(journal);
            }
            res.close();
            return listOfJournals;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<Volume> getVolumes() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM volumes;");
            ArrayList<Volume> listOfVolumes = new ArrayList<>();
            while (res.next()) {
                Integer id = res.getInt(1);
                Integer volumeNumber = res.getInt(2);
                Integer numberOfEditions = res.getInt(3);
                String yearOfPublication = res.getString(4);
                String issn = res.getString(5);
                Volume volume = new Volume(id, volumeNumber, numberOfEditions, yearOfPublication, issn);

                listOfVolumes.add(volume);
            }
            return listOfVolumes;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Volume> getVolumes(String issnNumber) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM volumes WHERE ISSN = '" + issnNumber + "';");
            ArrayList<Volume> listOfVolumes = new ArrayList<>();
            while (res.next()) {
                Integer id = res.getInt(1);
                Integer volumeNumber = res.getInt(2);
                Integer numberOfEditions = res.getInt(3);
                String yearOfPublication = res.getString(4);
                String issn = res.getString(5);
                Volume volume = new Volume(id, volumeNumber, numberOfEditions, yearOfPublication, issn);

                listOfVolumes.add(volume);
            }
            return listOfVolumes;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Edition> getEditions(Integer volumeId) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM editions WHERE volume_id = " + volumeId + ";");
            ArrayList<Edition> listOfEditions = new ArrayList<>();

            while (res.next()) {
                Integer id = res.getInt(1);
                Integer editionNumber = res.getInt(2);
                String monthOfPublication = res.getString(3);
                Integer volumeIdNumber = res.getInt(4);
                Edition edition = new Edition(id, editionNumber, monthOfPublication, volumeIdNumber);
                listOfEditions.add(edition);
            }
            return listOfEditions;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Edition> getEditions() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM editions;");
            ArrayList<Edition> listOfEditions = new ArrayList<>();

            while (res.next()) {
                Integer id = res.getInt(1);
                Integer editionNumber = res.getInt(2);
                String monthOfPublication = res.getString(3);
                Integer volumeIdNumber = res.getInt(4);
                Edition edition = new Edition(id, editionNumber, monthOfPublication, volumeIdNumber);
                listOfEditions.add(edition);
            }
            return listOfEditions;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Article> getArticles(Integer editionId) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM articles WHERE edition_id = " + editionId + ";");
            ArrayList<Article> listOfArticles = new ArrayList<>();
            while (res.next()) {
                Integer id = res.getInt(1);
                String pageNumberRange = res.getString(2);
                String abstractText = res.getString(3);
                String title = res.getString(4);
                String fullArticle = res.getString(5);
                Integer mainAuthorId = res.getInt(7);
                Integer editionIdNumber = res.getInt(8);
                Article article = new Article(id, pageNumberRange, abstractText, title, fullArticle, mainAuthorId, editionIdNumber);
                listOfArticles.add(article);
            }
            return listOfArticles;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public ArrayList<Article> getArticles() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT * FROM articles;");
            ArrayList<Article> listOfArticles = new ArrayList<>();
            while (res.next()) {
                Integer id = res.getInt(1);
                String pageNumberRange = res.getString(2);
                String abstractText = res.getString(3);
                String title = res.getString(4);
                String fullArticle = res.getString(5);
                Integer mainAuthorId = res.getInt(7);
                Integer editionId = res.getInt(8);
                Article article = new Article(id, pageNumberRange, abstractText, title, fullArticle, mainAuthorId, editionId);
                listOfArticles.add(article);
            }
            return listOfArticles;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public Article showArticle(Integer articleId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            Statement statement = conn.createStatement()){
            ResultSet res = statement.executeQuery("SELECT * FROM articles WHERE id =" + articleId + ";");
            Integer id = res.getInt(1);
            String pageNumberRange = res.getString(2);
            String abstractText = res.getString(3);
            String title = res.getString(4);
            String fullArticle = res.getString(5);
            Integer mainAuthorId = res.getInt(7);
            Integer editionId = res.getInt(8);
            Article article = new Article(id, pageNumberRange, abstractText, title, fullArticle, mainAuthorId, editionId);
            return article;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
  }
    public ArrayList<Review> getReviews(Integer submissionId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            Statement statement = conn.createStatement()){

            ResultSet res = statement.executeQuery("SELECT * FROM reviews WHERE submission_id =" + submissionId + ";");
            ArrayList<Review> listOfReviews = new ArrayList<>();

            while(res.next()){
                Integer reviewId = res.getInt(1);
                String reviewSummary = res.getString(2);
                String typographicallErorrs = res.getString(3);
                String initialVerdict = res.getString(4);
                String finalVerdict = res.getString(5);
                Integer submissionIdNumber = res.getInt(7);
                Integer reviewerId = res.getInt(8);
                Review review = new Review(reviewId, reviewSummary, typographicallErorrs, initialVerdict, finalVerdict, submissionIdNumber, reviewerId);
                listOfReviews.add(review);
            }
            res.close();
            return listOfReviews;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Question> getQuestions(Integer reviewId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            Statement statement = conn.createStatement()){

            ResultSet res = statement.executeQuery("SELECT * FROM questions WHERE review_id =" + reviewId + ";");
            ArrayList<Question> listOfQuestions = new ArrayList<>();

            while(res.next()){
                Integer questionId = res.getInt(1);
                Integer questionNumber = res.getInt(2);
                String questionText = res.getString(3);
                Integer reviewIdNumber = res.getInt(4);

                Question question = new Question(questionId, questionNumber, questionText, reviewIdNumber);
                listOfQuestions.add(question);
            }
            res.close();
            return listOfQuestions;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
