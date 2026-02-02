import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCsv {
  public static void main(String[] args) {
    String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students.csv";

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      boolean isHeader = true;

      while ((line = reader.readLine()) != null) {
        if (isHeader) {
          isHeader = false;
          continue;
        }

        String[] parts = line.split(",");
        if (parts.length == 4) {
          int marks = Integer.parseInt(parts[3].trim());
          if (marks > 80) {
            System.out.println("ID: " + parts[0]);
            System.out.println("Name: " + parts[1]);
            System.out.println("Age: " + parts[2]);
            System.out.println("Marks: " + parts[3]);
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
