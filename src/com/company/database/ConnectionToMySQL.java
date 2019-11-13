package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToMySQL {
    public static void main(String[] args) {
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";

        try(Connection conn = DriverManager.getConnection(DB);
            Statement statement = conn.createStatement()){
            statement.execute("CREATE TABLE users(forname TEXT, surname TEXT)");


        }catch(SQLException ex){
            ex.printStackTrace();
        }


    }

}
