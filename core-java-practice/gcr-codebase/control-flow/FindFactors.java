// Create a program to find the factors of a number taken as user input.
// Hint => 
// Get the input value for a variable named number and check if it is a positive integer.
// Run a for loop from i = 1 to i < number. In each iteration of the loop, check if the number 
// is perfectly divisible by i. If true, print the value of i.

import java.util.Scanner;

public class FindFactors {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");
    int number = sc.nextInt();
    if (number <= 0) {
      System.out.println("Please enter a positive integer.");
      sc.close();
      return;
    }
    System.out.println("Factors of " + number + " are:");
    for (int i = 1; i < number; i++) {
      if (number % i == 0) {
        System.out.println(i);
      }
    }
    if (number % number == 0) {
      System.out.println(number);
    }

    sc.close();
  }
}
