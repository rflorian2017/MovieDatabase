package com.rosu.db;

import com.rosu.util.DatatypeMapper;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseWrapper {
    private Connection connection;

    /**
     * @param url      used to connect to the database
     * @param user     to connect to database
     * @param password to connect to database
     * @return a connection to the database
     * @throws SQLException
     */
    public Connection createConnection(String url, String user, String password) throws SQLException {
        /**
         * used to open a connection to a database
         */
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }


    /**
     * This method takes as input a class and cycles through its fields, generates the query string and then creates the table dynamically
     * You need to know the mapping between java types and sql types
     * e.g., a query should look like this
     * id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
     * "year INTEGER , " +
     * "name TEXT NOT NULL
     *
     * @param table
     * @throws SQLException
     */
    public void createTable(Class table) throws SQLException {
        // statement created from a JDBC connection
        Statement statement = connection.createStatement();
        String columns = "";
        // use reflection to get fields of a class
        int counter = 0;
        for (Field field : table.getDeclaredFields()) {
            counter++;
            String fieldName = field.getName();
            // TODO : !!! Don't forget the case when the field name contains ai or pk
            // TODO : assume that all the primary keys have id in name , are of type  id_pk
            boolean appendType = false;
            if (fieldName.contains("pk")) {
                fieldName = fieldName.replace("_pk", DatatypeMapper.attributeDecorators.get("pk"));
                fieldName = fieldName.replace("id", "id " + DatatypeMapper.javaToSqlTypes.get(field.getType().getSimpleName()));
                appendType = true;
            }
            else {

            }
            if (fieldName.contains("ai")) {
                fieldName = fieldName.replace("_ai", DatatypeMapper.attributeDecorators.get("ai"));
            }


            columns += fieldName + " " + (appendType?"":DatatypeMapper.javaToSqlTypes.get(field.getType().getSimpleName())) +
                    (counter == table.getDeclaredFields().length ? "" : ",");
        }

        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " + table.getSimpleName() + "(" + columns + ") "
        );
    }

    public void dropTable(Class table) throws SQLException {
        Statement statement = connection.createStatement();

        statement.executeUpdate("DROP TABLE IF EXISTS " + table.getSimpleName());
    }

    public void insertRecord(String movieName, int year) throws SQLException {
        /*
        INSERT INTO table_name (column1, column2, column3) VALUES (val1, val2, val3)
         */
        PreparedStatement statement = connection.prepareStatement("INSERT INTO movies (name, year) VALUES (?,?)");

        statement.setString(1, movieName);
        statement.setInt(2, year);

        statement.executeUpdate();

    }

    public void deleteRecords() throws SQLException {

        Statement statement = connection.createStatement();

        statement.executeUpdate("DELETE FROM movies");

    }

    public void deleteRecord(String movieName) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("DELETE FROM movies WHERE name = ?");

        statement.setString(1, movieName);

        statement.executeUpdate();

    }

    public List<String> showAllRecords() throws SQLException {
        List<String> movies = new ArrayList<>();
        Statement statement = connection.createStatement();

        ResultSet moviesDb = statement.executeQuery("SELECT * FROM movies");
        while (moviesDb.next()) {
            movies.add(moviesDb.getString("name"));
        }

        return movies;

    }


}
