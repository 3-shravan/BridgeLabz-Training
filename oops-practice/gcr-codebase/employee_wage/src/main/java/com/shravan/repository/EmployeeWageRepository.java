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

 
  public boolean isEmployeePresent() {
    return random.nextBoolean();
  }
}
