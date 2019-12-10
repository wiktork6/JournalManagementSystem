package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.*;
import java.sql.*;
import java.util.ArrayList;

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
    protected String getIndexFields() {
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

    public boolean insertJournalEditor(Integer journalId, Integer editorId) {
        try (Connection conn = DriverManager.getConnection(DbConnection.STRING);
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO journal_editor(journal_id, editor_id) " +
                     "VALUES(?,?);")) {

            preparedStatement.setInt(1, journalId);
            preparedStatement.setInt(2, editorId);

            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Journal> getEditorsJournals(Editor editor) {
        try (Connection conn = DriverManager.getConnection(DbConnection.STRING);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT j.id, j.ISSN, j.name_of_journal, j.chief_editor_id FROM journals j LEFT JOIN journal_editor je ON j.id = je.journal_id WHERE je.editor_id = ?;")) {

            preparedStatement.setInt(1, editor.getId());
            ArrayList<Journal> listOfJournal = new ArrayList<>();
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                listOfJournal.add(readItem(res));
            }


            return listOfJournal;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean deleteEditorFromJournal(Editor editor, Journal journal){
        try (Connection conn = DriverManager.getConnection(DbConnection.STRING);
             PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM journal_editor WHERE editor_id = ? and journal_id = ?")) {

            preparedStatement.setInt(1, editor.getId());
            preparedStatement.setInt(2, journal.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Integer submissionsEditorAffiliationOverlap(String university, Integer journalId){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(*) FROM submissions " +
                            "INNER JOIN authors ON authors.id = submissions.author_id " +
                            "LEFT JOIN submission_author as sa ON sa.submission_id = submissions.id " +
                            "INNER JOIN authors as a ON a.id = sa.author_id " +
                            "INNER JOIN users ON users.id = authors.user_id OR users.id = a.user_id " +
                            "INNER JOIN journals ON journals.id = submissions.journal_id " +
                            "WHERE LOWER(users.university) = LOWER(?) " +
                            "AND journals.id = ? ")){
            preparedStatement.setString(1, university);
            preparedStatement.setInt(2, journalId);

            ResultSet res = preparedStatement.executeQuery();
            res.next();
            return res.getInt(1);
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
