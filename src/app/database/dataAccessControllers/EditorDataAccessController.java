package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.User;

import java.sql.*;
import java.util.ArrayList;

public class EditorDataAccessController extends GenericDataAccessController<Editor> {
    @Override
    protected String getTableName() {
        return "editors";
    }

    @Override
    protected String getAllFields() {
        return "id, user_id";
    }

    @Override
    protected Editor readItem(ResultSet res) throws SQLException {
        Integer id =  res.getInt(1);
        Integer userId =  res.getInt(2);
        return new Editor(id, userId);
    }

    @Override
    protected String getInsertFields() {
        return "user_id";
    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Editor editor) throws SQLException {
        preparedStatement.setInt(1, editor.getUser().getId());
        return 1;
    }

    public ArrayList<Editor> getJournalsEditors(Journal journal) {
        try (Connection conn = DriverManager.getConnection(DbConnection.STRING);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT u.title, u.forname, u.surname, u.university, u.email, u.id, e.id FROM users u INNER JOIN editors e ON u.id = e.user_id INNER JOIN journal_editor je ON je.editor_id = e.id WHERE je.journal_id = ?;")) {
            preparedStatement.setInt(1,journal.getId());

            ResultSet res = preparedStatement.executeQuery();
            User user = null;
            Editor editor = null;
            ArrayList<Editor> listOfEditors = new ArrayList<>();
            while(res.next()){
                String title  = res.getString(1);
                String forname  = res.getString(2);
                String surname  = res.getString(3);
                String university  = res.getString(4);
                String email  = res.getString(5);
                Integer userId  = res.getInt(6);
                Integer editorId  = res.getInt(7);
                user = new User(userId,title,forname,surname,university,email);
                editor = new Editor(editorId);
                editor.setUser(user);
                listOfEditors.add(editor);
            }
            return listOfEditors;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
