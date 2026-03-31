/*
 * 2. Reverse a String
 * Problem:
 * Write a Java program to reverse a given string without using any built-in reverse functions.
 */

import java.util.Scanner;

public class ReverseString {

  public static String reverseString(String str) {
    String reversed = "";

    for (int i = str.length() - 1; i >= 0; i--) {
      reversed += str.charAt(i);
    }

    return reversed;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    String reversed = reverseString(input);

    System.out.println("Original String: " + input);
    System.out.println("Reversed String: " + reversed);

    scanner.close();
  }
}
