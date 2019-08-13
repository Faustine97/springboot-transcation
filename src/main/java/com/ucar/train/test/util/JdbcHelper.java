package com.ucar.train.test.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcHelper {
    public static final String URL = "jdbc:mysql://localhost:3306/internship";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            //System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }
}