// Problem 2: Date Arithmetic
// Create a program that:
// - Takes a date input and adds 7 days, 1 month, and 2 years to it.
// - Then subtracts 3 weeks from the result.
// Hint: Use LocalDate.plusDays(), plusMonths(), plusYears(), and minusWeeks() methods.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a date (yyyy-MM-dd): ");
    String dateInput = scanner.nextLine();

    LocalDate date = LocalDate.parse(dateInput, FORMATTER);
    System.out.println("Original Date: " + date);

    LocalDate dateAfterAddition = date.plusDays(7).plusMonths(1).plusYears(2);
    System.out.println("After adding 7 days, 1 month, and 2 years: " + dateAfterAddition);

    LocalDate dateAfterSubtraction = dateAfterAddition.minusWeeks(3);
    System.out.println("After subtracting 3 weeks: " + dateAfterSubtraction);

    scanner.close();
  }
}
