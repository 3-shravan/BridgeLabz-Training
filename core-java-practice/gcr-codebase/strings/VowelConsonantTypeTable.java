/*
Write a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter
Hint => 
Create a method to check if the character is a vowel or consonant and return the result. The logic used here is as follows:
Convert the character to lowercase if it is an uppercase letter using the ASCII values of the characters
Check if the character is a vowel or consonant and return Vowel, Consonant, or Not a Letter
Create a Method to find vowels and consonants in a string using charAt() method and return the character and vowel or consonant in a 2D array
Create a Method to display the 2D Array of Strings in a Tabular Format
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result
*/

import java.util.Scanner;

public class VowelConsonantTypeTable {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    String[][] table = getVowelConsonantTypeTable(str);
    System.out.println("Character\tType");
    for (int i = 0; i < table.length; i++) {
      System.out.println(table[i][0] + "\t\t" + table[i][1]);
    }
    sc.close();
  }

  private static char checkLetter(char ch) {
    if (ch >= 'A' && ch <= 'Z') {
      ch = (char) (ch + 32); // Convert to lowercase
    }
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
      return 'V'; // Vowel
    } else if (ch >= 'a' && ch <= 'z') {
      return 'C'; // Consonant
    } else {
      return 'N'; // Not a letter
    }
  }

  private static String[][] getVowelConsonantTypeTable(String str) {
    int length = str.length();
    String[][] table = new String[length][2];

    for (int i = 0; i < length; i++) {
      char ch = str.charAt(i);
      char result = checkLetter(ch);
      String type;
      if (result == 'V') {
        type = "Vowel";
      } else if (result == 'C') {
        type = "Consonant";
      } else {
        type = "Not a Letter";
      }
      table[i][0] = String.valueOf(ch);
      table[i][1] = type;
    }

    return table;
  }
}
