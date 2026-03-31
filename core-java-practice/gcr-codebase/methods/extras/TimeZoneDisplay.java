// Problem 1: Time Zones and ZonedDateTime
// Write a program that displays the current time in different time zones:
// - GMT (Greenwich Mean Time)
// - IST (Indian Standard Time)
// - PST (Pacific Standard Time)
// Hint: Use ZonedDateTime and ZoneId to work with different time zones.

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneDisplay {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Press Enter to view current times for GMT, IST, and PST...");
    scanner.nextLine();

    ZonedDateTime nowGmt = ZonedDateTime.now(ZoneId.of("GMT"));
    printTime("GMT (Greenwich Mean Time)", nowGmt);
    printTime("IST (Indian Standard Time)", nowGmt.withZoneSameInstant(ZoneId.of("Asia/Kolkata")));
    printTime("PST (Pacific Standard Time)", nowGmt.withZoneSameInstant(ZoneId.of("America/Los_Angeles")));

    scanner.close();
  }

  private static void printTime(String label, ZonedDateTime time) {
    System.out.println(label + ": " + time.format(FORMATTER));
  }
}
