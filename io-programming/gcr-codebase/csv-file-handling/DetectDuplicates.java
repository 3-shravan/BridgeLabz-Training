import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
  public static void main(String[] args) {
    String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students1.csv";

    Set<String> seen = new HashSet<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean isHeader = true;

      while ((line = reader.readLine()) != null) {
        if (isHeader) {
          isHeader = false;
          continue;
        }

        String[] parts = line.split(",");
        if (parts.length > 0) {
          String id = parts[0].trim();
          if (seen.contains(id)) {
            System.out.println("Duplicate record: " + line);
          } else {
            seen.add(id);
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
