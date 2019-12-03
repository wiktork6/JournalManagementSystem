package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Reviewer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewerDataAccessController extends GenericDataAccessController<Reviewer> {
    @Override
    protected String getTableName() {
        return "reviewers";
    }

    @Override
    protected String getAllFields() {
        return "id, user_id";
    }

    @Override
    protected Reviewer readItem(ResultSet res) throws SQLException {
        Integer id =  res.getInt(1);
        Integer userId =  res.getInt(2);
        return new Reviewer(id, userId);
    }

    @Override
    protected String getInsertFields() {
        return "user_id";
    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Reviewer reviewer) throws SQLException {
        preparedStatement.setInt(1, reviewer.getUser().getId());
        return 1;
    }
}
