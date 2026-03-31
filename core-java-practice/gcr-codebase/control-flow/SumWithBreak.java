import java.util.Scanner;

public class SumWithBreak {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double total = 0.0;

    while (true) {
      System.out.print("Enter a number (0 or negative to stop): ");
      double userInput = sc.nextDouble();

      if (userInput <= 0) {
        break;
      }

      total += userInput;
    }

    System.out.println("Sum: " + total);

    sc.close();
  }
}
