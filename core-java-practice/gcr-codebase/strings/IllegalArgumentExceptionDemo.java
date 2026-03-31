/*
Write a program to demonstrate IllegalArgumentException
Hint => 
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Here use the subString() and set the start index to be greater than the end index. This will generate a runtime exception and abruptly stop the program. 
Write the Method to demonstrate IllegalArgumentException. Here use the subString() and set the start index to be greater than the end index. This will generate a runtime exception. Use the try-catch block to handle the IllegalArgumentException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/

import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    // generateIllegalArgumentException(str);
    handleIllegalArgumentException(str);

    sc.close();
  }

  private static void generateIllegalArgumentException(String str) {
    // This will throw IllegalArgumentException
    System.out.println("Substring with invalid indices: " + str.substring(5, 2));
  }

  private static void handleIllegalArgumentException(String str) {
    try {
      System.out.println("Substring with invalid indices: " + str.substring(5, 2));
    } catch (IllegalArgumentException e) {
      System.out.println("Caught IllegalArgumentException: " + e.getMessage());
    } 
    catch (RuntimeException e) {
      System.out.println("Caught RuntimeException: " + e.getMessage());
    }
  }
}