/*
Write a program to check if two texts are anagrams and display the result
Hint => 
An anagram is a word or phrase formed by rearranging the same letters to form different words or phrases
Write a method to check if two texts are anagrams. The logic used here is as follows:
Check if the lengths of the two texts are equal
Create an array to store the frequency of characters in the strings for the two text
Find the frequency of characters in the two texts using the loop
Compare the frequency of characters in the two texts. If the frequencies are not equal, return false
In the main function take user inputs, call user-defined methods, and displays result.
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
