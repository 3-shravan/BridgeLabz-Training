import java.util.Scanner;

/*
 * Problem: Find all the multiples of a number taken as user input below 100
 * 
 * Hint:
 * - Get the input value for a variable named number. Check the number is a positive integer and less than 100.
 * - Run a for loop backward: from i = 100 to i = 1.
 * - Inside the loop, check if i perfectly divide the number. If true, print the number and continue the loop.
 */

public class FindMultiples {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get input from user
    System.out.print("Enter a positive integer less than 100: ");
    int number = scanner.nextInt();

    // Validate input
    if (number <= 0 || number >= 100) {
      System.out.println("Error: Please enter a positive integer less than 100.");
      return;
    }

    // Find and print all multiples of the number below 100
    System.out.println("\nMultiples of " + number + " below 100:");

    // Loop backward from 100 to 1
    for (int i = 100; i > number; i--) {
      // Check if i is perfectly divisible by number
      if (i % number == 0) {
        System.out.println(i);
      }
    }

  }
}
