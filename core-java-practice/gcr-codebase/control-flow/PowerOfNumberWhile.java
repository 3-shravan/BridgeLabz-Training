import java.util.Scanner;

/*
 * Problem: Find the power of a number using while loop
 * 
 * Hint:
 * - Get integer input for two variables named number and power.
 * - Create a result variable with an initial value of 1.
 * - Create a temp variable counter and initialize to zero. Use the while loop till counter == power.
 * - In each iteration of the loop, multiply the result by the number and assign the value to the result. Also, increment the counter.
 * - Finally, print the result
 */

public class PowerOfNumberWhile {
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
      scanner.close();
      return;
    }

    // Calculate power using while loop
    int result = 1;
    int counter = 0;

    // Loop while counter is less than power
    while (counter < power) {
      result = result * number;
      counter++;
    }

    // Print the result
    System.out.println(number + " to the power of " + power + " = " + result);

    scanner.close();
  }
}
