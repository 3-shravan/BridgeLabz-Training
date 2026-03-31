// Write a program to take 2 numbers and print their quotient and reminder
// Hint => Use division operator (/) for quotient and moduli operator (%) for reminder
// I/P => number1, number2
// O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___

import java.util.Scanner;

public class QuotientAndReminder {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter dividend: ");
    int dividend = sc.nextInt();
    System.out.print("Enter divisor: ");
    int divisor = sc.nextInt();

    int quotient = dividend / divisor;
    int remainder = dividend % divisor;
    System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + dividend
        + " and " + divisor);

    sc.close();
  }
}