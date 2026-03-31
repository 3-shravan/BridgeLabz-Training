import java.util.Scanner;

public class AbundantNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number to check if it's an Abundant Number: ");
    int number = scanner.nextInt();

    int sum = 0;

    for (int i = 1; i < number; i++) {
      if (number % i == 0) {
        sum = sum + i;
      }
    }

    if (sum > number) {
      System.out.println(number + " is an Abundant Number");
      System.out.println("Sum of divisors: " + sum);
    } else {
      System.out.println(number + " is not an Abundant Number");
      System.out.println("Sum of divisors: " + sum);
    }

    scanner.close();
  }
}
