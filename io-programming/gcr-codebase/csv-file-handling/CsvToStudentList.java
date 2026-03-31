import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToStudentList {
  static class Student {
    int id;
    String name;
    int age;
    int marks;

    Student(int id, String name, int age, int marks) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.marks = marks;
    }

    @Override
    public String toString() {
      return "Student{id=" + id + ", name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }
  }

  public static void main(String[] args) {
    String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\students.csv";
    List<Student> students = new ArrayList<>();

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
          int id = Integer.parseInt(parts[0].trim());
          String name = parts[1].trim();
          int age = Integer.parseInt(parts[2].trim());
          int marks = Integer.parseInt(parts[3].trim());
          students.add(new Student(id, name, age, marks));
        }
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

    for (Student s : students) {
      System.out.println(s);
    }
  }
}
