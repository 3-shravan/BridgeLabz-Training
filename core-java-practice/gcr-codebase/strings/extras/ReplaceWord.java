/*
 * 12. Replace Word in Sentence
 * Problem:
 * Write a replace method in Java that replaces a given word with another word in a sentence.
 */

import java.util.Scanner;

public class ReplaceWord {

  public static String replaceWord(String sentence, String oldWord, String newWord) {
    String result = "";
    String[] words = sentence.split(" ");

    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(oldWord)) {
        result += newWord;
      } else {
        result += words[i];
      }

      if (i < words.length - 1) {
        result += " ";
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a sentence: ");
    String sentence = scanner.nextLine();

    System.out.print("Enter the word to replace: ");
    String oldWord = scanner.nextLine();

    System.out.print("Enter the replacement word: ");
    String newWord = scanner.nextLine();

    String result = replaceWord(sentence, oldWord, newWord);

    System.out.println("Original Sentence: " + sentence);
    System.out.println("Modified Sentence: " + result);

    scanner.close();
  }
}
