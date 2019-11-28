package app.database;

import app.database.databaseInterfaces.DataAccessController;
import app.pojo.*;

import java.sql.*;
import java.util.ArrayList;

public class MySqlDataAccessController implements DataAccessController {
    private static String DB = "jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";
    private static String DB_TEST = "jdbc:mysql://localhost:3306/test";
    private static String USERNAME_TEST = "root";
    private static String PASSWORD_TEST = "dupeczka1.";

    public MySqlDataAccessController() {
    }

    @Override
    public User getUser(Integer id){
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, email, title, forname, surname, university FROM users WHERE id = ?")) {

            preparedStatement.setInt(1,id);

            ResultSet res = preparedStatement.executeQuery();
            User user = null;
            if(res.next()){
                Integer userId = res.getInt(1);
                String email = res.getString(2);
                String title = res.getString(3);
                String forname = res.getString(4);
                String surname = res.getString(5);
                String university= res.getString(6);
                user = new User(userId,title,forname,surname,university,email);
            }


            res.close();
            return user;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public ArrayList<User> getUsers() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, email, title, forname, surname, university FROM users;")) {

            ResultSet res = preparedStatement.executeQuery();
            ArrayList<User> listOfUsers = new ArrayList<>();

            while (res.next()) {
                Integer userId = res.getInt(1);
                String email = res.getString(2);
                String title = res.getString(3);
                String forname = res.getString(4);
                String surname = res.getString(5);
                String university = res.getString(6);
                User user = new User(userId,title,forname,surname,university,email);
                listOfUsers.add(user);
            }
            res.close();
            return listOfUsers;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public Integer getUserId(String email) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM users WHERE email = ?;")) {
            preparedStatement.setString(1,email);
            ResultSet res = preparedStatement.executeQuery();
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
    @Override
    public ArrayList<Journal> getJournals() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT ISSN, name_of_journal, number_of_volumes, chief_editor_id FROM journals;");
            ArrayList<Journal> listOfJournals = new ArrayList<>();

            while (res.next()) {
                String issn = res.getString(1);
                String name = res.getString(2);
                Integer numberOfVolumes = res.getInt(3);
                Integer chiefEditorId = res.getInt(4);
                Journal journal = new Journal(issn, name, numberOfVolumes, chiefEditorId);
                listOfJournals.add(journal);
            }
            res.close();
            return listOfJournals;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    @Override
    public ArrayList<String> getAvailableJournals(Integer editorId){
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT ISSN FROM journal_editor WHERE editor_id = ?;")) {
            preparedStatement.setInt(1, editorId);
            ResultSet res = preparedStatement.executeQuery();
            ArrayList<String> listOfIssn = new ArrayList<>();


            while (res.next()) {
                String issn = res.getString(1);
                listOfIssn.add(issn);
            }

            res.close();
            return listOfIssn;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    @Override
    public ArrayList<Volume> getVolumes() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT id, volume_number, number_of_editions, year_of_publication, ISSN FROM volumes;");
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
    @Override
    public ArrayList<Volume> getVolumes(String issnNumber) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, volume_number, number_of_editions, year_of_publication, ISSN FROM volumes WHERE ISSN = ?;")) {
            preparedStatement.setString(1, issnNumber);
            ResultSet res = preparedStatement.executeQuery();
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
    @Override
    public ArrayList<Edition> getEditions(Integer volumeId) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, edition_number, month_of_publication, volume_id FROM editions WHERE volume_id = ?;")) {
            preparedStatement.setInt(1, volumeId);
            ResultSet res = preparedStatement.executeQuery();
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
    @Override
    public ArrayList<Edition> getEditions() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT id, edition_number, month_of_publication, volume_id FROM editions;");
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
    @Override
    public ArrayList<Article> getArticles(Integer editionId) {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, page_number_range, abstract, title, final_full_article, main_author_id, edition_id FROM articles WHERE edition_id = ?;")) {
            preparedStatement.setInt(1, editionId);
            ResultSet res = preparedStatement.executeQuery();
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

    @Override
    public ArrayList<Article> getArticles() {
        try (Connection conn = DriverManager.getConnection(DB_TEST, USERNAME_TEST, PASSWORD_TEST);
             Statement statement = conn.createStatement()) {
            ResultSet res = statement.executeQuery("SELECT id, page_number_range, abstract, title, final_full_article, main_author_id, edition_id FROM articles;");
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
    @Override
    public Article showArticle(Integer articleId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, page_number_range, abstract, title, final_full_article, main_author_id, edition_id FROM articles WHERE id = ?;")){
            ResultSet res = preparedStatement.executeQuery();
            preparedStatement.setInt(1, articleId);

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
    @Override
    public ArrayList<Review> getReviews(Integer submissionId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, review_summary, typographical_errors, initial_verdict, final_verdict, submission_id, reviewer_id FROM reviews WHERE submission_id = ?;")){
            preparedStatement.setInt(1, submissionId);
            ResultSet res = preparedStatement.executeQuery();
            ArrayList<Review> listOfReviews = new ArrayList<>();

            while(res.next()){
                Integer reviewId = res.getInt(1);
                String reviewSummary = res.getString(2);
                String typographicallErorrs = res.getString(3);
                String initialVerdict = res.getString(4);
                String finalVerdict = res.getString(5);
                Integer submissionIdNumber = res.getInt(6);
                Integer reviewerId = res.getInt(7);
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
    @Override
    public ArrayList<Question> getQuestions(Integer reviewId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, question_number, question, review_id FROM questions WHERE review_id = ?;")){
            preparedStatement.setInt(1, reviewId);
            ResultSet res = preparedStatement.executeQuery();
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
    @Override
    public Integer getAuthor(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM authors WHERE user_id = ?")){
            preparedStatement.setInt(1, userId);
            ResultSet res = preparedStatement.executeQuery();
            res.next();
            Integer authorId =  res.getInt(1);

            res.close();
            return authorId;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public Integer getReviewer(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM reviewers WHERE user_id = ?")){
            preparedStatement.setInt(1, userId);
            ResultSet res = preparedStatement.executeQuery();
            res.next();
            Integer reviewerId =  res.getInt(1);

            res.close();
            return reviewerId;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public Integer getEditor(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM editors WHERE user_id =?;")){
            preparedStatement.setInt(1, userId);
            ResultSet res = preparedStatement.executeQuery();
            res.next();
            Integer editorId =  res.getInt(1);

            res.close();
            return editorId;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    /*
    do zmiany
    */
    @Override
    public ArrayList<Author> getSubmissionsCoAuthors(Integer submissionId) {
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, a.author_id, u.title, u.forname FROM SubmissionAuthor s INNER JOIN Author a ON a.Author_id=s.author_id INNER JOIN User u ON u.userID=a.userID")){
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






    @Override
    public Integer insertUser(String title, String forname, String surname, String university, String email, String password){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO users(title, forname, surname, university, email, password) " +
                    "VALUES(?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, forname);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, university);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.execute();
            ResultSet res = preparedStatement.getGeneratedKeys();
            Integer userId = 0;
            if(res.next()){
                userId = res.getInt(1);
            }
            return userId;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public Integer insertAuthor(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO authors(user_id) " +
                    "VALUES(?);", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, userId );
            preparedStatement.execute();

            ResultSet res = preparedStatement.getGeneratedKeys();
            Integer authorId = 0;
            if(res.next()){
                authorId = res.getInt(1);
            }
            return authorId;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public Integer insertEditor(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO editors(user_id) " +
                    "VALUES(?);", Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, userId );
            preparedStatement.execute();
            ResultSet res = preparedStatement.getGeneratedKeys();
            Integer editorId = 0;
            if(res.next()){
                editorId = res.getInt(1);
            }
            return editorId;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    @Override
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
    public Integer insertSubmission(String title, String abstractText, String draftArticle, Integer authorId, String issn) {
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO submissions(title, abstract, draft_article, ISSN, author_id) " +
                    "VALUES(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, abstractText);
            preparedStatement.setString(3, draftArticle);
            preparedStatement.setString(4, issn);
            preparedStatement.setInt(5, authorId);
            preparedStatement.execute();
            ResultSet res = preparedStatement.getGeneratedKeys();
            Integer submissionId = 0;
            if(res.next()){
                submissionId = res.getInt(1);
            }

            return submissionId;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
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
    @Override
    public User getUserToLogin(String email, String password){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, email, title, forname, surname, university FROM users WHERE email = ? and password = ?")){
            preparedStatement.setString(1, email);
            preparedStatement.setString(1, password);
            ResultSet res = preparedStatement.executeQuery();
            User user = null;
            if(res.next()){
                Integer userId =  res.getInt(1);
                String emailUser = res.getString(2);
                String title = res.getString(3);
                String forname = res.getString(4);
                String surname = res.getString(5);
                String university = res.getString(6);

               user =  new User(userId, title,forname,surname,university,emailUser);
            }


            res.close();
            return user;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
