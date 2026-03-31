// Problem: Factors of a Number
// Create a program to find the factors of a number taken as user input, store the factors 
// in an array, and display the factors. Also find the sum, sum of square of factors and 
// product of the factors and display the results.
// Hint:
// - Take the input for a number
// - Write a static Method to find the factors of the number and save them in an array and return the array.
//   (To find factors and save to array will have two loops. The first loop to find the count and 
//    initialize the array with the count. And the second loop save the factors into the array)
// - Write a method to find the sum of the factors using factors array
// - Write a method to find the product of the factors using factors array
// - Write a method to find the sum of square of the factors using Math.pow() method

import java.util.Scanner;

public class FactorsOfNumber {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number to find its factors: ");
    int number = scanner.nextInt();
    int[] factors = findFactors(number);
    System.out.print("Factors of " + number + " are: ");
    for (int factor : factors) {
      System.out.print(factor + " ");
    }
    System.out.println();
    int sum = calculateSum(factors);
    int product = calculateProduct(factors);
    int sumOfSquares = calculateSumOfSquares(factors);
    System.out.println("Sum of factors: " + sum);
    System.out.println("Product of factors: " + product);
    System.out.println("Sum of squares of factors: " + sumOfSquares);

    scanner.close();
  }

  private static int[] findFactors(int number) {
    int count = 0;
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        count++;
      }
    }

    int[] factors = new int[count];
    int index = 0;
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        factors[index++] = i;
      }
    }
    return factors;

  }

  private static int calculateSum(int[] factors) {
    int sum = 0;
    for (int factor : factors) {
      sum += factor;
    }
    return sum;
  }

  private static int calculateProduct(int[] factors) {
    int product = 1;
    for (int factor : factors) {
      product *= factor;
    }
    return product;
  }

  private static int calculateSumOfSquares(int[] factors) {
    int sumOfSquares = 0;
    for (int factor : factors) {
      sumOfSquares += Math.pow(factor, 2);
    }
    return sumOfSquares;
  }

}
