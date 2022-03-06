package com.example.jdbc.dao;

import java.sql.*;

public class AbstractDAO {

    private final String url = "jdbc:mysql://localhost/classicmodels";
    private final String USER = "root";
    private final String PASS = "";

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public void connect() throws SQLTransientConnectionException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER, PASS);
        } catch (SQLException e) {
            throw new SQLTransientConnectionException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dispose() {
        try {
            if (!rs.equals(null) && !rs.isClosed()) {
                rs.close();
            }
            if (!ps.equals(null) && !ps.isClosed()) {
                ps.close();
            }
            if (!conn.equals(null) && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
