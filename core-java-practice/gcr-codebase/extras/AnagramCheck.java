/*
 * 11. Anagram Check
 * Problem:
 * Write a Java program that accepts two strings from the user and checks if the two strings 
 * are anagrams of each other (i.e., whether they contain the same characters in any order).
 */

import java.util.Scanner;

public class AnagramCheck {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first text: ");
    String text1 = sc.nextLine();
    System.out.print("Enter the second text: ");
    String text2 = sc.nextLine();
    if (areAnagrams(text1, text2)) {
      System.out.println("The texts are anagrams.");
    } else {
      System.out.println("The texts are not anagrams.");
    }

    sc.close();
  }

  private static boolean areAnagrams(String text1, String text2) {

    if (text1.length() != text2.length()) {
      return false;
    }
    int[] charCount = new int[256];

    for (int i = 0; i < text1.length(); i++) {
      charCount[text1.charAt(i)]++;
      charCount[text2.charAt(i)]--;
    }

    for (int count : charCount) {
      if (count != 0)
        return false;
    }

    return true;
  }
}
