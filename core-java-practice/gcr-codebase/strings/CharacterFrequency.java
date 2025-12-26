/*
Write a program to find the frequency of characters in a string using the charAt() method and display the result
Hint => 
Create a method to find the frequency of characters in a string using the charAt() method and return the characters and their frequencies in a 2D array. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Create an array to store the characters and their frequencies
Loop through the characters in the text and store the characters and their frequencies
In the main function take user inputs, call user-defined methods, and displays result.
*/

import java.util.Scanner;

public class CharacterFrequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the text: ");
    String text = sc.nextLine();
    int[][] frequency = findCharacterFrequency(text);
    System.out.println("Character Frequency:");
    for (int i = 0; i < frequency.length; i++) {
      System.out.println((char) frequency[i][0] + " : " + frequency[i][1]);
    }

    sc.close();
  }

  private static int[][] findCharacterFrequency(String text) {

    int[] charCount = new int[256];

    for (int i = 0; i < text.length(); i++) {
      charCount[text.charAt(i)]++;
    }

    int uniqueChars = 0;
    for (int count : charCount) {
      if (count > 0)
        uniqueChars++;
    }

    int[][] freq = new int[uniqueChars][2];
    int index = 0;
    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] > 0) {
        freq[index][0] = i;
        freq[index][1] = charCount[i];
        index++;
      }
    }
    return freq;

  }
}
