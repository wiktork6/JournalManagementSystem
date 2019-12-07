package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.Tools.Encryption;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.*;
import java.sql.*;
import java.util.ArrayList;

public class UserDataAccessController extends GenericDataAccessController<User> {

    @Override
    protected String getTableName() {
        return "users";
    }

    @Override
    protected String getAllFields() {
        return "id, email, title, forname, surname, university";
    }

    @Override
    protected String getIndexFields() {
        return "id, email";
    }

    public void saltPassword(User item) {
        item.setPassword(this.getSaltedPassword(item.getPassword()));
    }

    public String getSaltedPassword( String password){
        return Encryption.SALT_WORD  + password;
    }

    public Integer getUserId(String email) {
        try (Connection conn = DriverManager.getConnection(DbConnection.STRING);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM users WHERE email = ?;")) {
            preparedStatement.setString(1, email);
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
    protected User readItem(ResultSet res) throws SQLException {
        Integer userId = res.getInt(1);
        String email = res.getString(2);
        String title = res.getString(3);
        String forname = res.getString(4);
        String surname = res.getString(5);
        String university = res.getString(6);
        return new User(userId, title, forname, surname, university, email);
    }

    @Override
    protected String getInsertFields() {
        return this.getUpdateFields() + ", password";
    }

    @Override
    protected String getUpdateFields() {
        return "title, forname, surname, university, email";
    }

    @Override
    public Integer updateItem(User item) {
        if (item.getPassword() != null) {
            return super.updateItem(item, this.updateItemByIdQueryString(this.getUpdateFields() + ", password"));
        }
        return super.updateItem(item);

    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getTitle());
        preparedStatement.setString(2, user.getForname());
        preparedStatement.setString(3, user.getSurname());
        preparedStatement.setString(4, user.getUniversity());
        preparedStatement.setString(5, user.getEmail());
        if (user.getPassword() != null) {
            preparedStatement.setString(6, getSaltedPassword(user.getPassword()));
            return 6;
        }
        return 5;
    }

    @Override
    public Integer addItem(User item) {
        return super.addItem(item,
                "INSERT INTO " + this.getTableName() + "(" + this.getInsertFields() + ") VALUES(?, ?, ?, ?, ?, " + Encryption.HASHED_QUESTION_MARK + ")");
    }


    @Override
    protected String appendWhereToQueryString(String queryString, ArrayList<KVPair> filters) {
        StringBuilder sb = new StringBuilder(queryString).append(" WHERE ");

        sb.append(filters.get(0).getKey()).append(" = ? ");
        for (int i = 1; i < filters.size(); i++) {
            sb.append(" and ").append(filters.get(i).getKey());
            if (filters.get(i).getKey().trim().equals("password")) {
                sb.append(" = ").append(Encryption.HASHED_QUESTION_MARK);
            } else {
                sb.append("= ? ");
            }
        }

        return sb.toString();
    }

    @Override
    protected String updateItemsQueryString(ArrayList<KVPair> updates) {
        StringBuilder queryString = new StringBuilder().append("UPDATE ").append(this.getTableName()).append(" SET ");
        queryString.append(updates.get(0).getKey()).append(" = ? ");
        for (int i = 1; i < updates.size(); i++) {
            queryString.append(", ").append(updates.get(i).getKey());
            if (updates.get(i).getKey().trim().equals("password")) {
                queryString.append(" = ").append(Encryption.HASHED_QUESTION_MARK);
            } else {
                queryString.append("= ? ");
            }
        }
        return queryString.toString();
    }

}
