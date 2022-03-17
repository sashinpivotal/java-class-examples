package com.example.jdbc.examplesUsingmydbDatabase;

import java.sql.*;

public class SQLStatement {
    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/mydb";
        Connection con;
        String query = "select SUPPLIERS.SUP_NAME, COFFEES.COF_NAME " +
                "from COFFEES, SUPPLIERS " +
                "where SUPPLIERS.SUP_NAME like 'Acme, Inc.' and " +
                "SUPPLIERS.SUP_ID = COFFEES.SUP_ID";
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

            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            while (rs.next()) {
                System.out.println("Row " + rowCount + ":  ");
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.print("   Column " + i + ":  ");
                    System.out.println(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }
            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
        }
    }
}
