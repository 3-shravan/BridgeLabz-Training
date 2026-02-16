package com.shravan.repository;

import java.util.Random;

public class EmployeeWageRepository {

  private final Random random = new Random();

 
  public boolean isEmployeePresent() {
    return random.nextBoolean();
  }
}
