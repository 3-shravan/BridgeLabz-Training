/*
Create a program to take a number as input, find the frequency of each digit using an array, and display the frequency.
Hint => 
- Take the input for a number
- Find the count of digits in the number
- Find the digits in the number and save them in an array
- Define a frequency array of size 10, loop through the digits array, and increase the frequency of each digit
- Display the frequency of each digit in the number
*/

import java.util.Scanner;

public class DigitFrequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a number: ");
    long number = sc.nextLong();

    if (number < 0) {
      number = Math.abs(number);
    }

    if (number == 0) {
      System.out.println("Digit frequencies:");
      System.out.println("0 -> 1");
      for (int d = 1; d <= 9; d++) {
        System.out.println(d + " -> 0");
      }
      sc.close();
      return;
    }

    int count = 0;
    long temp = number;
    while (temp != 0) {
      count++;
      temp /= 10;
    }

    int[] digits = new int[count];
    temp = number;
    for (int i = 0; i < count; i++) {
      digits[i] = (int) (temp % 10);
      temp /= 10;
    }

    int[] freq = new int[10];
    for (int i = 0; i < count; i++) {
      int d = digits[i];
      freq[d]++;
    }

    System.out.println("Digit frequencies:");
    for (int d = 0; d <= 9; d++) {
      System.out.println(d + " -> " + freq[d]);
    }

    sc.close();
  }
}
