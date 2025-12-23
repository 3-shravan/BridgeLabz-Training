/*
Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
Hint => 
Take user input using the Scanner next() method for 2 String variables
Write a method to compare two strings using the charAt() method and return a boolean result
Use the String Built-In method to check if the results are the same and display the result
*/

import java.util.Scanner;

public class CompareStringsCharAt {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    String str1 = input.next();
    System.out.print("Enter the second string: ");
    String str2 = input.next();

    boolean areEqual = compareStringCharAt(str1, str2);
    boolean builtInEqual = str1.equals(str2);

    if (areEqual && areEqual == builtInEqual) {
      System.out.println("The results from charAt() comparison and built-in equals() method are the same.");
    } else {
      System.out.println("The results from charAt() comparison and built-in equals() method are different.");
    }
    input.close();
  }

  private static boolean compareStringCharAt(String str1, String str2) {
    if (str1.length() != str2.length()) {
      System.out.println("The strings are not equal.");
      return false;
    }

    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        System.out.println("The strings are not equal.");
        return false;
      }
    }
    System.out.println("The strings are equal.");
    return true;
  }
}
