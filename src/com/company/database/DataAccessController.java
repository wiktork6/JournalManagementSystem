package com.company.database;

import com.company.users.User;

import java.sql.*;

public class DataAccessController {
    private static String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";
    private static String DB_TEST = "jdbc:mysql://localhost:3306/test";
    private static String USERNAME_TEST = "root";
    private static String PASSWORD_TEST = "dupeczka1.";


    private static Connection openConnection() throws SQLException{
            return DriverManager.getConnection(DB);
    }

    private static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }


    public static boolean insertUser(User user) {
        Connection conn = null;
        try {
            conn = openConnection();
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO users(email, title, forname, surname, university, password) " +
                    "VALUES(" + user.getEmail() + ", " + user.getTitle() + ", " + user.getForname() + ", " + user.getSurname() + ", " + user.getUniversity() + ", " + user.getPassword());
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if(conn!=null)
                closeConnection(conn);
        }
    }


    public ResultSet getUsers(){
        try(Connection conn = DriverManager.getConnection(DB);
            Statement statement = conn.createStatement()){
            statement.execute("SELECT email FROM Users");

            return statement.getResultSet();

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }


}
