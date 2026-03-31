package com.shravan.service;

import java.util.Random;
import java.util.function.IntSupplier;

import com.shravan.entity.EmployeeAttendance;
import com.shravan.entity.EmployeeWage;
import com.shravan.repository.EmployeeWageRepository;

public class EmployeeWageService {

  private static final int ATTENDANCE_ABSENT = 0;
  private static final int ATTENDANCE_FULL_TIME = 1;
  private static final int ATTENDANCE_PART_TIME = 2;
  private static final int DEFAULT_WAGE_PER_HOUR = 20;
  private static final int DEFAULT_FULL_TIME_HOURS_PER_DAY = 8;
  private static final int DEFAULT_PART_TIME_HOURS_PER_DAY = 8;
  private static final int DEFAULT_MAX_WORKING_DAYS = 20;
  private static final int DEFAULT_MAX_WORKING_HOURS = 100;
  private static final Random STATIC_RANDOM = new Random();

  private final EmployeeWageRepository repository;

  public EmployeeWageService(EmployeeWageRepository repository) {
    this.repository = repository;
  }

  public String getWelcomeText() {
    return "Welcome to Employee Wage Computation Program";
  }

  public EmployeeAttendance getAttendance() {
    return new EmployeeAttendance(repository.isEmployeePresent());
  }

  public EmployeeWage calculateFullTimeDailyWage() {
    return wageFromHours(repository.getFullTimeHoursPerDay());
  }

  public EmployeeWage calculatePartTimeDailyWage() {
    return wageFromHours(repository.getPartTimeHoursPerDay());
  }

  public EmployeeWage calculateAttendanceBasedDailyWage() {
    int attendanceType = repository.nextAttendanceType();
    int dailyHours = resolveWorkingHoursByAttendanceType(attendanceType,
        repository.getFullTimeHoursPerDay(), repository.getPartTimeHoursPerDay());
    return wageFromHours(dailyHours);
  }

  public EmployeeWage calculateEstimatedMonthlyWage() {
    int monthlyWage = calculateFullTimeDailyWage().getAmount() * repository.getMaxWorkingDaysPerMonth();
    return new EmployeeWage(monthlyWage);
  }

  public EmployeeWage calculateWageUntilMonthlyLimits() {
    return computeWageForPeriod(
        repository.getMaxWorkingDaysPerMonth(),
        repository.getMaxWorkingHoursPerMonth(),
        repository.getFullTimeHoursPerDay(),
        repository.getPartTimeHoursPerDay(),
        repository::nextAttendanceType,
        repository.getWagePerHour());
  }

  public static EmployeeWage computeWageWithStaticConfiguration() {
    return computeWageForPeriod(
        DEFAULT_MAX_WORKING_DAYS,
        DEFAULT_MAX_WORKING_HOURS,
        DEFAULT_FULL_TIME_HOURS_PER_DAY,
        DEFAULT_PART_TIME_HOURS_PER_DAY,
        () -> STATIC_RANDOM.nextInt(3),
        DEFAULT_WAGE_PER_HOUR);
  }

  private EmployeeWage wageFromHours(int hours) {
    return new EmployeeWage(hours * repository.getWagePerHour());
  }

  private static int resolveWorkingHoursByAttendanceType(int attendanceType, int fullTimeHours, int partTimeHours) {
    switch (attendanceType) {
      case ATTENDANCE_FULL_TIME:
        return fullTimeHours;
      case ATTENDANCE_PART_TIME:
        return partTimeHours;
      case ATTENDANCE_ABSENT:
      default:
        return 0;
    }
  }

  private static EmployeeWage computeWageForPeriod(
      int maxWorkingDays,
      int maxWorkingHours,
      int fullTimeHoursPerDay,
      int partTimeHoursPerDay,
      IntSupplier attendanceSupplier,
      int wagePerHour) {

    int totalWorkingHours = 0;
    int totalWorkingDays = 0;

    while (totalWorkingDays < maxWorkingDays && totalWorkingHours < maxWorkingHours) {
      int attendanceType = attendanceSupplier.getAsInt();
      int dailyHours = resolveWorkingHoursByAttendanceType(attendanceType, fullTimeHoursPerDay, partTimeHoursPerDay);

      if (totalWorkingHours + dailyHours > maxWorkingHours) {
        break;
      }

      totalWorkingHours += dailyHours;
      totalWorkingDays++;
    }

    return new EmployeeWage(totalWorkingHours * wagePerHour);
  }
}
