/*
Write a program to convert the complete text to uppercase and compare the results
Hint => 
Take user input using the Scanner nextLine() method to take the complete text into a String variable
Write a method using the String built-in charAt() method to convert each character if it is lowercase to uppercase. Use the logic ASCII value of 'a' is 97 and 'A' is 65 so the difference is 32, similarly ASCII value of 'b' is 98 and 'B' is 66 so the difference is 32, and so on
Write a method to compare two strings using the charAt() method and return a boolean result
In the main() use the String built-in method toUpperCase() to get the uppercase text and compare the two strings using the user-defined method. And finally display the result
*/

import java.util.Scanner;

public class UppercaseCompare {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    String str = sc.nextLine();
    String upperCaseWithCharAt = convertToUpperCaseUsingCharAt(str);
    String upperCaseWithBuildIn = str.toUpperCase();

    System.out.println(upperCaseWithBuildIn.equals(upperCaseWithCharAt));
    sc.close();
  }

  private static String convertToUpperCaseUsingCharAt(String str) {
    StringBuilder upperCaseStr = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        char upperCh = (char) (ch - 32);
        upperCaseStr.append(upperCh);
      } else {
        upperCaseStr.append(ch);
      }
    }
    return upperCaseStr.toString();
  }
}
