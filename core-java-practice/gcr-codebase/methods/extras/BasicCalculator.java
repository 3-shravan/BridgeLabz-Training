// Problem 9: Basic Calculator
// Write a program that performs basic mathematical operations (addition,
// subtraction, multiplication, division) based on user input.
// Each operation should be performed in its own function, and the program should
// prompt the user to choose which operation to perform.

import java.util.Scanner;

public class BasicCalculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    showChoices();
    int choice = scanner.nextInt();

    System.out.print("Enter the first number: ");
    double num1 = scanner.nextDouble();

    System.out.print("Enter the second number: ");
    double num2 = scanner.nextDouble();

    handleChoice(choice, num1, num2);

    scanner.close();
  }

  private static void showChoices() {
    System.out.println("Basic Calculator");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");
    System.out.print("Choose an operation (1-4): ");
  }

  private static void handleChoice(int choice, double num1, double num2) {
    double result;
    switch (choice) {
      case 1:
        result = add(num1, num2);
        displayResult(num1, num2, result, "+");
        break;
      case 2:
        result = subtract(num1, num2);
        displayResult(num1, num2, result, "-");
        break;
      case 3:
        result = multiply(num1, num2);
        displayResult(num1, num2, result, "*");
        break;
      case 4:
        result = divide(num1, num2);
        displayResult(num1, num2, result, "/");
        break;
      default:
        System.out.println("Invalid choice. Please select a valid operation.");
    }
  }

  private static double add(double num1, double num2) {
    return num1 + num2;
  }

  private static double subtract(double num1, double num2) {
    return num1 - num2;
  }

  private static double multiply(double num1, double num2) {

    return num1 * num2;
  }

  private static double divide(double num1, double num2) {
    if (num2 == 0) {
      System.out.println("Error: Division by zero is not allowed.");
      return 0.0;
    }
    return num1 / num2;
  }

  private static void displayResult(double num1, double num2, double result, String operation) {
    System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
  }
}
