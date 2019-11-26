package app.database;

import java.sql.*;

public class ConnectionToMySQL {
    private static String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";
    private static String DB_TEST = "jdbc:mysql://localhost:3306/test";
    private static String USERNAME_TEST = "root";
    private static String PASSWORD_TEST = "dupeczka1.";
    public static void main(String[] args) {


        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            Statement statement = conn.createStatement()){

            //Creating users table
            statement.execute("CREATE TABLE IF NOT EXISTS users(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "email VARCHAR (50) NOT NULL, " +
                    "title VARCHAR (5), " +
                    "forname VARCHAR (30), " +
                    "surname VARCHAR (30), " +
                    "university VARCHAR (50), " +
                    "password VARCHAR (100) NOT NULL, " +
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

            // Creating submissions table
            statement.execute("CREATE TABLE IF NOT EXISTS submissions(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "abstract TINYTEXT, " +
                    "draft_article TEXT, " +
                    "ISSN VARCHAR(8)" +
                    "author_id INTEGER, " +
                    "FOREIGN KEY (author_id) REFERENCES authors(id), " +
                    "FOREIGN KEY (ISSN) REFERENCES journals(ISSN), " +
                    "PRIMARY KEY (id))");

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
                    "review_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(review_id) REFERENCES reviews(id), " +
                    "PRIMARY KEY(id))");

            //Creating responses table
            statement.execute("CREATE TABLE IF NOT EXISTS reponses(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "response VARCHAR(255) NOT NULL, " +
                    "question_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(question_id) REFERENCES questions(id), " +
                    "PRIMARY KEY(id))");

            //Creating journals table
            statement.execute("CREATE TABLE IF NOT EXISTS journals(" +
                    "ISSN VARCHAR(8) NOT NULL, " +
                    "name_of_journal VARCHAR(50) NOT NULL" +
                    "number_of_volumes INTEGER, " +
                    "chief_editor_id INTEGER, " +
                    "FOREIGN KEY(chief_editor_id) REFERENCES editors(id), " +
                    "PRIMARY KEY(ISSN))");

            //Creating journal_editor table
            statement.execute("CREATE TABLE IF NOT EXISTS journal_editor(" +
                    "ISSN VARCHAR(8) NOT NULL, " +
                    "editor_id INTEGER NOT NULL, " +
                    "FOREIGN KEY(ISSN) REFERENCES journals(ISSN), " +
                    "FOREIGN KEY(editor_id) REFERENCES editors(id), " +
                    "PRIMARY KEY(ISSN, editor_id))");

            //Creating volumes table
            statement.execute("CREATE TABLE IF NOT EXISTS volumes(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "volume_number INTEGER NOT NULL, " +
                    "number_of_editions INTEGER, " +
                    "year_of_publication YEAR, " +
                    "ISSN VARCHAR(8) NOT NULL, " +
                    "FOREIGN KEY(ISSN) REFERENCES journals(ISSN), " +
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
                    "page_number_range VARCHAR(20) NOT NULL, " +
                    "abstract TINYTEXT, " +
                    "title VARCHAR(255), " +
                    "final_full_article TEXT, " +
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
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
