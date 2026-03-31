/*
Write a program to split the text into words, compare the result with the split() method and display the result 
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to find the length of the String without using the built-in length() method. 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words. Use the following logic
Firstly Count the number of words in the text and create an array to store the indexes of the spaces for each word in a 1D array
Then Create an array to store the words and use the indexes to extract the words
Create a method to compare the two String arrays and return a boolean
The main function calls the user-defined method and the built-in split() method. Call the user defined method to compare the two string arrays and display the result
*/

import java.util.Scanner;

public class SplitTextCompare {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] words = createWordsArray(str);
    String[] splitWords = str.split(" ");

    boolean result = compareArrays(words, splitWords);

    System.out.println("\nCustom Split Output:");
    for (String s : words) {
      System.out.println(s);
    }

    System.out.println("\nBuilt-in Split Output:");
    for (String s : splitWords) {
      System.out.println(s);
    }

    System.out.println("\nAre both results same? " + result);

    sc.close();
  }

  private static String[] createWordsArray(String str) {

    int wordCount = 1;
    int length = getStringLength(str);

    // Count words
    for (int i = 0; i < length; i++) {
      if (str.charAt(i) == ' ') {
        wordCount++;
      }
    }

    // Store space indexes
    int[] spaceIndexes = new int[wordCount - 1];
    int index = 0;

    for (int i = 0; i < length; i++) {
      if (str.charAt(i) == ' ') {
        spaceIndexes[index++] = i;
      }
    }

    // Extract words
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

  public static boolean compareArrays(String[] a, String[] b) {

    if (a.length != b.length)
      return false;

    for (int i = 0; i < a.length; i++) {
      if (!a[i].equals(b[i]))
        return false;
    }
    return true;
  }
}
