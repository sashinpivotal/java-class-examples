package com.example.jdbc.classicmodels;

import java.sql.*;

public class PreparedStatementFindbyNumber {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/classicmodels";
        final String USER = "root";
        final String PASS = "";
        Connection conn = DriverManager.getConnection(url, USER, PASS);

        String query = "select * from employees where employeeNumber = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, 1002);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("firstName");
            String email = resultSet.getString("email");
            System.out.println(name + " | " + email);
        }
    }
}
