package com.example.jdbc.daoAndUseInterface03.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTeacherTable {
    public static void main(String[] args) throws SQLException {

        // Define the url for the sample database
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        Connection con;
        String createString;
        createString = "create table teachers " +
                "(ID int, " +
                "EMAIL varchar(40), " +
                "FNAME varchar(40), " +
                "LNAME varchar(40) )";
        Statement stmt;

        try {
            // Load database driver. This is old method of loading
            // database driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch(ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            // Create database connection
            con = DriverManager.getConnection(url,
                    "root", "");

            // Create a statement and execute it
            stmt = con.createStatement();
            stmt.executeUpdate(createString);

            // If there is no exception, the COFFEES table must be successfully created
            System.out.println("TEACHERS table is successfully created");

            // Close statement and connection
            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
