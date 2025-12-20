import java.util.Scanner;

public class Factorial {
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

    // Compute factorial using while loop
    long factorial = 1;
    int i = number;
    while (i >= 1) {
      factorial *= i;
      i--;
    }

    System.out.println("Factorial of " + number + " is: " + factorial);

    sc.close();
  }
}
