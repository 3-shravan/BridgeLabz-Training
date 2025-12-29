public class EmployeeWageComputation {
  private static final int WAGE_PER_HOUR = 20;
  private static final int FULL_TIME_HOUR = 8;
  private static final int PART_TIME_HOUR = 4;
  private static final int WORKING_DAYS = 20;
  private static final int MAX_HOURS = 100;




































  public static void main(String[] args) {
    System.out.println("Welcome to Employee Wage Computation Program\n");

    int dailyWage = calculateDailyWage();
    System.out.println("Daily Wage: " + dailyWage);

    int empType = 1;
    int hours = getHours(empType);
    int wage = calculateWage(hours);
    System.out.println("Wage for Employee Type " + empType + ": " + wage);

    int monthlyWage = calculateMonthlyWage();
    System.out.println("Monthly Wage (20 days): " + monthlyWage);

    // UC 6: Until 100 hours or 20 days
    int totalWage = calculateWageUntilLimit();
    System.out.println("Total Wage (100 hours/20 days): " + totalWage);
  }

  static boolean isEmployeePresent() {
    int attendance = (int) (Math.random() * 2); 
    return attendance == 1;
  }

  static int calculateDailyWage() {
    if (isEmployeePresent()) {
      return WAGE_PER_HOUR * FULL_TIME_HOUR;
    }
    return 0;
  }

  static int getHours(int empType) {
    switch (empType) {
      case 1:
        return FULL_TIME_HOUR;
      case 2:
        return PART_TIME_HOUR;
      default:
        return 0;
    }
  }

  static int calculateWage(int hours) {
    return WAGE_PER_HOUR * hours;
  }

  static int calculateMonthlyWage() {
    int totalWage = 0;
    for (int day = 1; day <= WORKING_DAYS; day++) {
      totalWage += calculateDailyWage();
    }
    return totalWage;
  }

  static int calculateWageUntilLimit() {
    int totalWage = 0;
    int totalHours = 0;
    int daysWorked = 0;

    while (totalHours < MAX_HOURS && daysWorked < WORKING_DAYS) {
      if (isEmployeePresent()) {
        totalHours += FULL_TIME_HOUR;
        totalWage += WAGE_PER_HOUR * FULL_TIME_HOUR;
      }
      daysWorked++;
    }

    return totalWage;
  }
}
