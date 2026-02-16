package com.shravan.repository;

import java.util.Random;

public class EmployeeWageRepository {

  private final Random random = new Random();

  public int getWagePerHour() {
    return 20;
  }

  public int getFullDayHours() {
    return 8;
  }

  public int getPartTimeHours() {
    return 8;
  }

  public int getWorkingDaysPerMonth() {
    return 20;
  }

  public int getMaxWorkingHoursPerMonth() {
    return 100;
  }

  public int getAttendanceType() {
    return random.nextInt(3);
  }

  public boolean isEmployeePresent() {
    return random.nextBoolean();
  }
}
