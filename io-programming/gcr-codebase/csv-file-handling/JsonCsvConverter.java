import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonCsvConverter {
  public static void main(String[] args) throws IOException {
    String jsonPath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students.json";
    String csvPath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students_from_json.csv";
    String jsonOutPath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students_from_csv.json";

    jsonToCsv(jsonPath, csvPath);
    csvToJson(csvPath, jsonOutPath);

    System.out.println("Created: " + csvPath);
    System.out.println("Created: " + jsonOutPath);
  }

  static void jsonToCsv(String jsonFile, String csvFile) throws IOException {
    String json = Files.readString(Path.of(jsonFile)).trim();
    json = json.substring(1, json.length() - 1).trim(); // remove [ ]

    List<String[]> rows = new ArrayList<>();
    if (!json.isEmpty()) {
      String[] objects = json.split("\\},\\s*\\{");
      for (String obj : objects) {
        obj = obj.replace("{", "").replace("}", "").trim();
        String[] parts = obj.split(",");

        String id = "";
        String name = "";
        String age = "";
        String marks = "";

        for (String part : parts) {
          String[] kv = part.split(":", 2);
          String key = kv[0].trim().replace("\"", "");
          String value = kv[1].trim().replace("\"", "");

          if (key.equals("id"))
            id = value;
          if (key.equals("name"))
            name = value;
          if (key.equals("age"))
            age = value;
          if (key.equals("marks"))
            marks = value;
        }
        rows.add(new String[] { id, name, age, marks });
      }
    }

    StringBuilder csv = new StringBuilder();
    csv.append("id,name,age,marks\n");
    for (String[] row : rows) {
      csv.append(String.join(",", row)).append("\n");
    }

    Files.writeString(Path.of(csvFile), csv.toString());
  }

  static void csvToJson(String csvFile, String jsonFile) throws IOException {
    List<String> lines = Files.readAllLines(Path.of(csvFile));
    if (lines.isEmpty())
      return;

    String[] headers = lines.get(0).split(",");
    StringBuilder json = new StringBuilder();
    json.append("[\n");

    for (int i = 1; i < lines.size(); i++) {
      String[] values = lines.get(i).split(",");
      json.append("  {");
      for (int j = 0; j < headers.length; j++) {
        String key = headers[j].trim();
        String val = values[j].trim();

        json.append("\"").append(key).append("\": ");
        if (key.equals("name")) {
          json.append("\"").append(val).append("\"");
        } else {
          json.append(val);
        }

        if (j < headers.length - 1)
          json.append(", ");
      }
      json.append("}");
      if (i < lines.size() - 1)
        json.append(",");
      json.append("\n");
    }

    json.append("]\n");
    Files.writeString(Path.of(jsonFile), json.toString());
  }
}
