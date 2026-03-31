package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
  private String name;
  private String department;

  Employee(String name, String department) {
    this.name = name;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public String toString() {
    return "Employee [name=" + name + ", department=" + department + "]";
  }
  
}

public class GroupByDepartment {
  public static void main(String[] args) {
    List<Employee> employees = List.of(new Employee("Alice", "HR"), new Employee("Bob", "Engineering"),
        new Employee("Charlie", "HR"), new Employee("David", "Engineering"), new Employee("Eve", "Marketing")

    );
    Map<String, List<String>> departmentMap = new HashMap<>();
    for (Employee emp : employees) {
      departmentMap.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp.getName());
    }
    System.out.println(departmentMap);
  }

}
