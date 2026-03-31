/*
Rework the program, especially the Hint f where if index equals maxDigit, we break from the loop. Here we want to modify to Increase the size of the array i.e maxDigit by 10 if the index is equal to maxDigit. This is done to consider all digits to find the largest and second-largest number 
Hint => 
In Hint f inside the loop if the index is equal to maxDigit, increase maxDigit and make digits array to store more elements. 
To do this, we need to create a new temp array of size maxDigit, copy from the current digits array the digits into the temp array, and assign the current digits array to the temp array
Now the digits array will be able to store all digits of the number in the array and then find the largest and second largest number
*/

import java.util.Scanner;

public class LargestSecondLargestDigitExtended {
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
        maxDigit += 10;
        int[] temp = new int[maxDigit];
        for (int j = 0; j < digits.length; j++) {
          temp[j] = digits[j];
        }
        digits = temp;
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
