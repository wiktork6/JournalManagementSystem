package app.database.dataAccessControllers.generic;

import app.database.DbConnection;
import app.pojo.Identifiable;

import java.sql.*;
import java.util.ArrayList;

public abstract class GenericDataAccessController<Item extends Identifiable> implements DataAccessController<Item> {

    protected ArrayList<Item> getItems(String queryString, ArrayList<KVPair> filters) {
        try (Connection conn = DriverManager.getConnection(DbConnection.STRING);
             PreparedStatement preparedStatement = getPreparedStatement(filters, conn, queryString)) {

            ResultSet res = preparedStatement.executeQuery();
            ArrayList<Item> itemsList = new ArrayList<>();

            while (res.next()) {
                Item item = readItem(res);

                itemsList.add(item);
            }
            res.close();
            return itemsList;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    protected Item getItem(String queryString, ArrayList<KVPair> filters){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = this.getPreparedStatement(filters, conn, queryString)){
            ResultSet res = preparedStatement.executeQuery();


            if(res.next()) {
                return this.readItem(res);
            }
            else {
                return null;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Item> getItemsWhere(ArrayList<KVPair> filters) {
        return this.getItems(this.getItemsWhereQueryString(filters), filters);
    }

    @Override
    public ArrayList<Item> getItems(){
        return this.getItems(this.getItemsQueryString(), null);
    }

//    public ArrayList<Item> getItemsIndex() {return this.getItems(
//            this.getItemsQueryString(
//                    this.getIndexFields()
//            ), null);}

    @Override
    public Item getItemWhere(ArrayList<KVPair> filters){
        return this.getItem(this.getItemsWhereQueryString(filters), filters);
    }

    @Override
    public Item getItem(Integer id) {
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("id", id));
        return this.getItemWhere(filters);
    }


    private PreparedStatement getPreparedStatement(ArrayList<KVPair> filters, Connection conn, String queryString) throws SQLException {
        queryString = queryString + ";";
        if(filters == null || filters.size() == 0) {
            return conn.prepareStatement(queryString);
        }

        else {
            PreparedStatement preparedStatement = conn.prepareStatement(queryString);

            for(int i = 0; i < filters.size(); i++){
                preparedStatement.setObject(i+1, filters.get(i).getValue());
            }
            return preparedStatement;
        }

    }

    protected Integer addItem(Item item, String queryString) {
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(queryString + ";", Statement.RETURN_GENERATED_KEYS)){
            this.setInsertPreparedStatement(preparedStatement, item);
            preparedStatement.execute();
            ResultSet res = preparedStatement.getGeneratedKeys();

            Integer id = null;
            if(res.next()){
                id = res.getInt(1);
            }
            return id;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer addItem(Item item){
        return this.addItem(item, this.insertItemQueryString());
    }


    protected Integer updateItem(Item item, String queryString){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(queryString + ";")){
            int lastSetId = this.setUpdatePreparedStatement(preparedStatement, item);
            preparedStatement.setInt(lastSetId + 1, item.getId());

            return preparedStatement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer updateItem(Item item){
        return this.updateItem(item, this.updateItemByIdQueryString());
    }

    public Integer removeItem(Integer id){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(this.deleteItemQueryString() + ";")){
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    protected abstract String getTableName();
    protected abstract String getAllFields();
    protected String getIndexFields(){
        return "id";
    }


    protected String getItemsQueryString(String fields){
        return "SELECT " + fields + " FROM " + this.getTableName();
    }
    protected String getItemsQueryString(){
        return this.getItemsQueryString(this.getAllFields());
    }

    protected String getItemsWhereQueryString(ArrayList<KVPair> filters){
        return appendWhereToQueryString(getItemsQueryString(), filters);
    }

    protected String appendWhereToQueryString(String queryString, ArrayList<KVPair> filters){
        StringBuilder sb = new StringBuilder(queryString).append(" WHERE ");

        sb.append(filters.get(0).getKey()).append(" = ? ");
        for(int i = 1; i < filters.size(); i++){
            sb.append(" and ").append(filters.get(i).getKey()).append("= ? ");
        }

        return sb.toString();
    }

    protected String getItemsLikeQueryString(ArrayList<KVPair> filters){
        StringBuilder queryString = new StringBuilder(getItemsQueryString());

        queryString.append(filters.get(0).getKey()).append(" LIKE %?%");
        for(int i = 1; i < filters.size(); i++){
            queryString.append(" and ").append(filters.get(i).getKey()).append(" LIKE %?%");
        }

        return queryString.toString();
    }

    protected String updateItemsQueryString(ArrayList<KVPair> updates){
        StringBuilder queryString = new StringBuilder().append("UPDATE ").append(this.getTableName()).append(" SET ");
        queryString.append(updates.get(0).getKey()).append(" = ? ");
        for(int i = 1; i < updates.size(); i++){
            queryString.append(" , ").append(updates.get(i).getKey()).append(" = ? ");
        }
        return queryString.toString();
    }

    protected String updateItemsWhereQueryString(ArrayList<KVPair> updates, ArrayList<KVPair> filters){
        return appendWhereToQueryString(updateItemsQueryString(updates), filters);
    }

    protected String updateItemByIdQueryString(String updateFields){
        String[] fields = updateFields.split(",");
        ArrayList<KVPair> updates = new ArrayList<>();
        for(String field : fields){
            updates.add(new KVPair(field));
        }
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("id"));
        return updateItemsWhereQueryString(updates, filters);
    }

    protected String updateItemByIdQueryString(){
        return this.updateItemByIdQueryString(this.getUpdateFields());
    }

    protected String deleteItemQueryString() {
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("id"));
        return this.appendWhereToQueryString("DELETE FROM " + this.getTableName(), filters);
    }


    protected abstract Item readItem(ResultSet res) throws SQLException;

    protected abstract String getInsertFields();
    protected String getUpdateFields(){
        return this.getInsertFields();
    }

    protected String insertItemQueryString(){
        int amountOfQuestionMarks = this.getInsertFields().split(",").length;
        String questionMarks = "?,".repeat(Math.max(0, amountOfQuestionMarks));
        return "INSERT INTO " + getTableName() + "(" + this.getInsertFields() + ") VALUES(" + questionMarks.substring(0, questionMarks.length() -1) +")";
    }
    protected abstract Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Item item) throws SQLException;
    protected Integer setUpdatePreparedStatement(PreparedStatement preparedStatement, Item item) throws SQLException {
        return this.setInsertPreparedStatement(preparedStatement, item);
    }

}
