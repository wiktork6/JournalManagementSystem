package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Edition;

import java.sql.*;

public class EditionDataAccessController extends GenericDataAccessController<Edition> {

    @Override
    protected String getTableName() {
        return "editions";
    }

    @Override
    protected String getAllFields() {
        return "id, edition_number, month_of_publication, volume_id";
    }

    @Override
    protected String getIndexFields(){
        return "id, edition_number";
    }

    @Override
    protected Edition readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
        Integer editionNumber = res.getInt(2);
        String monthOfPublication = res.getString(3);
        Integer volumeIdNumber = res.getInt(4);
        return new Edition(id, editionNumber, monthOfPublication, volumeIdNumber);
    }

    @Override
    protected String getInsertFields() {
        return "edition_number, month_of_publication, volume_id";
    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Edition edition) throws SQLException {
        preparedStatement.setInt(1,edition.getEdition_number());
        preparedStatement.setString(2,edition.getMonthOfPublication());
        preparedStatement.setInt(3,edition.getVolumeId());
        return 3;
    }
}
