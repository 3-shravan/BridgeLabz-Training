// Problem: GCD and LCM Calculator
// Create a program that calculates the Greatest Common Divisor (GCD) and Least
// Common Multiple (LCM) of two numbers using functions.
// Use separate functions for GCD and LCM calculations, showcasing how modular
// code works.

import java.util.Scanner;

public class GcdLcmCalculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the first number: ");
    int num1 = scanner.nextInt();

    System.out.print("Enter the second number: ");
    int num2 = scanner.nextInt();

    int gcd = calculateGCD(num1, num2);
    int lcm = calculateLCM(num1, num2, gcd);
    displayResults(num1, num2, gcd, lcm);

    scanner.close();
  }

  private static int calculateGCD(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    }
    return calculateGCD(num2, num1 % num2);

  }

  private static int calculateLCM(int num1, int num2, int gcd) {
    if (gcd != 0)
      return (num1 * num2) / gcd;

    return 0;
  }

  private static void displayResults(int num1, int num2, int gcd, int lcm) {
    System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
    System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
  }
}
