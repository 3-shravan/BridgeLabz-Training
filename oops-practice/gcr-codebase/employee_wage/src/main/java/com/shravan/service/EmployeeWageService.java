package com.shravan.service;

import com.shravan.entity.EmployeeAttendance;
import com.shravan.repository.EmployeeWageRepository;

public class EmployeeWageService {

  private final EmployeeWageRepository repository;

  public EmployeeWageService(EmployeeWageRepository repository) {
    this.repository = repository;
  }

  public String getWelcomeMessage() {
    return "Welcome to Employee Wage Computation Program";
  }

  public EmployeeAttendance checkAttendance() {
    return new EmployeeAttendance(repository.isEmployeePresent());
  }
}
