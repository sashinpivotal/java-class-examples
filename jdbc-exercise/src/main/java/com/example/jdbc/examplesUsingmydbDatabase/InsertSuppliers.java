package com.example.jdbc.examplesUsingmydbDatabase;

import java.sql.*;

public class InsertSuppliers {
    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection con;
        Statement stmt;
        String query = "select SUP_NAME, ZIP from SUPPLIERS";

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

            // Insert rows of data to the COFFEES table
            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(0049, 'Acme, Inc.', '123 Main St', 'Anytown', 'CA', '12345')");

            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(00101, 'Sang, Inc.', '45 Moody', 'Waltham', 'CA', '02480')");

            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(00150, 'Boston, Inc.', '21 Robert', 'Mono', 'CA', '02299')");

            // Perform the query
            ResultSet rs = stmt.executeQuery(query);

            // Display the rows
            System.out.println("Supplier Name and zip:");
            while (rs.next()) {
                String s = rs.getString("SUP_NAME");
                float f = rs.getFloat("ZIP");
                System.out.println(s + "   " + f);
            }

            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
