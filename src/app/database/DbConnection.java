package app.database;

public class DbConnection {
   public static String NAME = "test";
   public static String SERVER_URL = "jdbc:mysql://localhost:3306/";
   public static String USERNAME= "root";
   public static String PASSWORD = "123";


    // Use this STRING for local development
   public static String STRING = SERVER_URL + NAME + "?user=" + USERNAME + "&password=" + PASSWORD;

}
