package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.*;
import java.sql.*;

public class JournalDataAccessController extends GenericDataAccessController<Journal> {

    @Override
    protected String getTableName() {
        return "journals";
    }

    @Override
    protected String getAllFields() {
        return "id, ISSN, name_of_journal, chief_editor_id";
    }

    @Override
    protected String getIndexFields(){
        return "id, ISSN, namme_of_journal";
    }

    @Override
    protected Journal readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
        String issn = res.getString(2);
        String name = res.getString(3);
        Integer chiefEditorId = res.getInt(4);
        return new Journal(id, issn, name, chiefEditorId);
    }

    @Override
    protected String getInsertFields() {
        return "ISSN, name_of_journal, chief_editor_id";
    }


    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Journal journal) throws SQLException {
        preparedStatement.setString(1, journal.getIssn());
        preparedStatement.setString(2, journal.getName());
        preparedStatement.setInt(3, journal.getChiefEditorId());
        return 3;
    }

    public boolean insertJournalEditor(String journalId, Integer editorId) {
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO journal_editor(journal_id, editor_id) " +
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
