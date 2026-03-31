/*
Write a program to take user input for 5 numbers and check whether a number is positive, negative, or zero. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they equal, greater or less
Hint => 
Define an integer array of 5 elements and get user input to store in the array.
Loop through the array using the length If the number is positive, check for even or odd numbers and print accordingly
If the number is negative, print negative. Else if the number is zero, print zero. 
Finally compare the first and last element of the array and display if they equal, greater or less
*/

import java.util.Scanner;

public class NumberCheckArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numbers = new int[5];
    System.out.println("Enter 5 numbers:");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = sc.nextInt();
    }
    for (int num : numbers) {
      if (num > 0) {
        if (num % 2 == 0) {
          System.out.println(num + " is a Positive Even number.");
        } else {
          System.out.println(num + " is a Positive Odd number.");
        }
      } else if (num < 0) {
        System.out.println(num + " is a Negative number.");
      } else {
        System.out.println(num + " is Zero.");
      }
    }

    if (numbers[0] == numbers[numbers.length - 1]) {
      System.out.println("The first and last elements are equal.");
    } else if (numbers[0] > numbers[numbers.length - 1]) {
      System.out.println("The first element is greater than the last element.");
    } else {
      System.out.println("The first element is less than the last element.");
    }

    sc.close();
  }
}
