package com.shravan.health_clinic.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class JdbcConnectionService {

  private static final String DB_URL = "jdbc:mysql://localhost:3306/health_clinic?createDatabaseIfNotExist=true";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "shravan";

  public Map<String, String> checkDatabaseHealth() {
    Map<String, String> result = new HashMap<>();

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
      DatabaseMetaData metaData = connection.getMetaData();
      result.put("status", "UP");
      result.put("database", metaData.getDatabaseProductName());
      result.put("version", metaData.getDatabaseProductVersion());
    } catch (SQLException exception) {
      result.put("status", "DOWN");
      result.put("error", exception.getMessage());
    }

    return result;
  }
}
