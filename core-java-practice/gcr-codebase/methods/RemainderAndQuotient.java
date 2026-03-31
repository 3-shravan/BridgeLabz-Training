/*
 * Write a program to take 2 numbers and print their quotient and reminder
 * Take user input as integer
 * Use division operator (/) for quotient and moduli operator (%) for reminder
 * Write Method to find the reminder and the quotient of a number
 * public static int[] findRemainderAndQuotient(int number, int divisor)
 */

import java.util.Scanner;

public class RemainderAndQuotient {

  public static int[] findRemainderAndQuotient(int number, int divisor) {
    int quotient = number / divisor;
    int remainder = number % divisor;
    return new int[] { remainder, quotient };
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the dividend (number): ");
    int number = scanner.nextInt();

    System.out.print("Enter the divisor: ");
    int divisor = scanner.nextInt();

    int[] result = findRemainderAndQuotient(number, divisor);

    System.out.println("Quotient: " + result[1]);
    System.out.println("Remainder: " + result[0]);

    scanner.close();
  }
}
