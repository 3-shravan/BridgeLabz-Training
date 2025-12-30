import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class RohansLibraryReminderApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final int FINE_PER_DAY = 5;
    final int NUMBER_OF_BOOKS = 5;
    double totalFine = 0;

    System.out.println("📚 Rohan's Library Reminder App 📚");

    for (int i = 1; i <= NUMBER_OF_BOOKS; i++) {
      System.out.println("\n--- Book " + i + " ---");

      System.out.print("Enter due date (YYYY-MM-DD): ");
      String dueDateStr = scanner.nextLine();
      LocalDate dueDate = LocalDate.parse(dueDateStr);

      System.out.print("Enter return date (YYYY-MM-DD): ");
      String returnDateStr = scanner.nextLine();
      LocalDate returnDate = LocalDate.parse(returnDateStr);

      long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
      double fine = 0;

      if (daysLate > 0) {
        fine = daysLate * FINE_PER_DAY;
        System.out.println("Book returned " + daysLate + " day(s) late!");
        System.out.println("Fine: ₹" + fine);
      } else {
        System.out.println(" Book returned on time or early!");
        System.out.println("Fine: ₹0");
      }

      totalFine += fine;
    }

    System.out.println("Total Fine for all books: ₹" + totalFine);

    scanner.close();
  }
}
