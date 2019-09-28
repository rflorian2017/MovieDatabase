package com.rosu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {


    public static void main(String[] args) {
        String user = "";
        String password = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Please input user:");
            user = reader.readLine();

            System.out.println("Please input password:");
            password = reader.readLine();

        }
        catch (IOException ex) {

        }

        // write your code here
        Connection connection; // used to open a connection to a database
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306",
                            user,//"root",
                            password);//"admin");
            System.out.println("Connection successfully");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            for (StackTraceElement entry:ex.getStackTrace()) {
                System.out.println(entry.getMethodName());
            }

        }


    }
}
