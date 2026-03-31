// Problem 4: Fibonacci Sequence Generator
// Write a program that generates the Fibonacci sequence up to a specified number
// of terms entered by the user.
// Organize the code by creating a function that calculates and prints the Fibonacci
// sequence.

import java.util.Scanner;

public class FibonacciSequenceGenerator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of Fibonacci terms to generate: ");
    int terms = scanner.nextInt();

    System.out.println("Fibonacci Sequence:");
    generateFibonacci(terms);

    scanner.close();
  }

  private static void generateFibonacci(int terms) {
    int a = 0, b = 1;
    for (int i = 1; i <= terms; i++) {
      System.out.print(a + " ");
      int next = a + b;
      a = b;
      b = next;
    }
    System.out.println();
  }

}
