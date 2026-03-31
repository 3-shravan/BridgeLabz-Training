import java.util.Scanner;

public class FactorialFor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter an integer: ");
    int number = sc.nextInt();

    // Check if it's a positive integer
    if (number < 0) {
      System.out.println("Please enter a positive integer");
      sc.close();
      return;
    }

    if (number == 0 || number == 1) {
      System.out.println("Factorial of " + number + " is: 1");
      sc.close();
      return;
    }

    // Compute factorial using for loop
    long factorial = 1;
    for (int i = number; i >= 1; i--) {
      factorial *= i;
    }

    System.out.println("Factorial of " + number + " is: " + factorial);

    sc.close();
  }
}
