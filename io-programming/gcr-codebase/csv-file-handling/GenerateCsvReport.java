import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GenerateCsvReport {
  static class Employee {
    int id;
    String name;
    String dept;
    int salary;

    Employee(int id, String name, String dept, int salary) {
      this.id = id;
      this.name = name;
      this.dept = dept;
      this.salary = salary;
    }
  }

  public static void main(String[] args) {
    List<Employee> employees = Arrays.asList(new Employee(1, "Asha", "HR", 45000), new Employee(2, "Ravi", "IT", 52000),
        new Employee(3, "Meera", "Finance", 48000), new Employee(4, "Arun", "Sales", 43000),
        new Employee(5, "Neha", "Support", 40000));

    String output = "io-programming\\gcr-codebase\\csv-file-handling\\csv-files\\employee_report.csv";

    try (FileWriter writer = new FileWriter(output)) {
      writer.write("Employee ID,Name,Department,Salary\n");
      for (Employee e : employees) {
        writer.write(e.id + "," + e.name + "," + e.dept + "," + e.salary + "\n");
      }
      System.out.println("Report created: " + output);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
