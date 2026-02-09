package com.shravan.health_clinic.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shravan.health_clinic.db.JdbcConnectionService;

@RestController
public class HealthCheck {

  private final JdbcConnectionService jdbcConnectionService;

  public HealthCheck(JdbcConnectionService jdbcConnectionService) {
    this.jdbcConnectionService = jdbcConnectionService;
  }

  @GetMapping("/")
  public String healthCheck() {
    return "Health Clinic API is up and running!";
  }

  @GetMapping("/db-health")
  public Map<String, String> dbHealthCheck() {
    return jdbcConnectionService.checkDatabaseHealth();
  }
}
