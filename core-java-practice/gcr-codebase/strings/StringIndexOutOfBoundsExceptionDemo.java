/*
Write a program to demonstrate StringIndexOutOfBoundsException
Hint => 
Define a variable of type String and take user input to assign a value
Write a Method to generate the Exception. Access the index using charAt() beyond the length of the String. This will generate a runtime exception and abruptly stop the program.
Write the Method to demonstrate StringIndexOutOfBoundsException. Access the index using charAt() beyond the length of the String. Then write try catch block for Exception while accessing the String method
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/

import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    // generateStringIndexOutOfBoundsException(str);
    handleStringIndexOutOfBoundsException(str); 

    sc.close();
  }

  private static void generateStringIndexOutOfBoundsException(String str) {
    // This will throw StringIndexOutOfBoundsException
    System.out.println("Character at invalid index: " + str.charAt(str.length()));
  }

  private static void handleStringIndexOutOfBoundsException(String str) {
    try {
      // This will throw StringIndexOutOfBoundsException
      System.out.println("Character at invalid index: " + str.charAt(str.length()));
    } catch (StringIndexOutOfBoundsException e) {
      System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
    }
  }
}