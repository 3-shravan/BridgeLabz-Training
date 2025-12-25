/*
 * Write a program to calculate various trigonometric functions using Math class given an angle in degrees
 * Method to calculate various trigonometric functions, Firstly convert to radians and then use Math function to find sine, cosine and tangent.
 * public double[] calculateTrigonometricFunctions(double angle)
 */

import java.util.Scanner;

public class TrigonometricFunctions {

  public double[] calculateTrigonometricFunctions(double angle) {
    // Convert angle from degrees to radians
    double radians = Math.toRadians(angle);

    // Calculate sine, cosine, and tangent
    double sine = Math.sin(radians);
    double cosine = Math.cos(radians);
    double tangent = Math.tan(radians);

    return new double[] { sine, cosine, tangent };
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter an angle in degrees: ");
    double angle = scanner.nextDouble();

    TrigonometricFunctions trig = new TrigonometricFunctions();
    double[] result = trig.calculateTrigonometricFunctions(angle);

    System.out.println("Angle: " + angle + " degrees");
    System.out.println("Sine: " + result[0]);
    System.out.println("Cosine: " + result[1]);
    System.out.println("Tangent: " + result[2]);

    scanner.close();
  }
}
