import java.util.Scanner;

/*
 * Problem: Find all the multiples of a number below 100 using while loop
 * 
 * Hint:
 * - Get the input value for a variable named number. Check the number is a positive integer and less than 100.
 * - Create a counter variable and assign counter = number - 1; Use a while till the counter is > 1
 * - Inside the loop, check if the counter perfectly divides the number. If true, print the number and continue the loop.
 */

public class FindMultiplesWhile {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get input from user
    System.out.print("Enter a positive integer less than 100: ");
    int number = scanner.nextInt();

    // Validate input
    if (number <= 0 || number >= 100) {
      System.out.println("Error: Please enter a positive integer less than 100.");
      scanner.close();
      return;
    }

    // Find and print all multiples of the number below 100
    System.out.println("\nMultiples of " + number + " below 100:");

    // Initialize counter to number - 1
    int counter = number - 1;

    // Use while loop to find multiples
    while (counter > 0) {
      // Check if counter is perfectly divisible by number
      if (counter % number == 0) {
        System.out.println(counter);
      }
      counter--;
    }

    scanner.close();
  }
}
