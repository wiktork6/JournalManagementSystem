package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Edition;

import java.sql.*;

public class EditionDataAccessController extends GenericDataAccessController<Edition> {

    @Override
    protected String getItemsQueryString() {
        return "SELECT id, edition_number, month_of_publication, volume_id FROM editions";
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
    protected String insertItemQueryString() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void setInsertPreparedStatement(PreparedStatement preparedStatement, Edition edition) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
