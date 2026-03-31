package com.shravan;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

  private DatabaseConnection dbConnection;

  @BeforeEach
  void setup() {
    dbConnection = new DatabaseConnection();
    dbConnection.connect();
  }

  @AfterEach
  void teardown() {
    dbConnection.disconnect();
  }

  @Test
  void testConnectionEstablished() {
    assertTrue(dbConnection.isConnected(), "Database should be connected");
  }

}
