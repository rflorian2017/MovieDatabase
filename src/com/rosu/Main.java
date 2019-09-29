package com.rosu;

import com.rosu.constants.Constants;
import com.rosu.db.DatabaseWrapper;
import com.rosu.model.Actor;
import com.rosu.model.Movie;

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu =
                        "1. create table\n" +
                        "2. delete all \n" +
                        "3. insert movie\n" +
                        "4. delete movie\n" +
                        "5. show all\n" +
                        "6. drop table\n" +
                        "exit \n";

        System.out.println(menu);

        DatabaseWrapper databaseWrapper = new DatabaseWrapper();

        Connection connection = null;
        try {
            connection = databaseWrapper.createConnection(
                    Constants.DB_DRIVER_IMPLEMENTATION + "://" + Constants.DB_CONN_STRING,
                    Constants.DB_USERNAME,
                    Constants.DB_PASSWORD
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String option = reader.readLine();

            while (!option.equals("exit")) {

                try {
                    switch (option) {
                        case "1":
                            databaseWrapper.createTable(Movie.class);
                            databaseWrapper.createTable(Actor.class);
                            break;
                        case "2":
                            databaseWrapper.deleteRecords();
                            break;
                        case "3": {
                            System.out.print("movie name:");
                            String movieName = reader.readLine();

                            System.out.print("year:");
                            Integer year = Integer.parseInt(reader.readLine());
                            databaseWrapper.insertRecord(movieName, year);

                            break;
                        }

                        case "4": {
                            System.out.print("movie name:");
                            String movieName = reader.readLine();
                            databaseWrapper.deleteRecord(movieName);

                            break;
                        }

                        case "5": {
                            for (String movieName:databaseWrapper.showAllRecords()) {
                                System.out.println(movieName);
                            }

                            break;
                        }
                        case "6": {

                            databaseWrapper.dropTable(Movie.class);

                            break;
                        }
                    }




                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println();
                System.out.println(menu);
                option = reader.readLine();
            }


        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
