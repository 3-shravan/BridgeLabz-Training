import java.util.Scanner;

public class EmployeeWagerComputation {

  private static final int WAGE_PER_HOUR = 20;
  private static final int FULL_TIME_HOUR = 8;
  private static final int PART_TIME_HOUR = 8;
   private static final int WORKING_DAYS = 20;

  public static void main(String[] args) {
    System.out.println("Welcom to Emplyee Wage Computation");

    int dailyWage = calculateDailyWage();
    System.out.println("Daily Wage: " + dailyWage);

    System.out.println("Employee type: ");
    System.out.println("1. part time ");
    System.out.println("2. full time ");

    Scanner sc = new Scanner(System.in);
    int employeeType = sc.nextInt();

    int hours = getHours(employeeType);
    int wage = calculateWage(hours);
    System.out.println("Wage for selected employee type: " + wage);

    int monthlyWages=calculateMonthlyWage();
    System.out.println("Monthly wages:" + monthlyWages);
    

  }

  private static boolean isEmployeePresent() {
    int attendance = (int) (Math.random() * 2);
    return attendance == 1;
  }

  static int calculateDailyWage() {
    if (isEmployeePresent()) {
      return WAGE_PER_HOUR * FULL_TIME_HOUR;
    }
    return 0;
  }

  static int calculateWage(int hours) {
    return WAGE_PER_HOUR * hours;
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

  static int calculateMonthlyWage() {
    int totalWage = 0;
    for (int day = 1; day <= WORKING_DAYS; day++) {
      totalWage += calculateDailyWage();
    }
    return totalWage;
  }

}
