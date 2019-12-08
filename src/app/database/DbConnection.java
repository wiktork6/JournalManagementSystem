package app.database;

public class DbConnection {
    public static String NAME = "test";
    public static String SERVER_URL = "jdbc:mysql://localhost:3306/";
    public static String USERNAME= "root";
    public static String PASSWORD = "bob4orba";
    //public static String PASSWORD = "dupeczka1.";

    // Use this STRING to access the provided database
    //public static String STRING = "jdbc:mysql://stusql.dcs.shef.ac.uk/team042?user=team042&password=7a66e0db";
    // Use this STRING for local development
    public static String STRING = SERVER_URL + NAME + "?user=" + USERNAME + "&password=" + PASSWORD;

}
