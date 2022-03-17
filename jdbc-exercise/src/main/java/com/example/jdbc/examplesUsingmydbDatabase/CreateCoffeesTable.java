package com.example.jdbc.examplesUsingmydbDatabase;

import java.sql.*;

public class CreateCoffeesTable {
    public static void main(String[] args) throws SQLException {

        // Define the url for the sample database
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection con;
        String createString;
        createString = "create table COFFEES " +
                "(COF_NAME varchar(32), " +
                "SUP_ID int, " +
                "PRICE float, " +
                "SALES int, " +
                "TOTAL int)";
        Statement stmt;

        try {
            // Load database driver. This is old method of loading
            // database driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch(java.lang.ClassNotFoundException e) {
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
            System.out.println("COFFEES table is successfully created");

            // Close statement and connection
            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
