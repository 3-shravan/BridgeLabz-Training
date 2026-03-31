/*
Write a program to find the frequency of characters in a string using unique characters and display the result
Hint => 
Create a method to Find unique characters in a string using the charAt() method and return them as a 1D array. Use Nested Loops to find the unique characters in the text
Create a method to find the frequency of characters in a string and return the characters and their frequencies in a 2D array. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Call the uniqueCharacters() method to find the unique characters in the text
Create a 2D String array to store the unique characters and their frequencies. 
Loop through the unique characters and store the characters and their frequencies
In the main function take user inputs, call user-defined methods, and displays result.
*/

import java.util.Scanner;

public class CharacterFrequencyUnique {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = sc.nextLine();
    String[][] freq = findFreq(text);
    for (String[] pair : freq) {
      if (pair != null) {
        System.out.println(pair[0] + "" + pair[1]);
      }
    }

    sc.close();

  }

  private static String[][] findFreq(String text) {
    int[] freq = new int[256];
    for (int i = 0; i < text.length(); i++) {
      freq[text.charAt(i)]++;
    }

    char[] uniqueChars = uniqueCharacters(text);
    String[][] result = new String[uniqueChars.length][2];
    for (int i = 0; i < uniqueChars.length; i++) {
      result[i][0] = String.valueOf(uniqueChars[i]);
      result[i][1] = String.valueOf(freq[uniqueChars[i]]);
    }
    return result;
  }

  private static char[] uniqueCharacters(String text) {
    char[] charArray = text.toCharArray();
    int[] freq = new int[charArray.length];

    for (int i = 0; i < charArray.length; i++) {

      if (charArray[i] == '0')
        continue;

      freq[i] = 1;

      for (int j = i + 1; j < charArray.length; j++) {
        if (charArray[i] == charArray[j]) {
          freq[i]++;
          charArray[j] = '0'; // mark as visited
        }
      }
    }

    char[] result = new char[charArray.length];
    int index = 0;
    for (char c : charArray) {
      if (c != '0') {
        result[index++] = c;
      }
    }

    char[] uniqueResult = new char[index];
    System.arraycopy(result, 0, uniqueResult, 0, index);
    return uniqueResult;
  }

  // without nested loops
  // private static char[] toUniqueCharArray(String str) {
  // int[] charCount = new int[256];

  // for (int i = 0; i < str.length(); i++) {
  // charCount[str.charAt(i)]++;
  // }

  // int uniqueChars = 0;
  // for (int count : charCount) {
  // if (count > 0)
  // uniqueChars++;
  // }
  // char[] uniqueCharacters = new char[uniqueChars];
  // int index = 0;
  // for (int i = 0; i < charCount.length; i++) {
  // if (charCount[i] > 0) {
  // uniqueCharacters[index] = (char) i;
  // index++;
  // }
  // }
  // return uniqueCharacters;
  // }

}
