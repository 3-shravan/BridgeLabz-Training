package static_methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtil {
  static String formatDate(LocalDate date, String pattern) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return date.format(formatter);
  }
}

public class DateFormat {
  public static void main(String[] args) {

    LocalDate date = LocalDate.now();
    String pattern = "dd-MM-yyyy";
    String formattedDate = DateUtil.formatDate(date, pattern);
    System.out.println("Formatted Date: " + formattedDate);
  }
}