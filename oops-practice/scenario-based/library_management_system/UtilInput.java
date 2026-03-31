package scenario_based.library_management_system;

import java.util.Scanner;

public class UtilInput {
  private final Scanner sc;

  public UtilInput(Scanner sc) {
    this.sc = sc;
  }

  public String readNonEmptyString(String prompt) {
    while (true) {
      System.out.print(prompt);
      String s = sc.nextLine();
      if (s != null) {
        s = s.trim();
      }
      if (s != null && !s.isEmpty()) {
        return s;
      }
      System.out.println("Input cannot be empty.");
    }
  }

  public int readInt(String prompt) {
    while (true) {
      System.out.print(prompt);
      String s = sc.nextLine().trim();
      try {
        return Integer.parseInt(s);
      } catch (NumberFormatException e) {
        System.out.println("Enter a valid integer.");
      }
    }
  }

  public LocalDateInput readDate(String prompt) {
    return new LocalDateInput(readNonEmptyString(prompt));
  }

  public static class LocalDateInput {
    private final String raw;

    public LocalDateInput(String raw) {
      this.raw = raw;
    }

    public java.time.LocalDate toLocalDate() {
      return java.time.LocalDate.parse(raw);
    }
  }
}
