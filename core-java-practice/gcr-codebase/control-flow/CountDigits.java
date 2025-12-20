import java.util.Scanner;

/*
 * Problem: Count the number of digits in an integer
 * 
 * Hint:
 * - Get an integer input for the number variable
 * - Create an integer variable count with value 0
 * - Use a loop to iterate until number is not equal to 0
 * - Remove the last digit from number in each iteration (using division by 10)
 * - Increase count by 1 in each iteration
 * - Finally display the count to show the number of digits
 */

public class CountDigits {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number to count its digits: ");
    int number = scanner.nextInt();

    number = Math.abs(number);

    int count = 0;

    while (number != 0) {
      number = number / 10;

      count++;
    }

    System.out.println("Number of digits: " + count);

    scanner.close();
  }
}
