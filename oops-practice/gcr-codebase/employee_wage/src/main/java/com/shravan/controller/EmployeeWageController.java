package com.shravan.controller;

import com.shravan.entity.EmployeeAttendance;
import com.shravan.service.EmployeeWageService;

public class EmployeeWageController {

  private final EmployeeWageService service;

  public EmployeeWageController(EmployeeWageService service) {
    this.service = service;
  }

  public String getWelcomeMessage() {
    return service.getWelcomeMessage();
  }

  public EmployeeAttendance checkEmployeeAttendance() {
    return service.checkAttendance();
  }
}
