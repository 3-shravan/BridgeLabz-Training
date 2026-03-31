// Problem: Factorial Using Recursion
// Write a program that calculates the factorial of a number using a recursive
// function.
// Include modular code to separate input, calculation, and output processes.

import java.util.Scanner;

public class FactorialRecursion {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a non-negative integer to calculate its factorial: ");
    int number = scanner.nextInt();
    if (!isValidInput(number)) {
      System.out.println("Please enter a non-negative integer.");
      scanner.close();
      return;
    }
    long factorial = calculateFactorial(number);
    displayResult(number, factorial);

    scanner.close();
  }

  private static long calculateFactorial(int n) {
    if (n <= 1) {
      return 1;
    }
    return n * calculateFactorial(n - 1);

  }

  private static boolean isValidInput(int number) {
    if (number >= 0) {
      return true;
    }

    return false;
  }

  private static void displayResult(int number, long factorial) {
    System.out.println("The factorial of " + number + " is: " + factorial);
  }
}
