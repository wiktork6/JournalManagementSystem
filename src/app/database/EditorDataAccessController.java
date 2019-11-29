package app.database;

import app.database.generic.GenericDataAccessController;
import app.pojo.Editor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditorDataAccessController extends GenericDataAccessController<Editor> {
    @Override
    protected String getItemsQueryString() {
        return "SELECT id FROM editors";
    }

    @Override
    protected Editor readItem(ResultSet res) throws SQLException {
        Integer editorId =  res.getInt(1);
        Editor editor = new Editor();
        editor.setEditorId(editorId);
        return editor;
    }

    @Override
    protected String insertItemQueryString() {
        return "INSERT INTO editors(user_id) VALUES(?)";
    }

    @Override
    protected void setInsertPreparedStatement(PreparedStatement preparedStatement, Editor editor) throws SQLException {
        preparedStatement.setInt(1, editor.getId());
    }
}
