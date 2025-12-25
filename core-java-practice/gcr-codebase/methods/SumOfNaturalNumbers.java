/*
 * Write a program to find the sum of n natural numbers using loop
 * Get integer input from the user.
 * Write a Method to find the sum of n natural numbers using loop
 */

import java.util.Scanner;

public class SumOfNaturalNumbers {

  public static long findSum(int n) {
    long sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int n = scanner.nextInt();

    long sum = findSum(n);

    System.out.println("The sum of natural numbers from 1 to " + n + " is: " + sum);

    scanner.close();
  }
}
