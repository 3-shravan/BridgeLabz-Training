import java.util.Scanner;

/*
 * Problem: Determine if a year is a Leap Year or not
 * Using Single If Condition with Logical AND (&&) and OR (||) Operators
 * 
 * Hint:
 * - LeapYear program only works for year >= 1582 (Gregorian calendar)
 * - Leap Year is a year divisible by 4 and not 100, unless it is divisible by 400
 * - Use a single if statement with logical operators to check all conditions
 * 
 * Leap Year Condition:
 * - (year % 4 == 0 && year % 100 != 0) OR (year % 400 == 0)
 */

public class LeapYearOptimized {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a year: ");
    int year = scanner.nextInt();

    // Check if year is valid (>= 1582
    if (year < 1582) {
      System.out.println("Error: Year must be >= 1582 (Gregorian calendar).");
      scanner.close();
      return;
    }

    // Leap Year if(divisible by 4 AND not divisible by 100) OR (divisible by 400)
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      System.out.println(year + " is a Leap Year");
    } else {
      System.out.println(year + " is not a Leap Year");
    }

    scanner.close();
  }
}
