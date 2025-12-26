/*
 * 4. Remove Duplicates from a String
 * Problem:
 * Write a Java program to remove all duplicate characters from a given string 
 * and return the modified string.
 */

import java.util.Scanner;

public class RemoveDuplicates {

  public static String removeDuplicates(String str) {
    String result = "";

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      boolean isDuplicate = false;

      for (int j = 0; j < result.length(); j++) {
        if (result.charAt(j) == currentChar) {
          isDuplicate = true;
          break;
        }
      }

      if (!isDuplicate) {
        result += currentChar;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    String result = removeDuplicates(input);

    System.out.println("Original String: " + input);
    System.out.println("String after removing duplicates: " + result);

    scanner.close();
  }
}
