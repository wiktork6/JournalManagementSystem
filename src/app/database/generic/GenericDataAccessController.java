package app.database.generic;

import app.database.DbConnection;
import app.database.generic.DataAccessController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDataAccessController<Item> implements DataAccessController<Item> {

    protected ArrayList<Item> getItems(String queryString, ArrayList<Filter> filters) {
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
             PreparedStatement preparedStatement = getPreparedStatement(filters, conn, queryString)) {
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

    @Override
    public ArrayList<Item> getItemsWhere(ArrayList<Filter> filters) {
        return this.getItems(this.getItemsWhereQueryString(filters) + ";", filters);
    }


    public ArrayList<Item> getItems(){
        return this.getItems(this.getItemsQueryString(), null);
    }


    private PreparedStatement getPreparedStatement(ArrayList<Filter> filters, Connection conn, String queryString) throws SQLException {
        if(filters == null || filters.size() == 0) {
            return conn.prepareStatement(queryString);
        }

        else {
            PreparedStatement preparedStatement = conn.prepareStatement(queryString);
            for(int i = 0; i < filters.size(); i++){
                preparedStatement.setObject(i+1, filters.get(i).getFilterValue());
            }

            return preparedStatement;
        }

    }
    protected abstract String getItemsQueryString();
    protected String getItemsWhereQueryString(ArrayList<Filter> filters){
        StringBuilder queryString = new StringBuilder(getItemsQueryString()).append(" WHERE ");

        queryString.append(filters.get(0).getFilterName()).append(" = ? ");
        for(int i = 1; i < filters.size(); i++){
            queryString.append(" and ").append(filters.get(i).getFilterName()).append(" = ? ");
        }

        return queryString.toString();
    }


    protected abstract Item readItem(ResultSet res) throws SQLException;

    @Override
    public Item getItemWhere(ArrayList<Filter> filters){
        try(Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USERNAME, DbConnection.PASSWORD);
            PreparedStatement preparedStatement = this.getPreparedStatement(filters, conn, this.getItemsWhereQueryString(filters))){
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
    public Item getItem(Object id) {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("id", id));
        return this.getItemWhere(filters);
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
