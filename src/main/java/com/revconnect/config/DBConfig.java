package com.revconnect.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

    private static final String URL =
        "jdbc:mysql://localhost:3306/revconnect";
    private static final String USER = "root";
    private static final String PASSWORD = "admin@123";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
