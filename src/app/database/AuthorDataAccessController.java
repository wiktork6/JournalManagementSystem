package app.database;

import app.database.generic.GenericDataAccessController;
import app.pojo.Author;

import java.sql.*;

public class AuthorDataAccessController extends GenericDataAccessController<Author> {
    @Override
    protected String getItemsQueryString() {
        return "SELECT id FROM authors";
    }

    @Override
    protected Author readItem(ResultSet res) throws SQLException {
        Integer authorId =  res.getInt(1);
        Author author = new Author();
        author.setAuthorId(authorId);
        return author;
    }

    @Override
    protected String insertItemQueryString() {
        return "INSERT INTO authors(user_id) VALUES(?)";
    }

    @Override
    protected void setInsertPreparedStatement(PreparedStatement preparedStatement, Author author) throws SQLException {
        preparedStatement.setInt(1, author.getId() );

    }
}
