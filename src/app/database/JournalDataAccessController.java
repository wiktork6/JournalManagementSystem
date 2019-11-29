package app.database;

import app.database.generic.GenericDataAccessController;
import app.pojo.*;
import java.sql.*;

public class JournalDataAccessController extends GenericDataAccessController<Journal> {

    @Override
    protected String getItemsQueryString() {
        return "SELECT ISSN, name_of_journal, number_of_volumes, chief_editor_id FROM journals";
    }

    @Override
    protected Journal readItem(ResultSet res) throws SQLException {
        String issn = res.getString(1);
        String name = res.getString(2);
        Integer numberOfVolumes = res.getInt(3);
        Integer chiefEditorId = res.getInt(4);
        return new Journal(issn, name, numberOfVolumes, chiefEditorId);
    }

    @Override
    protected String insertItemQueryString() {
        return "INSERT INTO journals(ISSN, name_of_journal, number_of_volumes, chief_editor_id) VALUES(?,?,?,?)";
    }

    @Override
    protected void setInsertPreparedStatement(PreparedStatement preparedStatement, Journal journal) throws SQLException {
        preparedStatement.setString(1, journal.getIssn());
        preparedStatement.setString(2, journal.getName());
        preparedStatement.setInt(3, journal.getNumberOfVolumes());
        preparedStatement.setInt(4, journal.getChiefEditorId());
    }

    public boolean insertJournalEditor(String journalId, Integer editorId) {
        try(Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO journal_editor(ISSN, editor_id) " +
                    "VALUES(?,?);")){

            preparedStatement.setString(1, journalId);
            preparedStatement.setInt(2, editorId);

            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
