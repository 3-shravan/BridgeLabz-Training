package com.shravan.controller;

import com.shravan.entity.EmployeeAttendance;
import com.shravan.service.EmployeeWageService;

public class EmployeeWageController {

  private final EmployeeWageService service;

  public EmployeeWageController(EmployeeWageService service) {
    this.service = service;
  }

  public String getWelcomeText() {
    return service.getWelcomeText();
  }

  public String getAttendanceStatus() {
    EmployeeAttendance attendance = service.getAttendance();
    return attendance.getStatus();
  }

  public int getFullTimeDailyWage() {
    return service.calculateFullTimeDailyWage().getAmount();
  }

  public int getPartTimeDailyWage() {
    return service.calculatePartTimeDailyWage().getAmount();
  }

  public int getAttendanceBasedDailyWage() {
    return service.calculateAttendanceBasedDailyWage().getAmount();
  }

  public int getEstimatedMonthlyWage() {
    return service.calculateEstimatedMonthlyWage().getAmount();
  }

  public int getMonthlyWageWithLimits() {
    return service.calculateWageUntilMonthlyLimits().getAmount();
  }

  public int getStaticConfigurationWage() {
    return EmployeeWageService.computeWageWithStaticConfiguration().getAmount();
  }
}
