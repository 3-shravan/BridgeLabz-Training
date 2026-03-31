// Problem 3: Date Formatting
// Write a program that:
// - Displays the current date in three different formats:
//   - dd/MM/yyyy
//   - yyyy-MM-dd
//   - EEE, MMM dd, yyyy
// Hint: Use DateTimeFormatter with custom patterns for date formatting.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateFormatting {

  private static final DateTimeFormatter FORMAT_1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final DateTimeFormatter FORMAT_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter FORMAT_3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    LocalDate currentDate = LocalDate.now();
    displayDates(currentDate, new DateTimeFormatter[] { FORMAT_1, FORMAT_2, FORMAT_3 });

    scanner.close();
  }

  private static void displayDates(LocalDate date, DateTimeFormatter[] formats) {
    for (DateTimeFormatter format : formats) {
      System.out.println(date.format(format));
    }
  }
}
