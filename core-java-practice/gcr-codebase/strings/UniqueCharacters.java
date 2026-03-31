/*
Find unique characters in a string using the charAt() method and display the result
Hint => 
Create a Method to find the length of the text without using the String method length()
Create a method to Find unique characters in a string using the charAt() method and return them as a 1D array. The logic used here is as follows:
Create an array to store the unique characters in the text. The size is the length of the text
Loops to Find the unique characters in the text. Find the unique characters in the text using a nested loop. An outer loop iterates through each character and an inner loop checks if the character is unique by comparing it with the previous characters. If the character is unique, it is stored in the result array
Create a new array to store the unique characters 
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class UniqueCharacters {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char[] uniqueChars = findUniqueCharacters(str);
    System.out.println("Unique characters in the string:");
    for (char ch : uniqueChars) {
      System.out.print(ch + " ");
    }
    System.out.println();
    sc.close();
  }

  private static int getStringLength(String str) {
    int length = 0;
    try {
      while (true) {
        str.charAt(length);
        length++;
      }
    } catch (StringIndexOutOfBoundsException e) {
      // Reached the end of the string
    }
    return length;
  }

  private static char[] findUniqueCharacters(String str) {
    int length = getStringLength(str);
    char[] uniqueChars = new char[length];
    int uniqueCount = 0;

    for (int i = 0; i < length; i++) {
      char currentChar = str.charAt(i);
      boolean isUnique = true;

      for (int j = 0; j < i; j++) {
        if (str.charAt(j) == currentChar) {
          isUnique = false;
          break;
        }
      }

      if (isUnique) {
        uniqueChars[uniqueCount] = currentChar;
        uniqueCount++;
      }
    }

    char[] result = new char[uniqueCount];
    for (int i = 0; i < uniqueCount; i++) {
      result[i] = uniqueChars[i];
    }
    return result;
  }
}