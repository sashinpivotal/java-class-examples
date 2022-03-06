package com.example.jdbc.classicmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class RetrieveEmployees {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/classicmodels";
        final String USER = "root";
        final String PASS = "";
        Connection conn = DriverManager.getConnection(url, USER, PASS);

        String SelectSQL = "Select * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(SelectSQL);
        while (result.next()) {
            String name = result.getString("firstName");
            String email = result.getString("email");
            System.out.println(name + " | " + email);
        }
    }
}
