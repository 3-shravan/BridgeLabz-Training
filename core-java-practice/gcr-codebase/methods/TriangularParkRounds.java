/*
 An athlete runs in a triangular park with sides provided as input by the user in meters.
 If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
 Take user input for 3 sides of a triangle 
 The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
 Write a Method to compute the number of rounds user needs to do to complete 5km run
 */

import java.util.Scanner;

public class TriangularParkRounds {

  public static double calculateRounds(double side1, double side2, double side3) {
    double perimeter = side1 + side2 + side3;
    double distance = 5 * 1000;
    return distance / perimeter;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter side 1 of the triangle (in meters): ");
    double side1 = scanner.nextDouble();

    System.out.print("Enter side 2 of the triangle (in meters): ");
    double side2 = scanner.nextDouble();

    System.out.print("Enter side 3 of the triangle (in meters): ");
    double side3 = scanner.nextDouble();

    double rounds = calculateRounds(side1, side2, side3);

    System.out.println("The athlete needs to complete " + rounds + " rounds to finish a 5 km run.");

    scanner.close();
  }
}
