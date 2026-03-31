/*
Write a program to find the frequency of characters in a string using nested loops and display the result
Hint => 
Create a method to find the frequency of characters in a string and return the characters and their frequencies in a 1D array. The logic used here is as follows:
Create an array to store the frequency of each character in the text and an array to store the characters in the text using the toCharArray() method
Loops to Find the frequency of each character in the text and store the result in a frequency array. For this use a Nested Loop with an Outer loop to iterate through each character in the text and initialize the frequency of each character to 1. And an Inner loop to check for duplicate characters. In case of duplicate increment the frequency value and set the duplicate characters to '0' to avoid counting them again.
Create a 1D String array to store the characters and their frequencies. For this Iterate through the characters in the text and store the characters and their frequencies 
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class CharacterFrequencyNestedLoops {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();

    findFreq(text);

    sc.close();
  }

  private static void findFreq(String text) {

    char[] charArray = text.toCharArray();
    int[] freq = new int[charArray.length];
    for (int i = 0; i < charArray.length; i++) {
      freq[i] = 1;
      for (int j = i + 1; j < charArray.length; j++) {
        if (charArray[i] == charArray[j]) {
          freq[i]++;
          charArray[j] = '0';
        }
      }
    }

    String[] result = new String[charArray.length];
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] != ' ' && charArray[i] != '0') {
        result[i] = charArray[i] + "" + freq[i];
        System.out.println(charArray[i] + "" + freq[i]);
      }
    }

  }
}
