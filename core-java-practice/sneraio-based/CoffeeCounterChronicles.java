/*1. The Coffee Counter Chronicles ☕
Ravi runs a café. Each customer orders different coffee types with quantities. Write a program
that:
● Asks for coffee type (switch)
● Calculates total bill (price * quantity)
● Adds GST using arithmetic operators
Use while to continue for the next customer and break when "exit" is typed. */

import java.util.Scanner;

public class CoffeeCounterChronicles {

  private static final double GST = 0.18;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("=====Welcome to Ravi's Café!=====");

    while (true) {

      // Display menu
      showMenu();

      System.out.println("Enter your coffee choice or 'exit' to leave cafe : ");
      String choice = scanner.nextLine().trim().toLowerCase();
      // Exit condition
      if (choice.equals("exit")) {
        System.out.println("Thank you for visiting Ravi's Café! Have a great day!");
        scanner.close();
        break;

      }

      // Get coffee price
      double price = getCoffeePrice(choice);
      if (price == -1) {
        System.out.println("Invalid choice. Please try again.");
        continue;
      }

      // Get quantity
      System.out.println("How Many ?? : ");
      int quantity = scanner.nextInt();
      scanner.nextLine();

      if (quantity <= 0) {
        System.out.println("Invalid quantity. Please try again.");
        continue;
      }

      // Calculate total bill with GST
      double totalBill = price * quantity;
      double gstAmount = totalBill * GST;
      double finalAmount = totalBill + gstAmount;

      // Display bill
      System.out.printf("Total Bill with GST is $%.2f%n %n%n", finalAmount);
    }
  }

  // Get coffee price based on choice
  private static double getCoffeePrice(String choice) {
    return switch (choice) {
      case "1", "espresso" -> 5.00;
      case "2", "latte" -> 4.00;
      case "3", "cappuccino" -> 4.50;
      case "4", "americano" -> 3.50;
      case "5", "mocha" -> 5.00;
      default -> -1;
    };
  }

  // Display coffee menu
  private static void showMenu() {
    System.out.println("=====Choose your coffee > ");
    System.out.println("1. Espresso- $5.00 ");
    System.out.println("2. Latte- $4.00 ");
    System.out.println("3. Cappuccino- $4.50 ");
    System.out.println("4. Americano - $3.50 ");
    System.out.println("5. Mocha - $5.00 ");
  }

}
