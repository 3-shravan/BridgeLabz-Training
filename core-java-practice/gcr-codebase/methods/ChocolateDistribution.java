/*
 * Create a program to divide N number of chocolates among M children.
 * Print the number of chocolates each child will get and also the remaining chocolates
 * Get an integer value from user for the numberOfchocolates and numberOfChildren.
 * Write the method to find the number of chocolates each child gets and number of remaining chocolates
 * public static int[] findRemainderAndQuotient(int number, int divisor)
 */

import java.util.Scanner;

public class ChocolateDistribution {

  public static int[] findRemainderAndQuotient(int number, int divisor) {
    int quotient = number / divisor;
    int remainder = number % divisor;
    return new int[] { quotient, remainder };
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of chocolates: ");
    int numberOfChocolates = scanner.nextInt();

    System.out.print("Enter the number of children: ");
    int numberOfChildren = scanner.nextInt();

    int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
    int chocolatesPerChild = result[0];
    int remainingChocolates = result[1];

    System.out.println("Each child will get " + chocolatesPerChild + " chocolates.");
    System.out.println("Remaining chocolates: " + remainingChocolates);

    scanner.close();
  }
}
