/*
 * 5. Find the Longest Word in a Sentence
 * Problem:
 * Write a Java program that takes a sentence as input and returns the longest word in the sentence.
 */

import java.util.Scanner;

public class LongestWord {

  public static String findLongestWord(String sentence) {
    String[] words = sentence.split("\\s+");
    String longestWord = "";

    for (String word : words) {
      if (word.length() > longestWord.length()) {
        longestWord = word;
      }
    }

    return longestWord;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a sentence: ");
    String input = scanner.nextLine();

    String longest = findLongestWord(input);

    System.out.println("Longest word: " + longest);
    System.out.println("Length: " + longest.length());

    scanner.close();
  }
}
