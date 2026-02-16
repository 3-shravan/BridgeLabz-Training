package com.shravan.service;

import com.shravan.entity.EmployeeAttendance;
import com.shravan.entity.EmployeeWage;
import com.shravan.repository.EmployeeWageRepository;

public class EmployeeWageService {

  private static final int EMPLOYEE_ABSENT = 0;
  private static final int EMPLOYEE_FULL_TIME = 1;
  private static final int EMPLOYEE_PART_TIME = 2;

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

  public EmployeeWage calculateDailyWage() {
    int dailyWage = repository.getWagePerHour() * repository.getFullDayHours();
    return new EmployeeWage(dailyWage);
  }

  public EmployeeWage calculatePartTimeWage() {
    int partTimeWage = repository.getWagePerHour() * repository.getPartTimeHours();
    return new EmployeeWage(partTimeWage);
  }

  public EmployeeWage calculateMonthlyWage() {
    int monthlyWage = calculateDailyWage().getAmount() * repository.getWorkingDaysPerMonth();
    return new EmployeeWage(monthlyWage);
  }

  public EmployeeWage calculateWageTillConditionForMonth() {
    int totalWorkingHours = 0;
    int totalWorkingDays = 0;

    while (totalWorkingDays < repository.getWorkingDaysPerMonth()
        && totalWorkingHours < repository.getMaxWorkingHoursPerMonth()) {

      int attendanceType = repository.getAttendanceType();
      int dailyHours;

      switch (attendanceType) {
        case EMPLOYEE_FULL_TIME:
          dailyHours = repository.getFullDayHours();
          break;
        case EMPLOYEE_PART_TIME:
          dailyHours = repository.getPartTimeHours();
          break;
        case EMPLOYEE_ABSENT:
        default:
          dailyHours = 0;
          break;
      }

      if (totalWorkingHours + dailyHours > repository.getMaxWorkingHoursPerMonth()) {
        break;
      }

      totalWorkingHours += dailyHours;
      totalWorkingDays++;
    }

    return new EmployeeWage(totalWorkingHours * repository.getWagePerHour());
  }
}
