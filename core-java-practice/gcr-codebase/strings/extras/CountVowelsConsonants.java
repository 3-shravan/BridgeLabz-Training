/*
 * 1. Count Vowels and Consonants
 * Problem:
 * Write a Java program to count the number of vowels and consonants in a given string.
 */

import java.util.Scanner;

public class CountVowelsConsonants {

  public static int[] countVowelsAndConsonants(String str) {
    int vowels = 0;
    int consonants = 0;

    str = str.toLowerCase();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch >= 'a' && ch <= 'z') {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
          vowels++;
        } else {
          consonants++;
        }
      }
    }

    return new int[] { vowels, consonants };
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = scanner.nextLine();

    int[] result = countVowelsAndConsonants(input);

    System.out.println("Number of Vowels: " + result[0]);
    System.out.println("Number of Consonants: " + result[1]);

    scanner.close();
  }
}
