import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {
  public static void main(String[] args) {
    String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\employees.csv";

    try (Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

      System.out.print("Enter employee name: ");
      String searchName = scanner.nextLine().trim();

      String line;
      boolean isHeader = true;
      boolean found = false;

      while ((line = reader.readLine()) != null) {
        if (isHeader) {
          isHeader = false;
          continue;
        }

        String[] parts = line.split(",");
        if (parts.length == 4) {
          String name = parts[1].trim();
          if (name.equalsIgnoreCase(searchName)) {
            System.out.println("Department: " + parts[2]);
            System.out.println("Salary: " + parts[3]);
            found = true;
            break;
          }
        }
      }

      if (!found) {
        System.out.println("Employee not found.");
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
