package com.example.jdbc.nonDaoNonInterface01;

enum SQL {
    GET_ALL_STUDENT("SELECT * FROM students"),
    GET_STUDENT_BY_ID("SELECT * FROM students WHERE id=?");
    private final String query;

    private SQL(String s) {
        this.query = s;
    }
    public String getQuery() {
        return query;
    }
}
