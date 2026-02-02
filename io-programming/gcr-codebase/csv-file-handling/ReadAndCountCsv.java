import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountCsv {
  public static void main(String[] args) {
    String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students.csv";
    int count = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean isHeader = true;

      while ((line = reader.readLine()) != null) {
        if (isHeader) {
          isHeader = false;
          continue;
        }
        if (!line.trim().isEmpty()) {
          count++;
        }
      }

      System.out.println("Records (excluding header): " + count);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
