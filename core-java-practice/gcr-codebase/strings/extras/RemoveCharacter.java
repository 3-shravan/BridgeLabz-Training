/*
 * 10. Remove a Specific Character from a String
 * Problem:
 * Write a Java program to remove all occurrences of a specific character from a string.
 * 
 * Example Input:
 * String: "Hello World"
 * Character to Remove: 'l'
 * 
 * Expected Output:
 * Modified String: "Heo Word"
 */

import java.util.Scanner;

public class RemoveCharacter {

  public static String removeCharacter(String str, char charToRemove) {
    String result = "";

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != charToRemove) {
        result += str.charAt(i);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    System.out.print("Enter the character to remove: ");
    char charToRemove = scanner.next().charAt(0);

    String result = removeCharacter(input, charToRemove);

    System.out.println("Original String: " + input);
    System.out.println("Modified String: " + result);

    scanner.close();
  }
}
