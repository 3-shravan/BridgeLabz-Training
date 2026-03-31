/*
Write a program to split the text into words and return the words along with their lengths in a 2D array
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
The main function calls the user-defined method and displays the result in a tabular format. During display make sure to convert the length value from String to Integer and then display
*/

import java.util.Scanner;

public class WordsWithLengths {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    // Split text into words
    String[] words = splitText(str);

    // Create 2D array (word, length)
    String[][] result = createWordLengthArray(words);

    for (int i = 0; i < result.length; i++) {
      String word = result[i][0];
      int length = Integer.parseInt(result[i][1]);
      System.out.println(word + "\t" + length);
    }

    sc.close();
  }

  private static String[] splitText(String str) {
    int wordCount = 1;
    int length = getStringLength(str);

    for (int i = 0; i < length; i++) {
      if (str.charAt(i) == ' ') {
        wordCount++;
      }
    }

    int[] spaceIndexes = new int[wordCount - 1];

    int index = 0;
    for (int i = 0; i < length; i++) {
      if (str.charAt(i) == ' ') {
        spaceIndexes[index++] = i;
      }
    }
    String[] words = new String[wordCount];
    int start = 0;
    for (int i = 0; i < spaceIndexes.length; i++) {
      words[i] = str.substring(start, spaceIndexes[i]);
      start = spaceIndexes[i] + 1;
    }

    // Extract last word
    words[wordCount - 1] = str.substring(start, length);
    return words;
  }

  private static int getStringLength(String str) {
    int count = 0;
    try {
      while (true) {
        str.charAt(count);
        count++;
      }
    } catch (Exception e) {
      return count;
    }
  }

  private static String[][] createWordLengthArray(String[] words) {

    String[][] data = new String[words.length][2];

    for (int i = 0; i < words.length; i++) {
      data[i][0] = words[i];
      data[i][1] = String.valueOf(getStringLength(words[i]));// Convert length to String
    }

    return data;
  }
}
