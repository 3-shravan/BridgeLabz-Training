import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateSalaryCsv {
  public static void main(String[] args) {
    String inputPath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\employees.csv";
    String outputPath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\employees_updated.csv";

    try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        FileWriter writer = new FileWriter(outputPath)) {

      String line;
      boolean isHeader = true;

      while ((line = reader.readLine()) != null) {
        if (isHeader) {
          writer.write(line + "\n");
          isHeader = false;
          continue;
        }

        String[] parts = line.split(",");
        if (parts.length == 4) {
          String dept = parts[2].trim();
          if (dept.equalsIgnoreCase("IT")) {
            double salary = Double.parseDouble(parts[3].trim());
            salary = salary * 1.10;
            parts[3] = String.valueOf((int) salary);
          }
          writer.write(String.join(",", parts) + "\n");
        }
      }

      System.out.println("Updated file saved: " + outputPath);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
