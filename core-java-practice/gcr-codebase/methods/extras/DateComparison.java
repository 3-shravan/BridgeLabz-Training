// Problem 4: Date Comparison
// Write a program that:
// - Takes two date inputs and compares them to check if the first date is before, after,
//   or the same as the second date.
// Hint: Use isBefore(), isAfter(), and isEqual() methods from the LocalDate

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter first date (yyyy-MM-dd): ");
    String firstDateInput = scanner.nextLine();

    System.out.print("Enter second date (yyyy-MM-dd): ");
    String secondDateInput = scanner.nextLine();

    LocalDate date1 = LocalDate.parse(firstDateInput, FORMATTER);
    LocalDate date2 = LocalDate.parse(secondDateInput, FORMATTER);

    compareAndDisplay(date1, date2);

    scanner.close();
  }

  private static void compareAndDisplay(LocalDate date1, LocalDate date2) {
    if (date1.isBefore(date2)) {
      System.out.println(date1 + " is before " + date2);
    } else if (date1.isAfter(date2)) {
      System.out.println(date1 + " is after " + date2);
    } else {
      System.out.println(date1 + " is equal to " + date2);
    }
  }
}
