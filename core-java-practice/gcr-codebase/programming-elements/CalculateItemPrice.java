// Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total price.
// Hint => NA
// I/P => unitPrice, quantity
// O/P => The total purchase price is INR ___ if the quantity ___ and unit price is INR ___

import java.util.Scanner;

public class CalculateItemPrice {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the unit price of the item: ");
    double unitPrice = sc.nextDouble();
    System.out.print("Enter the quantity to be bought: ");
    int quantity = sc.nextInt();
    double totalPrice = unitPrice * quantity;
    System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity
        + " and unit price is INR " + unitPrice);
    sc.close();

  }
}
