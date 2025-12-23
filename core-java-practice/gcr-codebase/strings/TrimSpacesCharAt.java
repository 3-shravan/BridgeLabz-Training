/*
Write a program to trim the leading and trailing spaces from a string using the charAt() method 
Hint => 
Create a method to trim the leading and trailing spaces from a string using the charAt() method. Inside the method run a couple of loops to trim leading and trailing spaces and determine the starting and ending points with no spaces. Return the start point and end point in an array
Write a method to create a substring from a string using the charAt() method with the string, start, and end index as the parameters
Write a method to compare two strings using the charAt() method and return a boolean result
The main function calls the user-defined trim and substring methods to get the text after trimming the leading and trailing spaces. Post that use the String built-in method trim() to trim spaces and compare the two strings. And finally display the result
*/

import java.util.Scanner;

public class TrimSpacesCharAt {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int[] trimIndexes = trimSpaces(str);
    String trimmedStr = substringUsingCharAt(str, trimIndexes[0], trimIndexes[1]);
    String builtInTrimmedStr = str.trim();
    boolean isSame = compareStrings(trimmedStr, builtInTrimmedStr);
    System.out.println("Trimmed String using charAt(): '" + trimmedStr + "'");
    System.out.println("Trimmed String using built-in trim(): '" + builtInTrimmedStr + "'");
    System.out.println("Are both trimmed strings same? " + isSame);

    sc.close();
  }

  private static String substringUsingCharAt(String str, int start, int end) {
    StringBuilder sb = new StringBuilder();
    for (int i = start; i < end; i++) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  private static boolean compareStrings(String str1, String str2) {
    int len1 = getStringLength(str1);
    int len2 = getStringLength(str2);

    if (len1 != len2) {
      return false;
    }

    for (int i = 0; i < len1; i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  private static int[] trimSpaces(String str) {
    int start = 0;
    int end = getStringLength(str) - 1;

    while (start <= end && str.charAt(start) == ' ') {
      start++;
    }

    while (end >= start && str.charAt(end) == ' ') {
      end--;
    }

    return new int[] { start, end + 1 };
  }

  private static int getStringLength(String str) {
    int count = 0;
    try {
      while (true) {
        str.charAt(count);
        count++;
      }
    } catch (StringIndexOutOfBoundsException e) {
      return count;
    }
  }
}
