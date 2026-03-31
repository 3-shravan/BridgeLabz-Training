// Problem 8: Temperature Converter
// Write a program that converts temperatures between Fahrenheit and Celsius.
// The program should have separate functions for converting from Fahrenheit to
// Celsius and from Celsius to Fahrenheit.

import java.util.Scanner;

public class TemperatureConverter {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    showChoices();

    int choice = scanner.nextInt();
    handleChoice(choice, scanner);

    scanner.close();
  }

  private static double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
  }

  private static void handleChoice(int choice, Scanner scanner) {
    if (choice == 1) {
      System.out.print("Enter temperature in Fahrenheit: ");
      double fahrenheit = scanner.nextDouble();
      double celsius = fahrenheitToCelsius(fahrenheit);
      displayConversion(fahrenheit, celsius, "Fahrenheit", "Celsius");
    } else if (choice == 2) {
      System.out.print("Enter temperature in Celsius: ");
      double celsius = scanner.nextDouble();
      double fahrenheit = celsiusToFahrenheit(celsius);
      displayConversion(celsius, fahrenheit, "Celsius", "Fahrenheit");
    } else {
      System.out.println("Invalid choice. Please select 1 or 2.");
    }
  }

  private static void showChoices() {
    System.out.println("Temperature Converter");
    System.out.println("1. Convert Fahrenheit to Celsius");
    System.out.println("2. Convert Celsius to Fahrenheit");
    System.out.print("Choose an option (1 or 2): ");
  }

  private static double celsiusToFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
  }

  private static void displayConversion(double originalTemp, double convertedTemp, String fromUnit, String toUnit) {
    System.out.printf("%.2f %s is equal to %.2f %s%n", originalTemp, fromUnit, convertedTemp, toUnit);
  }
}
