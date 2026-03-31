/*
Create a program to save odd and even numbers into odd and even arrays between 1 to the number entered by the user. Finally, print the odd and even numbers array
Hint => 
Get an integer input from the user, assign it to a variable number, and check for Natural Number. If not a natural number then print an error and exit the program
Create an integer array for even and odd numbers with size = number / 2 + 1
Create index variables for odd and even numbers and initialize them to zero
Using a for loop, iterate from 1 to the number, and in each iteration of the loop, save the odd or even number into the corresponding array
Finally, print the odd and even numbers array using the odd and even index
*/

import java.util.Scanner;

public class OddEvenArrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number;
    System.out.print("Enter a natural number: ");
    number = sc.nextInt();
    if (number < 1) {
      System.out.println("Please enter a natural number (greater than 0).");
      sc.close();
      return;
    }
    int evenSize = number / 2 + 1;
    int oddSize = number / 2 + 1;
    int[] evenNumbers = new int[evenSize];
    int[] oddNumbers = new int[oddSize];
    int evenIndex = 0;
    int oddIndex = 0;
    for (int i = 1; i <= number; i++) {
      if (i % 2 == 0) {
        evenNumbers[evenIndex] = i;
        evenIndex++;
      } else {
        oddNumbers[oddIndex] = i;
        oddIndex++;
      }
    }
    System.out.println("Even numbers:");
    for (int i = 0; i < evenIndex; i++) {
      System.out.print(evenNumbers[i] + " ");
    }
    System.out.println("\nOdd numbers:");
    for (int i = 0; i < oddIndex; i++) {
      System.out.print(oddNumbers[i] + " ");
    }
    System.out.println();

    sc.close();
  }
}
