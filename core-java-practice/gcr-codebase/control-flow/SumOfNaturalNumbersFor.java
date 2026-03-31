import java.util.Scanner;

public class SumOfNaturalNumbersFor {
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

    // Sum using for loop
    long loopSum = 0;
    for (int i = 1; i <= n; i++) {
      loopSum += i;
    }

    System.out.println("Sum using formula: " + formulaSum);
    System.out.println("Sum using for loop: " + loopSum);

    if (formulaSum == loopSum) {
      System.out.println("Both results are correct and match!");
    } else {
      System.out.println("Results do not match!");
    }

    sc.close();
  }
}
