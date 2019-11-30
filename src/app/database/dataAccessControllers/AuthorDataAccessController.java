package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Author;

import java.sql.*;

public class AuthorDataAccessController extends GenericDataAccessController<Author> {
    @Override
    protected String getTableName() {
        return "authors";
    }

    @Override
    protected String getAllFields() {
        return "id, user_id";
    }

    @Override
    protected Author readItem(ResultSet res) throws SQLException {
        Integer id =  res.getInt(1);
        Integer userId =  res.getInt(2);
        Author author = new Author(id, userId);
        return author;
    }

    @Override
    protected String getModifyFields() {
        return "user_id";
    }


    @Override
    protected Integer setModifyPreparedStatement(PreparedStatement preparedStatement, Author author) throws SQLException {
        preparedStatement.setInt(1, author.getUser().getId() );
        return 1;
    }
}
