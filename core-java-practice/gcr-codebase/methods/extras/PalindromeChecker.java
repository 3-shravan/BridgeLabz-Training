// Problem: Palindrome Checker
// Write a program that checks if a given string is a palindrome (a word, phrase, or
// sequence that reads the same backward as forward).
// Break the program into functions for input, checking the palindrome condition,
// and displaying the result.

import java.util.Scanner;

public class PalindromeChecker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string to check if it is a palindrome: ");
    String input = scanner.nextLine();

    boolean isPalindrome = isPalindrome(input.trim().toLowerCase());
    displayResult(input, isPalindrome);

    scanner.close();
  }

  private static boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return false;
  }

  private static void displayResult(String original, boolean isPalindrome) {
    if (isPalindrome) {
      System.out.println("\"" + original + "\" is a palindrome.");
    } else {
      System.out.println("\"" + original + "\" is not a palindrome.");
    }
  }
}
