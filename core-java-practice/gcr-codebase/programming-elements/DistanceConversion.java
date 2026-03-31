// Write a program to find the distance in yards and miles for the distance provided by the user in feet
// Hint => 1 mile = 1760 yards and 1 yard is 3 feet
// I/P => distanceInFeet
// O/P => The distance in yards is ___ while the distance in miles is ___

import java.util.Scanner;

public class DistanceConversion {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the distance in feet: ");
    double dInFeet = scanner.nextDouble();

    double dInYards = dInFeet / 3;
    double dInMiles = dInYards / 1760;

    System.out
        .println("The distance in yards is " + dInYards + " while the distance in miles is " + dInMiles);

    scanner.close();
  }
}