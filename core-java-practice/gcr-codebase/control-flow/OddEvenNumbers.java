// Create a program to print odd and even numbers between 1 to the number entered by the user.
// Hint => 
// Get an integer input from the user, assign to a variable number and check for Natural Number
// Using a for loop, iterate from 1 to the number
// In each iteration of the loop, print the number is odd or even number

import java.util.Scanner;

public class OddEvenNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a natural number: ");
    int number = sc.nextInt();
    if (number < 1) {
      System.out.println("Please enter a natural number (greater than 0).");
      sc.close();
      return;
    }
    for (int i = 1; i <= number; i++) {
      if (i % 2 == 0) {
        System.out.println(i + " is an Even number.");
      } else {
        System.out.println(i + " is an Odd number.");
      }
    }

    sc.close();
  }
}
