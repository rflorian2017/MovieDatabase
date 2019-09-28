package com.rosu;

import com.rosu.constants.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) {

        //region read data from terminal
//        String user = "";
//        String password = "";
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            System.out.println("Please input user:");
//            user = reader.readLine();
//
//            System.out.println("Please input password:");
//            password = reader.readLine();
//
//        }
//        catch (IOException ex) {
//
//        }

        //endregion

        // write your code here
        Connection connection = null; // used to open a connection to a database
        try {
            connection = DriverManager.
                    getConnection(Constants.DRIVER_IMPLEMENTATION + "://localhost:3306/imdb",
                            Constants.DB_USERNAME, //user,//
                            Constants.DB_PASSWORD); //password);
            System.out.println("Connection successfully");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            for (StackTraceElement entry:ex.getStackTrace()) {
                System.out.println(entry.getMethodName());
            }

        }

        try {
            // statement created from a JDBC connection
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    "CREATE TABLE movies " +
                    "(" +
                    "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    "name TEXT NOT NULL " +
                    ") "
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
