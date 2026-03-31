/*
 * 9. Find the Most Frequent Character
 * Problem:
 * Write a Java program to find the most frequent character in a string.
 * 
 * Example Input:
 * String: "success"
 * 
 * Expected Output:
 * Most Frequent Character: 's'
 */

import java.util.Scanner;

public class MostFrequentCharacter {

  public static char findMostFrequentChar(String str) {
    str = str.toLowerCase();
    char mostFrequentChar = '\0';
    int maxCount = 0;

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);

      if (currentChar == ' ') {
        continue;
      }

      int count = 0;
      for (int j = 0; j < str.length(); j++) {
        if (str.charAt(j) == currentChar) {
          count++;
        }
      }

      if (count > maxCount) {
        maxCount = count;
        mostFrequentChar = currentChar;
      }
    }

    return mostFrequentChar;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    char mostFrequent = findMostFrequentChar(input);

    System.out.println("Most Frequent Character: '" + mostFrequent + "'");

    scanner.close();
  }
}
