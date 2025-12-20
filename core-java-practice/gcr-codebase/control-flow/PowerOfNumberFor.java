import java.util.Scanner;

/*
 * Problem: Create a program to find the power of a number
 * 
 * Hint:
 * - Get integer input for two variables - number and power and check for positive integer
 * - Create a result variable with an initial value of 1.
 * - Run a for loop from i = 1 to i <= power. In each iteration of the loop, multiply the result by the number 
 *   and assign the value to the result. Finally, print the result
 */

public class PowerOfNumberFor {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get input for base number
    System.out.print("Enter the base number (positive integer): ");
    int number = scanner.nextInt();

    // Validate number
    if (number <= 0) {
      System.out.println("Error: Please enter a positive integer.");
      scanner.close();
      return;
    }

    // Get input for power/exponent
    System.out.print("Enter the power (positive integer): ");
    int power = scanner.nextInt();

    // Validate power
    if (power <= 0) {
      System.out.println("Error: Please enter a positive integer for power.");
      return;
    }

    // Calculate power using for loop
    int result = 1;

    // Loop from 1 to power
    for (int i = 1; i <= power; i++) {
      result = result * number;
    }

    // Print the result
    System.out.println(number + " to the power of " + power + " = " + result);

    scanner.close();
  }
}
