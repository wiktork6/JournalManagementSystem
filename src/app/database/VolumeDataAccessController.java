package app.database;

import app.pojo.Volume;

import java.sql.*;
import java.util.ArrayList;

public class EditionController {
    public ArrayList<Volume> getVolumes() {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
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
}
