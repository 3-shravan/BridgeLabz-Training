// Write a program to find the side of the square whose parameter you read from the user 
// Hint => Perimeter of the Square is 4 times the side
// I/P => perimeter
// O/P => The length of the side is ___ whose perimeter is ____

import java.util.Scanner;

public class PerimeterOfTriangle {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the perimeter of the triangle: ");
    double perimeter = s.nextDouble();
    double side = perimeter / 3;

    System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    s.close();
  }

}
