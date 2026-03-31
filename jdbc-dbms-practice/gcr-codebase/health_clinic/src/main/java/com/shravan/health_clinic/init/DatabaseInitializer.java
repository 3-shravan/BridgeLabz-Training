package com.shravan.health_clinic.init;

import com.shravan.health_clinic.config.DBConnection;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String createPatients = """
            CREATE TABLE IF NOT EXISTS patients (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(100) NOT NULL,
                dob DATE,
                phone VARCHAR(20) UNIQUE,
                email VARCHAR(100) UNIQUE,
                address TEXT,
                blood_group VARCHAR(5)
            )
        """;

        String createDoctors = """
            CREATE TABLE IF NOT EXISTS doctors (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(100) NOT NULL,
                specialty VARCHAR(100),
                phone VARCHAR(20)
            )
        """;

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            stmt.execute(createPatients);
            stmt.execute(createDoctors);

            System.out.println("Tables verified / created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
