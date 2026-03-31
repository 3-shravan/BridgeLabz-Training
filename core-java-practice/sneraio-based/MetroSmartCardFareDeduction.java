/*Metro Smart Card Fare Deduction 🚇
In Delhi Metro, fare varies by distance.
● Ask the user for distance.
● Calculate fare using ternary operator.
● Deduct from smart card balance.
Loop until balance is exhausted or the user quits. */

public class MetroSmartCardFareDeduction {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    double balance = 500.0; // Initial balance on the smart card

    while (true) {
      System.out.println("Current Balance: ₹" + balance);
      System.out.print("Enter distance to travel in km (or type 0 to quit): ");
      int distance = scanner.nextInt();
      if (distance == 0) {
        System.out.println("Exiting. Thank you for using the Metro Smart Card.");
        break;
      }

      double fare = (distance <= 5) ? 20 : (distance <= 15) ? 40 : 60;

      if (fare > balance) {
        System.out.println("Insufficient balance for this trip. Please recharge your smart card.");
        continue;
      }

      balance -= fare;
      System.out.println("Fare for " + distance + " km is ₹" + fare + ". New Balance: ₹" + balance);

      if (balance <= 0) {
        System.out.println("Balance exhausted. Please recharge your smart card.");
        break;
      }
    }

    scanner.close();

  }
}
