package com.rosu.db;

import com.rosu.constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseWrapper {

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
        return DriverManager.getConnection(url, user, password);
    }
}
