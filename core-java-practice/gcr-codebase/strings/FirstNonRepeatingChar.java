/*
Write a program to find the first non-repeating character in a string and show the result
Hint => 
Non-repeating character is a character that occurs only once in the string
Create a Method to find the first non-repeating character in a string using the charAt() method and return the character. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Loop through the text to find the first non-repeating character in the text by checking the frequency of each character
In the main function take user inputs, call user-defined methods, and displays result.
*/

import java.util.Scanner;

public class FirstNonRepeatingChar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String input = sc.nextLine();

    char result = findFirstNonRepeatingChar(input.trim());
    if (result != '\0') {
      System.out.println("The first non-repeating character is: " + result);
    } else {
      System.out.println("No non-repeating character found.");
    }

    sc.close();
  }

  private static char findFirstNonRepeatingChar(String input) {
    int[] charCount = new int[256];
    for (int i = 0; i < input.length(); i++) {
      charCount[input.charAt(i)]++;
    }
    for (int i = 0; i < input.length(); i++) {
      if (charCount[input.charAt(i)] == 1) {
        return input.charAt(i);
      }
    }
    return '\0'; // Return null character if no non-repeating character is found
  }
}
