import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCsv {
  public static void main(String[] args) {
    String file1 = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students1.csv";
    String file2 = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students2.csv";
    String output = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students_merged.csv";

    Map<String, String> infoMap = new HashMap<>();

    try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
      String line;
      boolean isHeader = true;
      while ((line = reader1.readLine()) != null) {
        if (isHeader) {
          isHeader = false;
          continue;
        }
        String[] parts = line.split(",");
        if (parts.length == 3) {
          String id = parts[0].trim();
          String name = parts[1].trim();
          String age = parts[2].trim();
          infoMap.put(id, name + "," + age);
        }
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
      return;
    }

    try (BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        FileWriter writer = new FileWriter(output)) {

      writer.write("ID,Name,Age,Marks,Grade\n");

      String line;
      boolean isHeader = true;
      while ((line = reader2.readLine()) != null) {
        if (isHeader) {
          isHeader = false;
          continue;
        }
        String[] parts = line.split(",");
        if (parts.length == 3) {
          String id = parts[0].trim();
          String marks = parts[1].trim();
          String grade = parts[2].trim();

          String info = infoMap.get(id);
          if (info != null) {
            writer.write(id + "," + info + "," + marks + "," + grade + "\n");
          }
        }
      }

      System.out.println("Merged file created: " + output);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
