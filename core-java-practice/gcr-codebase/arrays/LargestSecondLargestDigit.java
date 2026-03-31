/*
Create a program to store the digits of the number in an array and find the largest and second largest element of the array.
Hint => 
Create a number variable and Take user input. 
Define an array to store the digits. Set the size of the array to maxDigit variable initially set to 10
Create an integer variable index with the value 0 to reflect the array index.
Use a loop to iterate until the number is not equal to 0.
Remove the last digit from the number in each iteration and add it to the array.
Increment the index by 1 in each iteration and if the index count equals maxDigit then break out of the loop and the remaining digits are not added to the array
Define variable to store largest and second largest digit and initialize it to zero
Loop through the array and use conditional statements to find the largest and second largest number in the array
Finally display the largest and second-largest number
*/

import java.util.Scanner;

public class LargestSecondLargestDigit {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number;
    int maxDigit = 10;
    int[] digits = new int[maxDigit];
    int index = 0;
    System.out.print("Enter a positive integer: ");
    number = sc.nextInt();
    if (number < 0) {
      System.out.println("Please enter a positive integer");
      return;
    }
    int tempNumber = number;
    while (tempNumber != 0) {
      if (index == maxDigit) {
        break;
      }
      digits[index] = tempNumber % 10;
      tempNumber /= 10;
      index++;
    }
    int largest = -1;
    int secondLargest = -1;
    for (int i = 0; i < index; i++) {
      if (digits[i] > largest) {
        secondLargest = largest;
        largest = digits[i];
      } else if (digits[i] > secondLargest && digits[i] != largest) {
        secondLargest = digits[i];
      }
    }
    System.out.println("Largest digit: " + largest);
    if (secondLargest != -1) {
      System.out.println("Second largest digit: " + secondLargest);
    } else {
      System.out.println("There is no second largest digit.");
    }

    sc.close();
  }
}
