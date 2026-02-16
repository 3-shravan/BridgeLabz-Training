package com.shravan.repository;

import java.util.Random;

public class EmployeeWageRepository {

  private final Random random = new Random();

  public int getWagePerHour() {
    return 20;
  }

  public int getFullTimeHoursPerDay() {
    return 8;
  }

  public int getPartTimeHoursPerDay() {
    return 8;
  }

  public int getMaxWorkingDaysPerMonth() {
    return 20;
  }

  public int getMaxWorkingHoursPerMonth() {
    return 100;
  }

  public int nextAttendanceType() {
    return random.nextInt(3);
  }

  public boolean isEmployeePresent() {
    return random.nextBoolean();
  }
}
