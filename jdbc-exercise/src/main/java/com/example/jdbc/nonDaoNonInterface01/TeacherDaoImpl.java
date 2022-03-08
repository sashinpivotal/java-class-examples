package com.example.jdbc.nonDaoNonInterface01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.jdbc.Constants.*;

public class TeacherDaoImpl
        implements TeacherDaoI {
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public void connect() throws SQLTransientConnectionException {
        try {
            Class.forName(MYSQL_CJ_JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_CLASSICMODELS, USERNAME, PASSWORD);
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

    @Override
    public List<Teacher> getAllTeachers()  {
        List<Teacher> students = new ArrayList<>();
        try {
            this.connect();
            ps = conn.prepareStatement(SQL.GET_ALL_STUDENT.getQuery());
            rs = ps.executeQuery();
            while (rs.next()) {
                Teacher student = new Teacher();
                student.setId(rs.getInt(1));
                student.setEmail(rs.getString(2));
                student.setfName(rs.getString(3));
                student.setlName(rs.getString(4));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dispose();
            return students;
        }
    }

    @Override
    public Teacher getTeacherById(int id) {
        Teacher teacher = new Teacher();
        try {
            this.connect();
            ps = conn.prepareStatement(SQL.GET_STUDENT_BY_ID.getQuery());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                teacher.setId(rs.getInt(1));
                teacher.setEmail(rs.getString(2));
                teacher.setfName(rs.getString(3));
                teacher.setlName(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dispose();
            return teacher;
        }
    }

}
