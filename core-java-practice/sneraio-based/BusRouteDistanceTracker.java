/*
Bus Route Distance Tracker 🚌
Each stop adds distance.
● Ask if the passenger wants to get off at a stop.
● Use a while-loop with a total distance tracker.
● Exit on user confirmation.
*/

import java.util.Scanner;

public class BusRouteDistanceTracker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double totalDistance = 0.0;

    while (true) {
      System.out.print("Enter distance to next stop (in km): ");
      double distanceToNextStop = scanner.nextDouble();
      totalDistance += distanceToNextStop;

      System.out.print("Do you want to get off at this stop? (yes/no): ");
      String response = scanner.next();

      if (response.equalsIgnoreCase("yes")) {
        break;
      }
    }
    System.out.printf("Total distance traveled: %.2f km%n", totalDistance);
    scanner.close();

  }

}
