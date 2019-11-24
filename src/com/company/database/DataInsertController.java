package com.company.database;

import com.company.submission.Submission;
import com.company.users.User;
import com.company.users.author.Author;

import java.sql.*;
import java.util.ArrayList;

public class DataInsertController {
    private static String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";
    private static String DB_TEST = "jdbc:mysql://localhost:3306/test";
    private static String USERNAME_TEST = "root";
    private static String PASSWORD_TEST = "dupeczka1.";


    public static boolean insertSubmission(Submission submission){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            Statement statement = conn.createStatement()){

            statement.execute("INSERT INTO submissions(title, abstract, draft_article, author_id) " +
                    "VALUES('" +submission.getTitle() + "', '"  + submission.getAbstractText() + "', '" + submission.getDraftArticle() + "', '" + submission.getAuthorId() + "');");
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean insertNewAuthor(Integer userId){
        try(Connection conn = DriverManager.getConnection(DB_TEST,USERNAME_TEST,PASSWORD_TEST);
            Statement statement = conn.createStatement()){

            statement.execute("INSERT INTO authors(user_id) " +
                    "VALUES(" + userId + ");");
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

}
