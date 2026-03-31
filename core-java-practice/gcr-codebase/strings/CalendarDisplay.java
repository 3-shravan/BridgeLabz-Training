import java.util.Scanner;

public class CalendarDisplay {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter month (1-12): ");
    int month = sc.nextInt();

    System.out.print("Enter year: ");
    int year = sc.nextInt();

    // String monthName = getMonthName(month);
    // int daysInMonth = getDaysInMonth(month, year);
    // int firstDay = getFirstDayOfMonth(month, year);

    sc.close();
  }

}
