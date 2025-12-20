import java.util.Scanner;

/*
 * Problem: Check if a number is Armstrong or not
 * 
 * Hint:
 * - Armstrong Number is a number whose Sum of cubes of each digit results in the original number
 * - Example: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
 * - Get an integer input and store it in the number variable
 * - Define sum variable, initialize it to zero and originalNumber variable and assign it to input number
 * - Use while loop till the originalNumber is not equal to zero
 * - In the while loop, find each digit (remainder of number % 10), find the cube and add to sum
 * - In while loop, find quotient (number / 10) and assign to originalNumber (removes last digit)
 * - Finally check if the number and the sum are the same
 */

public class ArmstrongNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number to check if it's an Armstrong Number: ");
    int number = scanner.nextInt();

    int originalNumber = number;

    int sum = 0;

    while (originalNumber != 0) {
      int digit = originalNumber % 10;

      sum = sum + (digit * digit * digit);

      originalNumber = originalNumber / 10;
    }

    if (number == sum) {
      System.out.println(number + " is an Armstrong Number");
    } else {
      System.out.println(number + " is not an Armstrong Number");
    }

    scanner.close();
  }
}
