/*
Write a program to demonstrate NullPointerException. 
Hint => 
Write a Method to generate the Exception. Here define the variable text and initialize it to null. Then call one of the String Method to generate the exception
Write the Method to demonstrate NullPointerException. Here define the variable text and initialize it to null. Then write try catch block for handling the Exception while accessing one of the String method
From the main Firstly call the method to generate the Exception then refactor the code to call the method to handle the RuntimeException
*/

import java.util.Scanner;

public class NullPointerExceptionDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Demonstrating NullPointerException:");
    generateNullPointerException();
    System.out.println("\nHandling NullPointerException:");
    handleNullPointerException();

    sc.close();
  }

  private static void generateNullPointerException() {
    String text = null;
    // This will throw NullPointerException
    System.out.println("Length of the string: " + text.length());
  }

  private static void handleNullPointerException() {
    String text = null;
    try {
      // This will throw NullPointerException
      System.out.println("Length of the string: " + text.length());
    } catch (NullPointerException e) {
      System.out.println("Caught NullPointerException: " + e.getMessage());
    }
  }
}
