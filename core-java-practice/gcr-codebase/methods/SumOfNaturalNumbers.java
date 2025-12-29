// Problem: Sum of n Natural Numbers - Recursive vs Formulae
// Write a program to find the sum of n natural numbers using recursive method and 
// compare the result with the formulae n*(n+1)/2 and show the result from both 
// computations is correct.
// Hint:
// - Take the user input number and check whether it's a Natural number
// - Write a Method to find the sum of n natural numbers using recursion
// - Write a Method to find the sum of n natural numbers using the formulae n*(n+1)/2
// - Compare the two results and print the result

import java.util.Scanner;

public class SumOfNaturalNumbers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a natural number: ");
    int number = scanner.nextInt();

    if (!isNaturalNumber(number)) {
      System.out.println("Error: Please enter a positive natural number.");
      scanner.close();
      return;
    }

    long sumRecursive = sumUsingRecursion(number);
    System.out.println("Sum using Recursion: " + sumRecursive);

    long sumFormulae = sumUsingFormulae(number);
    System.out.println("Sum using Formulae n*(n+1)/2: " + sumFormulae);

    compareResults(sumRecursive, sumFormulae);

    scanner.close();
  }

  private static boolean isNaturalNumber(int number) {
    return number > 0;
  }

  private static long sumUsingRecursion(int n) {
    if (n == 1) {
      return 1;
    }
    return n + sumUsingRecursion(n - 1);
  }

  private static long sumUsingFormulae(int n) {
    return (long) n * (n + 1) / 2;
  }

  private static void compareResults(long recursiveSum, long formulaeSum) {
    if (recursiveSum == formulaeSum) {
      System.out.println("Both results are CORRECT and EQUAL!");
      System.out.println("Result from both methods: " + recursiveSum);
    } else {
      System.out.println("Results do NOT match!");
      System.out.println("Recursive result: " + recursiveSum);
      System.out.println("Formulae result: " + formulaeSum);
    }
  }
}
