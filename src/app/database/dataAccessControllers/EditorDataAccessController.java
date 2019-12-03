package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Editor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
