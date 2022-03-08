package com.example.jdbc.nonDaoUseInterface02;

import java.util.List;

public interface TeacherDaoI {
    enum SQL {
        GET_ALL_STUDENT("SELECT * FROM teachers"),
        GET_STUDENT_BY_ID("SELECT * FROM teachers WHERE id=?");
        private final String query;

        private SQL(String s) {
            this.query = s;
        }
        public String getQuery() {
            return query;
        }
    }

    List<Teacher> getAllTeachers();
    Teacher getTeacherById(int id);
}
