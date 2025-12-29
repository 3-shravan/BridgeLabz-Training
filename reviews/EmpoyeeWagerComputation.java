public class EmpoyeeWagerComputation {

  private static final int WAGE_PER_HOUR = 20;
  private static final int FULL_TIME_HOUR = 8;
  
}
public class EmployeeWagerProblem {

  public static void main(String[] args) {
    System.out.println("Welcom to Emplyee Wage Computation");

   int dailyWage = calculateDailyWage();
    System.out.println("Daily Wage: " + dailyWage);

  }

  private static boolean isEmployeeAbsentPresent() {
    int attendance = (int) (Math.random() * 2);
    return attendance == 1;
  }

 static int calculateDailyWage() {
    if (isEmployeePresent()) {
      return WAGE_PER_HOUR * FULL_TIME_HOUR;
    }
    return 0;
  }

}
