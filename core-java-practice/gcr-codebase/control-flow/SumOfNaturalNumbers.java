import java.util.Scanner;

public class SumOfNaturalNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a natural number: ");
    int n = sc.nextInt();

    // Check if it's a natural number
    if (n <= 0) {
      System.out.println("Please enter a positive integer (natural number)");
      sc.close();
      return;
    }

    // Sum using formula: n * (n + 1) / 2
    long formulaSum = (long) n * (n + 1) / 2;

    // Sum using while loop
    long loopSum = 0;
    int counter = 1;
    while (counter <= n) {
      loopSum += counter;
      counter++;
    }

    System.out.println("Sum using formula: " + formulaSum);
    System.out.println("Sum using while loop: " + loopSum);

    if (formulaSum == loopSum) {
      System.out.println("Both results are correct and match!");
    } else {
      System.out.println("Results do not match!");
    }

    sc.close();
  }
}
