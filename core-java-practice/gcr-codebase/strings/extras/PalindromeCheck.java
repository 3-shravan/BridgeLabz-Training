/*
 * 3. Palindrome String Check
 * Problem:
 * Write a Java program to check if a given string is a palindrome 
 * (a string that reads the same forward and backward).
 */

import java.util.Scanner;

public class PalindromeCheck {

  public static boolean isPalindrome(String str) {
    str = str.toLowerCase().trim();

    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    if (isPalindrome(input)) {
      System.out.println("\"" + input + "\" is a palindrome.");
    } else {
      System.out.println("\"" + input + "\" is not a palindrome.");
    }

    scanner.close();
  }
}
