import java.util.Calendar;
import java.util.Scanner;

public class CalendarDisplay {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter month (1-12): ");
    int month = sc.nextInt();

    System.out.print("Enter year: ");
    int year = sc.nextInt();

    if (!isValidMonth(month)) {
      System.out.println("Invalid month!");
      sc.close();
      return;
    }

    displayCalendar(month, year);
    sc.close();
  }

  static boolean isValidMonth(int month) {
    return month >= 1 && month <= 12;
  }

  static int getDaysInMonth(int month, int year) {
    int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    if (isLeapYear(year) && month == 2) {
      return 29;
    }

    return days[month - 1];
  }

  static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  static int getFirstDayOfMonth(int month, int year) {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month - 1, 1);
    return cal.get(Calendar.DAY_OF_WEEK) - 1;
  }

  static void displayCalendar(int month, int year) {
    String[] monthNames = { "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December" };

    System.out.println("\n" + monthNames[month] + " " + year);
    System.out.println("Sun Mon Tue Wed Thu Fri Sat");

    int firstDay = getFirstDayOfMonth(month, year);
    int daysInMonth = getDaysInMonth(month, year);

    for (int i = 0; i < firstDay; i++) {
      System.out.print("    ");
    }

    for (int day = 1; day <= daysInMonth; day++) {
      System.out.printf("%3d ", day);
      if ((day + firstDay) % 7 == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }
}
