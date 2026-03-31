/*
Create a program to take a number as input and reverse the number. To do this, store the digits of the number in an array and display the array in reverse order
Hint => 
Take user input for a number. 
Find the count of digits in the number. 
Find the digits in the number and save them in an array
Create an array to store the elements of the digits array in reverse order
Finally, display the elements of the array in reverse order
*/

import java.util.Scanner;

public class ReverseNumberArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number;

    System.out.print("Enter a positive integer: ");
    number = sc.nextInt();
    if (number < 0) {
      System.out.println("Please enter a positive integer");
      return;
    }
    int tempNumber = number;
    int digitCount = 0;
    while (tempNumber != 0) {
      tempNumber /= 10;
      digitCount++;
    }
    int[] digits = new int[digitCount];
    tempNumber = number;
    for (int i = 0; i < digitCount; i++) {
      digits[i] = tempNumber % 10;
      tempNumber /= 10;
    }
    System.out.println("Reversed number array:");
    for (int i = 0; i < digitCount; i++) {
      System.out.println(digits[i]);
    }
    System.out.println("Original number array:");
    for (int i = digitCount - 1; i >= 0; i--) {
      System.out.println(digits[i]);
    }
    

    sc.close();
  }
}
