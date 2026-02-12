package com.shravan.health_clinic.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // ── DB Credentials ──────────────────────────────────────
    private static final String URL = "jdbc:mysql://localhost:3306/health_clinic";
    private static final String USER = "root";
    private static final String PASS = "shravan";

    // ── Factory Method ──────────────────────────────────────
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
