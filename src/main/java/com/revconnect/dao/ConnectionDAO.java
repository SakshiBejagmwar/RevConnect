package com.revconnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/revconnect";
    private static final String USER = "root";        // your MySQL username
    private static final String PASSWORD = "admin@123";    // your MySQL password

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
