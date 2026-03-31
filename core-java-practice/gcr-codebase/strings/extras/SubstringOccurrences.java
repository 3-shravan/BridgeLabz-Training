/*
 * 6. Find Substring Occurrences
 * Problem:
 * Write a Java program to count how many times a given substring occurs in a string.
 */

import java.util.Scanner;

public class SubstringOccurrences {

  public static int countSubstringOccurrences(String str, String substring) {
    int count = 0;
    int index = 0;

    while (index <= str.length() - substring.length()) {
      boolean found = true;

      for (int i = 0; i < substring.length(); i++) {
        if (str.charAt(index + i) != substring.charAt(i)) {
          found = false;
          break;
        }
      }

      if (found) {
        count++;
        index += substring.length();
      } else {
        index++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the main string: ");
    String mainString = scanner.nextLine();

    System.out.print("Enter the substring to find: ");
    String substring = scanner.nextLine();

    int count = countSubstringOccurrences(mainString, substring);

    System.out.println("The substring \"" + substring + "\" occurs " + count + " times in the string.");

    scanner.close();
  }
}
