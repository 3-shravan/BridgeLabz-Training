import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortBySalary {
  static class Employee {
    String id;
    String name;
    String dept;
    int salary;

    Employee(String id, String name, String dept, int salary) {
      this.id = id;
      this.name = name;
      this.dept = dept;
      this.salary = salary;
    }
  }

  public static void main(String[] args) {
    String filePath = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\employees.csv";
    List<Employee> employees = new ArrayList<>();

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
          int salary = Integer.parseInt(parts[3].trim());
          employees.add(new Employee(parts[0].trim(), parts[1].trim(), parts[2].trim(), salary));
        }
      }

      employees.sort(Comparator.comparingInt((Employee e) -> e.salary).reversed());

      int limit = Math.min(5, employees.size());
      for (int i = 0; i < limit; i++) {
        Employee e = employees.get(i);
        System.out.println("Name: " + e.name + ", Dept: " + e.dept + ", Salary: " + e.salary);
      }
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
