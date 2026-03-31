/*
 * Create a program to find the maximum number of handshakes among students.
 * Get integer input for the numberOfStudents variable.
 * Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of possible handshakes.
 * Write a method to use the combination formulae to calculate the number of handshakes
 * Display the number of possible handshakes.
 */

import java.util.Scanner;

public class MaximumHandshakes {

  public static long calculateHandshakes(int numberOfStudents) {
    return (long) numberOfStudents * (numberOfStudents - 1) / 2;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of students: ");
    int numberOfStudents = scanner.nextInt();

    long handshakes = calculateHandshakes(numberOfStudents);

    System.out.println("The maximum number of handshakes among " + numberOfStudents +
        " students is: " + handshakes);

    scanner.close();
  }
}
