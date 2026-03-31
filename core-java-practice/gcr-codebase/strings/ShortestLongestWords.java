/*
Write a program to split the text into words and find the shortest and longest strings in a given text
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
Create a Method that takes the 2D array of word and corresponding length as parameters, find the shortest and longest string and return them in an 1D int array. 
The main function calls the user-defined methods and displays the result. 
*/

import java.util.Scanner;

public class ShortestLongestWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();

    // Split text into words
    String[] words = splitText(str);

    // Create 2D array (word, length)
    String[][] result = createWordLengthArray(words);

    int[] resultIndexes = findShortestAndLongest(result);

    System.out.println("\nShortest Word: "
        + result[resultIndexes[0]][0]);

    System.out.println("Longest Word: "
        + result[resultIndexes[1]][0]);

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

  private static int[] findShortestAndLongest(String[][] data) {

    int minIndex = 0;
    int maxIndex = 0;

    int minLength = Integer.parseInt(data[0][1]);
    int maxLength = Integer.parseInt(data[0][1]);

    for (int i = 1; i < data.length; i++) {

      int currentLength = Integer.parseInt(data[i][1]);

      if (currentLength < minLength) {
        minLength = currentLength;
        minIndex = i;
      }

      if (currentLength > maxLength) {
        maxLength = currentLength;
        maxIndex = i;
      }
    }

    return new int[] { minIndex, maxIndex };
  }
}
