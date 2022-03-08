package com.example.jdbc.nonDaoNonInterface01.admin;

import java.sql.*;

public class InsertTeachers {
    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/classicmodels";
        Connection con;
        Statement stmt;
        String query = "select FNAME, LNAME from TEACHERS";

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

            stmt.executeUpdate("insert into TEACHERS " +
                    "values(1, 'teacher1@tek.com','tom', 'young')");

            stmt.executeUpdate("insert into TEACHERS " +
                    "values(2, 'teacher2@tek.com','paul', 'old')");

            // Perform the query
            ResultSet rs = stmt.executeQuery(query);

            // Display the rows
            System.out.println("Teacher names:");
            while (rs.next()) {
                String s = rs.getString("FNAME");
                String f = rs.getString("LNAME");
                System.out.println( s + "   " + f);
            }

            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
