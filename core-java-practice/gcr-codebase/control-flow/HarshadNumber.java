import java.util.Scanner;

public class HarshadNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number to check if it's a Harshad Number: ");
    int number = scanner.nextInt();

    int originalNumber = number;

    int sum = 0;

    while (number != 0) {
      int digit = number % 10;
      sum = sum + digit;

      number = number / 10;
    }

    if (originalNumber % sum == 0) {
      System.out.println(originalNumber + " is a Harshad Number");
    } else {
      System.out.println(originalNumber + " is not a Harshad Number");
    }

    scanner.close();
  }
}
