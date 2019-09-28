package com.rosu.db;

import com.rosu.constants.Constants;

import java.sql.*;

public class DatabaseWrapper {
    private Connection connection;
    /**
     *
     * @param url used to connect to the database
     * @param user to connect to database
     * @param password to connect to database
     * @return a connection to the database
     * @throws SQLException
     */
    public Connection createConnection (String url, String user, String password) throws SQLException {
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
                        "name TEXT NOT NULL " +
                        ") "
        );
    }

    public void insertRecordBad(String movieName) throws SQLException {
        /*
        INSERT INTO table_name (column1, column2, column3) VALUES (val1, val2, val3)
         */
        Statement statement = connection.createStatement();
        statement.executeUpdate(
                "INSERT INTO movies " +
                        "(name)  VALUES ( '" + movieName + "') ");

    }

    public void insertRecord(String movieName) throws SQLException {
        /*
        INSERT INTO table_name (column1, column2, column3) VALUES (val1, val2, val3)
         */
        PreparedStatement statement = connection.prepareStatement("INSERT INTO movies (name) VALUES (?)");

        statement.setString(1, movieName);

        statement.executeUpdate();

    }
}
