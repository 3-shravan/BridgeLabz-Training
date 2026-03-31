import java.util.Scanner;

/*
 * Problem: Check if the given number is a prime number or not
 * 
 * Hint:
 * - A number that can be divided exactly only by itself and 1 are Prime Numbers
 * - Prime Numbers checks are done for numbers greater than 1
 * - Loop through all the numbers from 2 to the user input number and check if the remainder is zero
 * - If the remainder is zero, break out from the loop as the number is divisible by some other number and is not a prime number
 * - Use the isPrime boolean variable to store the result
 */

public class CheckPrime {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get input from user
    System.out.print("Enter a number to check if it's prime: ");
    int number = scanner.nextInt();

    // Prime number checks are done for numbers greater than 1
    if (number <= 1) {
      System.out.println(number + " is not a Prime Number");
      scanner.close();
      return;
    }

    // Boolean variable to store the result
    boolean isPrime = true;

    // Loop through all numbers from 2 to the input number
    for (int i = 2; i < number; i++) {
      // Check if the remainder is zero
      if (number % i == 0) {
        // If divisible by any number other than 1 and itself, it's not prime
        isPrime = false;
        break; // Break out of the loop
      }
    }

    // Display the result
    if (isPrime) {
      System.out.println(number + " is a Prime Number");
    } else {
      System.out.println(number + " is not a Prime Number");
    }

    scanner.close();
  }
}
