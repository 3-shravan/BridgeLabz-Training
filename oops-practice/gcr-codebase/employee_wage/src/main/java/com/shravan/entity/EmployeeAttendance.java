package com.shravan.entity;

public class EmployeeAttendance {

  private final boolean present;

  public EmployeeAttendance(boolean present) {
    this.present = present;
  }

  public boolean isPresent() {
    return present;
  }

  public String getStatus() {
    return present ? "Employee is Present" : "Employee is Absent";
  }
}