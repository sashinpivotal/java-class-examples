package com.example.jdbc.daoAndUseInterface03;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl
        extends DAO
        implements StudentDaoI {

    @Override
    public List<Student> getAllStudents()  {
        List<Student> students = new ArrayList<>();
        try {
            this.connect();
            ps = conn.prepareStatement(SQL.GET_ALL_STUDENT.getQuery());
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
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
    public Student getStudentById(int id) {
        Student student = new Student();
        try {
            this.connect();
            ps = conn.prepareStatement(SQL.GET_STUDENT_BY_ID.getQuery());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                student.setId(rs.getInt(1));
                student.setEmail(rs.getString(2));
                student.setfName(rs.getString(3));
                student.setlName(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.dispose();
            return student;
        }
    }

}
