/*
Write a program to demonstrate ArrayIndexOutOfBoundsException
Hint => 
Define a variable of array of names and take input from the user
Write a Method to generate the Exception. Here access index larger then the length of the array. This will generate a runtime exception and abruptly stop the program. 
Write the Method to demonstrate ArrayIndexOutOfBoundsException. Here access index larger then the length of the array. This will generate a runtime exception. Use the try-catch block to handle the ArrayIndexOutOfBoundsException and the generic runtime exception
From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
*/

import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] names = new String[3];
    for (int i = 0; i < names.length; i++) {
      System.out.print("Enter name " + (i + 1) + ": ");
      names[i] = sc.nextLine();
    }
    // generateArrayIndexOutOfBoundsException(names);
    handleArrayIndexOutOfBoundsException(names);

    sc.close();
  }

  private static void generateArrayIndexOutOfBoundsException(String[] names) {
    // This will throw ArrayIndexOutOfBoundsException
    System.out.println("Accessing invalid index: " + names[names.length]);
  }

  private static void handleArrayIndexOutOfBoundsException(String[] names) {
    try {
      System.out.println(names[names.length]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }

  }
}
