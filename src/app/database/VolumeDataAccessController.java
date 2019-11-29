package app.database;

import app.database.generic.GenericDataAccessController;
import app.pojo.Volume;
import java.sql.*;

public class VolumeDataAccessController extends GenericDataAccessController<Volume> {

    @Override
    protected String getItemsQueryString() {
        return "SELECT id, volume_number, number_of_editions, year_of_publication, ISSN FROM volumes";
    }


    @Override
    protected Volume readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
        Integer volumeNumber = res.getInt(2);
        Integer numberOfEditions = res.getInt(3);
        String yearOfPublication = res.getString(4);
        String issn = res.getString(5);
        return new Volume(id, volumeNumber, numberOfEditions, yearOfPublication, issn);
    }

    @Override
    protected String insertItemQueryString() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void setInsertPreparedStatement(PreparedStatement preparedStatement, Volume volume) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
