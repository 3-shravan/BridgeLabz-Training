// Problem: Quadratic Equation Roots Finder
// Write a program Quadratic to find the roots of the equation ax² + bx + c
// Use Math functions Math.pow() and Math.sqrt()
// Hint:
// - Take a, b, and c as input values to find the roots of x.
// - The roots are computed using the following formulae:
//   delta = b² - 4*a*c
//   If delta is positive find the two roots using formulae:
//     root1 = (-b + √delta) / (2*a)
//     root2 = (-b - √delta) / (2*a)
//   If delta is zero then there is only one root:
//     root = -b / (2*a)
//   If delta is negative return empty array or nothing
// - Write a Method to find the roots of a quadratic equation and return the roots

import java.util.Scanner;

public class Quadratic {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Quadratic Equation Roots Finder");
    System.out.println("Find roots of: ax² + bx + c");

    System.out.print("Enter coefficient a: ");
    double a = scanner.nextDouble();

    System.out.print("Enter coefficient b: ");
    double b = scanner.nextDouble();

    System.out.print("Enter coefficient c: ");
    double c = scanner.nextDouble();

    if (a == 0) {
      System.out.println(" Coefficient 'a' cannot be zero for a quadratic equation.");
      scanner.close();
      return;
    }

    double[] roots = findRoots(a, b, c);

    if (roots == null || roots.length == 0) {
      System.out.println("\nNo real roots exist (Discriminant is negative)");
    } else if (roots.length == 1) {
      System.out.println("\nOne real root exists:");
      System.out.println("Root: " + roots[0]);
    } else {
      System.out.println("\nTwo real roots exist:");
      System.out.println("Root 1: " + roots[0]);
      System.out.println("Root 2: " + roots[1]);
    }

    scanner.close();
  }

  public static double[] findRoots(double a, double b, double c) {
    double delta = Math.pow(b, 2) - (4 * a * c);

    if (delta < 0) {
      return new double[0];
    } else if (delta == 0) {
      double root = -b / (2 * a);
      return new double[] { root };
    } else {
      double sqrtDelta = Math.sqrt(delta);
      double root1 = (-b + sqrtDelta) / (2 * a);
      double root2 = (-b - sqrtDelta) / (2 * a);
      return new double[] { root1, root2 };
    }
  }
}
