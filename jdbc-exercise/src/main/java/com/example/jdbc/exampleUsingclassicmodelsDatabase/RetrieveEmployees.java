package com.example.jdbc.exampleUsingclassicmodelsDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import static com.example.jdbc.Constants.JDBC_MYSQL_LOCALHOST_CLASSICMODELS;
import static com.example.jdbc.Constants.MYSQL_CJ_JDBC_DRIVER;

public class RetrieveEmployees {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_CJ_JDBC_DRIVER);
        String url = JDBC_MYSQL_LOCALHOST_CLASSICMODELS;
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
