package app.database;

import app.database.dataAccessControllers.Tools.Encryption;

import java.sql.*;

public class CreateDb {
    public static void main(String[] args) {
        createTables();
    }

    public static void createDatabase(){
        try(Connection conn = DriverManager.getConnection(DbConnection.SERVER_URL, DbConnection.USERNAME, DbConnection.PASSWORD);
            Statement statement = conn.createStatement()) {
            //statement.execute("DROP DATABASE IF EXISTS " + DbConnection.NAME + ";");
            statement.execute("CREATE DATABASE IF NOT EXISTS " + DbConnection.NAME + ";");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public static void createTables() {

        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            Statement statement = conn.createStatement()){

            //Creating users table
            statement.execute("CREATE TABLE IF NOT EXISTS users(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "email VARCHAR (50) NOT NULL UNIQUE, " +
                    "title VARCHAR (5), " +
                    "forname VARCHAR (30), " +
                    "surname VARCHAR (30), " +
                    "university VARCHAR (50), " +
                    "password VARCHAR (" + Encryption.PASSWORD_FIELD_LENGTH + ") NOT NULL, " +
                    "PRIMARY KEY (id))");

            //Creating authors table
            statement.execute("CREATE TABLE IF NOT EXISTS authors(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "user_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (user_id) REFERENCES users(id), " +
                    "PRIMARY KEY (id))");

            //Creating editors table
            statement.execute("CREATE TABLE IF NOT EXISTS editors(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "user_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (user_id) REFERENCES users(id), " +
                    "PRIMARY KEY (id))");

            //Creating reviewers table
            statement.execute("CREATE TABLE IF NOT EXISTS reviewers(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "user_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (user_id) REFERENCES users(id), " +
                    "PRIMARY KEY (id))");
            //Creating journals table
            statement.execute("CREATE TABLE IF NOT EXISTS journals(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "ISSN VARCHAR(8) NOT NULL UNIQUE, " +
                    "name_of_journal VARCHAR(50) NOT NULL UNIQUE, " +
                    "chief_editor_id INTEGER, " +
                    "FOREIGN KEY(chief_editor_id) REFERENCES editors(id), " +
                    "PRIMARY KEY(id))");
            // Creating submissions table
            statement.execute("CREATE TABLE IF NOT EXISTS submissions(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "abstract TINYTEXT, " +
                    "draft_article LONGBLOB, " +
                    "journal_id INTEGER, " +
                    "author_id INTEGER, " +
                    "status VARCHAR(20), " +
                    "reviews_selected INTEGER DEFAULT 0," +
                    "FOREIGN KEY (author_id) REFERENCES authors(id), " +
                    "FOREIGN KEY (journal_id) REFERENCES journals(id), " +
                    "PRIMARY KEY(id))");

            // Creating reviews table
            statement.execute("CREATE TABLE IF NOT EXISTS reviews(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "review_summary TEXT, " +
                    "typographical_errors TINYTEXT, " +
                    "initial_verdict VARCHAR(50), " +
                    "final_verdict VARCHAR(50), " +
                    "submission_id INTEGER NOT NULL, " +
                    "reviewer_id INTEGER NOT NULL, " +
                    "FOREIGN KEY (submission_id) REFERENCES submissions(id), " +
                    "FOREIGN KEY (reviewer_id) REFERENCES reviewers(id), " +
                    "PRIMARY KEY(id))");


            //Creating questions table
            statement.execute("CREATE TABLE IF NOT EXISTS questions(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "question_number INTEGER NOT NULL, " +
                    "question VARCHAR(255), " +
                    "response VARCHAR(255), " +
                    "is_answered BOOLEAN, " +
                    "review_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(review_id) REFERENCES reviews(id), " +
                    "PRIMARY KEY(id))");



            //Creating journal_editor table
            statement.execute("CREATE TABLE IF NOT EXISTS journal_editor(" +
                    "journal_id INTEGER NOT NULL, " +
                    "editor_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(journal_id) REFERENCES journals(id), " +
                    "FOREIGN KEY(editor_id) REFERENCES editors(id), " +
                    "PRIMARY KEY(journal_id, editor_id))");

            //Creating volumes table
            statement.execute("CREATE TABLE IF NOT EXISTS volumes(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "volume_number INTEGER NOT NULL, " +
                    "number_of_editions INTEGER, " +
                    "year_of_publication VARCHAR(4), " +
                    "journal_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(journal_id) REFERENCES journals(id), " +
                    "PRIMARY KEY(id))");

            //Creating editions table
            statement.execute("CREATE TABLE IF NOT EXISTS editions(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "edition_number INTEGER NOT NULL, " +
                    "month_of_publication VARCHAR(20), " + //ENUM
                    "volume_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(volume_id) REFERENCES volumes(id), " +
                    "PRIMARY KEY(id))");

            //Creating articles table
            statement.execute("CREATE TABLE IF NOT EXISTS articles(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "page_number_range VARCHAR(7) NOT NULL, " +
                    "abstract TINYTEXT, " +
                    "title VARCHAR(255), " +
                    "final_full_article LONGBLOB, " +
                    "main_author_id INTEGER NOT NULL, " +
                    "edition_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(main_author_id) REFERENCES authors(id), " +
                    "FOREIGN KEY(edition_id) REFERENCES editions(id), " +
                    "PRIMARY KEY(id))");

            //Creating article_author table
            statement.execute("CREATE TABLE IF NOT EXISTS article_author(" +
                    "article_id INTEGER NOT NULL, " +
                    "author_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(article_id) REFERENCES articles(id), " +
                    "FOREIGN KEY(author_id) REFERENCES authors(id), " +
                    "PRIMARY KEY(article_id, author_id))");
            //Creating submission_author table
            statement.execute("CREATE TABLE IF NOT EXISTS submission_author(" +
                    "submission_id INTEGER NOT NULL, " +
                    "author_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(submission_id) REFERENCES submissions(id), " +
                    "FOREIGN KEY(author_id) REFERENCES authors(id), " +
                    "PRIMARY KEY(submission_id, author_id))");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
