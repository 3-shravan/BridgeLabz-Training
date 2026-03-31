/*
 * Write a program to check whether a number is positive, negative, or zero.
 * Get integer input from the user.
 * Write a Method to return -1 for negative number, 1 for positive number and 0 if number is zero
 */

import java.util.Scanner;

public class CheckNumber {

  public static int checkNumber(int number) {
    if (number < 0) {
      return -1;
    } else if (number > 0) {
      return 1;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int number = scanner.nextInt();

    int result = checkNumber(number);

    if (result == -1) {
      System.out.println(number + " is a negative number.");
    } else if (result == 1) {
      System.out.println(number + " is a positive number.");
    } else {
      System.out.println(number + " is zero.");
    }

    scanner.close();
  }
}
