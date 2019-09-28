package com.rosu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Connection connection; // used to open a connection to a database
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306",
                            "root",
                            "admin");
            System.out.println("Connection successfully");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            for (StackTraceElement entry:ex.getStackTrace()
                 ) {
                System.out.println(entry.getMethodName());
            }

        }


    }
}
