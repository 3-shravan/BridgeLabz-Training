// Write a program to find the side of the square whose parameter you read from user 
// Hint => Perimeter of Square is 4 times side
// I/P => perimeter
// O/P => The length of the side is ___ whose perimeter is ____

import java.util.Scanner;

public class SideOfSq {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the perimeter of the square: ");
    int perimeter = sc.nextInt();
    int side = perimeter / 4;
    System.out.printf("The length of the side is %d whose perimeter is %d", side, perimeter);
    sc.close();
  }
}
