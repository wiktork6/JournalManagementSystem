package app.database;

import app.database.generic.GenericDataAccessController;
import app.pojo.*;
import java.sql.*;

public class UserDataAccessController extends GenericDataAccessController<User> {




    public Integer getUserId(String email) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM users WHERE email = ?;")) {
            preparedStatement.setString(1,email);
            ResultSet res = preparedStatement.executeQuery();
            int userId = 0;

            while (res.next()) {
                userId = res.getInt(1);
            }
            res.close();
            return userId;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    protected String getItemsQueryString() {
        return "SELECT id, email, title, forname, surname, university FROM users";
    }

    @Override
    protected User readItem(ResultSet res) throws SQLException {
        Integer userId = res.getInt(1);
        String email = res.getString(2);
        String title = res.getString(3);
        String forname = res.getString(4);
        String surname = res.getString(5);
        String university = res.getString(6);
        return new User(userId,title,forname,surname,university,email);
    }


    @Override
    protected String insertItemQueryString() {
        return "INSERT INTO users(title, forname, surname, university, email, password) VALUES(?,?,?,?,?,?)";
    }

    @Override
    protected void setInsertPreparedStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getTitle());
        preparedStatement.setString(2, user.getForname());
        preparedStatement.setString(3, user.getSurname());
        preparedStatement.setString(4, user.getUniversity());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getPassword());
    }
}
