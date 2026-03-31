import java.util.Scanner;

/*
 * Problem: Determine if a year is a Leap Year or not
 * Using Multiple If-Else Statements
 * 
 * Hint:
 * - LeapYear program only works for year >= 1582 (Gregorian calendar)
 * - Leap Year is a year divisible by 4 and not 100, unless it is divisible by 400
 * - Examples: 1800 is not a Leap Year, 2000 is a Leap Year
 * - Use multiple if-else statements based on the conditions
 */

public class LeapYear {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a year: ");
    int year = scanner.nextInt();

    // Check if year is valid 
    if (year < 1582) {
      System.out.println("Error: Year must be >= 1582 (Gregorian calendar).");
      scanner.close();
      return;
    }

    // First check: If divisible by 400, it's a Leap Year
    if (year % 400 == 0) {
      System.out.println(year + " is a Leap Year");
    }
    // Second check: If divisible by 100 (but not 400), it's NOT a Leap Year
    else if (year % 100 == 0) {
      System.out.println(year + " is not a Leap Year");
    }
    // Third check: If divisible by 4 (but not 100), it's a Leap Year
    else if (year % 4 == 0) {
      System.out.println(year + " is a Leap Year");
    }
    // Fourth check: If not divisible by 4, it's NOT a Leap Year
    else {
      System.out.println(year + " is not a Leap Year");
    }

    scanner.close();
  }
}
