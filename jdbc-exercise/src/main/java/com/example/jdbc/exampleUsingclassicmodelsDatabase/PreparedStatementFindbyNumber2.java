package com.example.jdbc.exampleUsingclassicmodelsDatabase;

import java.sql.*;

import static com.example.jdbc.Constants.JDBC_MYSQL_LOCALHOST_CLASSICMODELS;
import static com.example.jdbc.Constants.MYSQL_CJ_JDBC_DRIVER;

public class PreparedStatementFindbyNumber2 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_CJ_JDBC_DRIVER);
        String url = JDBC_MYSQL_LOCALHOST_CLASSICMODELS;
        final String USER = "root";
        final String PASS = "";
        Connection conn = DriverManager.getConnection(url, USER, PASS);

        String query = "select * from employees where employeeNumber = ? and firstName = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, 1002);
        preparedStatement.setString(2, "Diane");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println(name + " | " + email);
        }
    }
}
