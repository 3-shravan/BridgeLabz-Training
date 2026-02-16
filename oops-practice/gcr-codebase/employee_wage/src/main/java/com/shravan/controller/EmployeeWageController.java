package com.shravan.controller;

import com.shravan.entity.EmployeeAttendance;
import com.shravan.entity.EmployeeWage;
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

  public EmployeeWage calculateDailyWage() {
    return service.calculateDailyWage();
  }

  public EmployeeWage calculatePartTimeWage() {
    return service.calculatePartTimeWage();
  }

  public EmployeeWage calculateMonthlyWage() {
    return service.calculateMonthlyWage();
  }

  public EmployeeWage calculateWageTillConditionForMonth() {
    return service.calculateWageTillConditionForMonth();
  }
}
