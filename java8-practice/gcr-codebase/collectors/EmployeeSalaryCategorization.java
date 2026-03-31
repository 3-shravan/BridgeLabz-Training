import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
  private String name;
  private double salary;
  private String department;

  public Employee(String name, double salary, String department) {
    this.name = name;
    this.salary = salary;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public String getDepartment() {
    return department;
  }
}

public class EmployeeSalaryCategorization {
  public static void main(String[] args) {
    List<Employee> employees = Arrays.asList(
        new Employee("Alice", 95000, "Engineering"),
        new Employee("Bob", 120000, "Engineering"),
        new Employee("Charlie", 70000, "HR"),
        new Employee("David", 110000, "HR"),
        new Employee("Eve", 130000, "Finance"));

    employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
        .forEach((department, avgSalary) -> System.out.println(department + ": " + avgSalary));
  }
}
