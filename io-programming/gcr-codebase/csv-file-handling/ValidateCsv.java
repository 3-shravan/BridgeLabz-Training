import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCsv {
  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
  private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

  public static void main(String[] args) {
    String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\contacts.csv";

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean isHeader = true;

      while ((line = reader.readLine()) != null) {
        if (isHeader) {
          isHeader = false;
          continue;
        }

        String[] parts = line.split(",");
        if (parts.length == 3) {
          String name = parts[0].trim();
          String email = parts[1].trim();
          String phone = parts[2].trim();

          boolean emailOk = EMAIL_PATTERN.matcher(email).matches();
          boolean phoneOk = PHONE_PATTERN.matcher(phone).matches();

          if (!emailOk || !phoneOk) {
            System.out.println("Invalid row: " + line);
            if (!emailOk) {
              System.out.println("  Error: Invalid email for " + name);
            }
            if (!phoneOk) {
              System.out.println("  Error: Phone must be 10 digits for " + name);
            }
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
