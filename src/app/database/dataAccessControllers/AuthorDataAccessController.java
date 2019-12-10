package app.database.dataAccessControllers;

import app.database.DbConnection;
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
    protected String getInsertFields() {
        return "user_id";
    }


    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Author author) throws SQLException {
        preparedStatement.setInt(1, author.getUser().getId() );
        return 1;
    }

    public boolean insertCoAuthor(Integer articleId, Integer authorId) {
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO article_author(article_id, author_id) " +
                    "VALUES(?,?);")){

            preparedStatement.setInt(1, articleId);
            preparedStatement.setInt(2, authorId);

            preparedStatement.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
