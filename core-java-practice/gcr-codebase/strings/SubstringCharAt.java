/*
Write a program to create a substring from a String using the charAt() method. Also, use the String built-in method substring() to find the substring of the text. Finally compare the two strings and display the results
Hint => 
Take user input using the Scanner next() method to take the String variable and also the start and the end index to get the substring from the given text
Write a method to create a substring from a string using the charAt() method with the string, start, and end index as the parameters
Write a method to compare two strings using the charAt() method and return a boolean result
Use the String built-in method substring() to get the substring and compare the two strings. And finally display the result
*/

import java.util.Scanner;

public class SubstringCharAt {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the main string: ");
    String str = sc.next();
    System.out.print("Enter the start index for substring: ");
    int start = sc.nextInt();
    System.out.print("Enter the end index for substring: ");
    int end = sc.nextInt();

    String subStringwithChatAt = makeSubString(str, start, end);
    String subStringWithBuiltIn = str.substring(start, end);

    System.out.println(compareStrings(subStringwithChatAt, subStringWithBuiltIn));

    sc.close();
  }

  private static String makeSubString(String str, int start, int end) {
    StringBuilder substring = new StringBuilder();
    for (int i = start; i < end; i++) {
      substring.append(str.charAt(i));
    }
    return substring.toString();
  }

  private static boolean compareStrings(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
