package com.shravan;

public class StringUtils {

  public static String reverse(String str) {
    if (str == null)
      return null;
    return new StringBuilder(str).reverse().toString();
  }

  public static boolean isPalindrome(String str) {
    if (str == null) {
      return false;
    }
    String reversed = reverse(str);
    return str.equals(reversed);
  }

  public static String toUpperCase(String str) {
    if (str == null) {
      return null;
    }
    return str.toUpperCase();
  }

}
