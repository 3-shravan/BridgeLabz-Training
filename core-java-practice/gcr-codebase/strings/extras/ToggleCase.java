/*
 * 7. Toggle Case of Characters
 * Problem:
 * Write a Java program to toggle the case of each character in a given string. 
 * Convert uppercase letters to lowercase and vice versa.
 */

import java.util.Scanner;

public class ToggleCase {

  public static String toggleCase(String str) {
    String result = "";

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch >= 'A' && ch <= 'Z') {
        result += (char) (ch + 32);
      } else if (ch >= 'a' && ch <= 'z') {
        result += (char) (ch - 32);
      } else {
        result += ch;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    String toggled = toggleCase(input);

    System.out.println("Original String: " + input);
    System.out.println("Toggled String: " + toggled);

    scanner.close();
  }
}
