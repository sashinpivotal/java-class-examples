package com.example.jdbc.daoAndUseInterface03.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropStudentsTable {

    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/classicmodels";
        Connection con;
        String dropString = "drop table STUDENTS";
        Statement stmt;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url,
                    "root", "");

            stmt = con.createStatement();
            stmt.executeUpdate(dropString);

            System.out.println("STUDENTS table is successfully dropped");
            stmt.close();
            con.close();
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
