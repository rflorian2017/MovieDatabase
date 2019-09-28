package com.rosu.db;

import com.rosu.constants.Constants;

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

    public void createTable() throws SQLException {
        // statement created from a JDBC connection
        Statement statement = connection.createStatement();

        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS movies " +
                        "(" +
                        "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "year INTEGER , " +
                        "name TEXT NOT NULL " +
                        ") "
        );
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
