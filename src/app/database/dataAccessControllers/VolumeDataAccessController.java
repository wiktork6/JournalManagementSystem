package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Volume;
import java.sql.*;

public class VolumeDataAccessController extends GenericDataAccessController<Volume> {

    @Override
    protected String getTableName() {
        return "volumes";
    }

    @Override
    protected String getAllFields() {
        return "id, volume_number, number_of_editions, year_of_publication, journal_id";
    }

    @Override
    protected Volume readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
        Integer volumeNumber = res.getInt(2);
        Integer numberOfEditions = res.getInt(3);
        String yearOfPublication = res.getString(4);
        Integer journalId = res.getInt(5);
        return new Volume(id, volumeNumber, numberOfEditions, yearOfPublication, journalId);
    }

    @Override
    protected String getModifyFields() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Integer setModifyPreparedStatement(PreparedStatement preparedStatement, Volume volume) throws SQLException {
        throw new UnsupportedOperationException();
    }
}