package com.example.jdbc.examplesUsingmydbDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateSuppliersTable {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection con;
        String createString;
        createString = "create table SUPPLIERS " +
                "(SUP_ID int, " +
                "SUP_NAME varchar(40), " +
                "STREET varchar(40), " +
                "CITY varchar(20), " +
                "STATE char(2), ZIP char(5))";

        Statement stmt;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url,
                    "root", "");

            stmt = con.createStatement();
            stmt.executeUpdate(createString);

            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
