// Write a program that takes your height in centimeters and converts it into feet and inches
// Hint => 1 foot = 12 inches and 1 inch = 2.54 cm
// I/P => height
// O/P => Your Height in cm is ___ while in feet is ___ and inches is ___

import java.util.Scanner;

public class HeightConversion {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your height in centimeters: ");
    double heightInCm = sc.nextDouble();

    double totalInches = heightInCm / 2.54;
    int feet = (int) (totalInches / 12);
    double inches = totalInches - (feet * 12);

    System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f%n", heightInCm, feet, inches);            
    sc.close();
  }
}
