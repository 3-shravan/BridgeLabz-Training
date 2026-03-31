// Write a program to check if the first, second, or third number is the largest of the three.
// I/P => number1, number2, number3
// O/P => 
// Is the first number the largest? ____
// Is the second number the largest? ___
// Is the third number the largest? ___

import java.util.Scanner;

public class LargestOfThreeNo {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first number:");
    int number1 = sc.nextInt();
    System.out.println("Enter second number:");
    int number2 = sc.nextInt();
    System.out.println("Enter third number:");
    int number3 = sc.nextInt();
    if (number1 >= number2 && number1 >= number3) {
      System.out.println("Is the first number the largest? True");
    } else {
      System.out.println("Is the first number the largest? False");
    }
    if (number2 >= number1 && number2 >= number3) {
      System.out.println("Is the second number the largest? True");
    } else {
      System.out.println("Is the second number the largest? False");
    }
    if (number3 >= number1 && number3 >= number2) {
      System.out.println("Is the third number the largest? True");
    } else {
      System.out.println("Is the third number the largest? False");
    }
    sc.close();
  }
}
