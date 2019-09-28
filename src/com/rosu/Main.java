package com.rosu;

import com.rosu.constants.Constants;
import com.rosu.db.DatabaseWrapper;

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

        DatabaseWrapper databaseWrapper = new DatabaseWrapper();

        Connection connection = null;
        try {
            connection = databaseWrapper.createConnection(
                    Constants.DB_DRIVER_IMPLEMENTATION + "://" + Constants.DB_CONN_STRING,
                    Constants.DB_USERNAME,
                    Constants.DB_PASSWORD
            );

           databaseWrapper.createTable();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
