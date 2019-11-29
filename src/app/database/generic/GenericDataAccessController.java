package app.database;

import app.database.databaseInterfaces.DataAccessController;

import java.sql.*;
import java.util.ArrayList;

public abstract class GenericDataAccessController<Item> implements DataAccessController<Item> {

    protected ArrayList<Item> getItems(String queryString, Object filterValue) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
             PreparedStatement preparedStatement = getPreparedStatement(filterValue, conn, queryString)) {
            ResultSet res = preparedStatement.executeQuery(queryString);
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

    private PreparedStatement getPreparedStatement(Object filterValue, Connection conn, String queryString) throws SQLException {
        if(filterValue == null) {
            return conn.prepareStatement(queryString);
        }

        else {
            PreparedStatement preparedStatement = conn.prepareStatement(queryString);
            preparedStatement.setObject(1, filterValue);
            return preparedStatement;
        }

    }

    @Override
    public ArrayList<Item> getItemsWhere(String filterName, Object filterValue) {
        return this.getItems(this.getItemsWhereQueryString(filterName) + ";", filterValue);
    }


    public ArrayList<Item> getItems(){
        return this.getItems(this.getItemsQueryString(), null);
    }


    protected abstract String getItemsQueryString();
    protected String getItemsWhereQueryString(String filterName){
        return getItemsQueryString() + "WHERE" + filterName + "= ?";
    }


    protected abstract Item readItem(ResultSet res) throws SQLException;

    @Override
    public Item getItemWhere(String filterName, Object filterValue){
        try(Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(this.getItemsWhereQueryString(filterName) + ";")){
            ResultSet res = preparedStatement.executeQuery();
            preparedStatement.setObject(1, filterValue);

            return this.readItem(res);
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Item getItem(Object id) {
        return this.getItemWhere("id", id);
    }

    protected abstract String insertItemQueryString();
    protected abstract void setInsertPreparedStatement(PreparedStatement preparedStatement, Item item) throws SQLException;

    @Override
    public Integer addItem(Item item) {
        try(Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(this.insertItemQueryString() + ";", Statement.RETURN_GENERATED_KEYS)){
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

}
