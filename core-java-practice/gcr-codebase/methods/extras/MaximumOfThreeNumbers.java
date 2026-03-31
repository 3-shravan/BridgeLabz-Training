// Problem 2: Maximum of Three Numbers
// Write a program that takes three integer inputs from the user and finds the
// maximum of the three numbers.
// Ensure your program follows best practices for organizing code into modular
// functions, such as separate functions for taking input and calculating the
// maximum value.

import java.util.Scanner;

public class MaximumOfThreeNumbers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num1 = takeInput(scanner, "Enter first number: ");
    int num2 = takeInput(scanner, "Enter second number: ");
    int num3 = takeInput(scanner, "Enter third number: ");

    int max = findMaximum(num1, num2, num3);
    displayResult(max);

    scanner.close();
  }

  private static int takeInput(Scanner scanner, String prompt) {
    System.out.print(prompt);
    int input = scanner.nextInt();
    return input;
  }

  private static int findMaximum(int num1, int num2, int num3) {
    if (num1 >= num2 && num1 >= num3) {
      return num1;
    } else if (num2 >= num1 && num2 >= num3) {
      return num2;
    } else {
      return num3;
    }
  }

  private static void displayResult(int max) {
    System.out.println("The maximum value is: " + max);
  }
}
