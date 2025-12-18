// Write a program that takes the base and height to find area of a triangle in square inches and square centimeters 
// Hint => Area of a Triangle is ½ * base * height
// I/P => base, height
// O/P => Your Height in cm is ___ while in feet is ___ and inches is ___

import java.util.Scanner;

public class AreaOfTriangle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the base of the triangle in inches: ");
    double base = sc.nextDouble();
    System.out.print("Enter the height of the triangle in inches: ");
    double height = sc.nextDouble();
    double areaInSquareInches = 0.5 * base * height;

    float inchesToCm = 2.54f;
    double baseInCm = base * inchesToCm;
    double heightInCm = height * inchesToCm;
    double areaInSquareCm = 0.5 * baseInCm * heightInCm;
    System.out.printf("The area of the triangle is %.2f square inches and %.2f square centimeters.%n",
        areaInSquareInches, areaInSquareCm);
    sc.close();

  }

}
