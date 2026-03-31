// Problem: Leap Year Checker
// Write a program that takes a year as input and outputs the Year is a Leap Year or not
// Hint:
// - The LeapYear program only works for year >= 1582, corresponding to a year in the Gregorian calendar.
// - Leap year is divisible by 4 and not divisible by 100 or divisible by 400
// - Write a method to check for Leap Year using the conditions

import java.util.Scanner;

public class LeapYear {
  private static final int GREGORIAN_CALENDAR_START = 1582;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a year to check if it is a Leap Year: ");
    int year = scanner.nextInt();

    if (!isValidYear(year)) {
      System.out.println(" LeapYear program only works for year >= " + GREGORIAN_CALENDAR_START);
      scanner.close();
      return;
    }

    if (isLeapYear(year)) {
      System.out.println(year + " is a Leap Year");
    } else {
      System.out.println(year + " is NOT a Leap Year");
    }

    scanner.close();
  }

  private static boolean isValidYear(int year) {
    return year >= GREGORIAN_CALENDAR_START;
  }

  private static boolean isLeapYear(int year) {
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      return true;
    }
    return false;
  }
}
