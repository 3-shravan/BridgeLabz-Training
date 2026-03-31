/*
Write a program to convert the complete text to lowercase and compare the results
Hint => 
Take user input using the Scanner nextLine() method to take the complete text into a String variable
Write a method using the String built-in charAt() method to convert each character if it is uppercase to the lowercase. Use the logic ASCII value of 'a' is 97 and 'A' is 65 so the difference is 32, similarly ASCII value of 'b' is 98 and 'B' is 66 so the difference is 32, and so on
Write a method to compare two strings using the charAt() method and return a boolean result
In the main() use the String built-in method toLowerCase() to get the lowercase text and compare the two strings using the user-defined method. And finally display the result
*/

import java.util.Scanner;

public class LowercaseCompare {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    String str = sc.nextLine();
    String lowerCaseWithCharAt = convertToLowercaseUsingCharAt(str);
    String lowerCaseWithBuildIn = str.toLowerCase();

    System.out.println(lowerCaseWithBuildIn.equals(lowerCaseWithCharAt));
    sc.close();
  }

  private static String convertToLowercaseUsingCharAt(String str) {
    StringBuilder lowerCaseStr = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch >= 'A' && ch <= 'Z') {
        char lowerCh = (char) (ch + 32);
        lowerCaseStr.append(lowerCh);
      } else {
        lowerCaseStr.append(ch);
      }
    }
    return lowerCaseStr.toString();
  }
}
