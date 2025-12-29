import java.util.Scanner;

public class EmployeeWagerComputation {
  
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_TIME_HOUR = 8;
    private static final int PART_TIME_HOUR=8;
    
  public static void main(String[] args) {
    System.out.println("Welcom to Emplyee Wage Computation");

   int dailyWage = calculateDailyWage();
    System.out.println("Daily Wage: " + dailyWage);

    System.out.println("Employee type: ");
    System.out.println("1. part time ");
    System.out.println("2. full time ");
    
Scanner sc = new Scanner (System.in);
int employeeType = sc.nextInt();

if(employeeType == 1){
  int wage = calculateWage(PART_TIME_HOUR);
  System.out.println("Part-time Wage: " + wage);
} else if(employeeType == 2){
  int wage = calculateWage(FULL_TIME_HOUR);
  System.out.println("Full-time Wage: " + wage);
}

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

   

}
