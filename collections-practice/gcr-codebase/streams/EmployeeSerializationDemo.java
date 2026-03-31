import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class EmployeeSerializationDemo {

  // Employee class
  static class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
      this.id = id;
      this.name = name;
      this.department = department;
      this.salary = salary;
    }

    public String toString() {
      return "Employee{id=" + id + ", name='" + name + '\'' + ", department='" + department + '\'' + ", salary="
          + salary + '}';
    }
  }

  public static void main(String[] args) {

    String fileName = "collections-practice\\gcr-codebase\\streams\\employees.dat";

    ArrayList<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee(1, "Alice", "IT", 60000));
    employeeList.add(new Employee(2, "Bob", "HR", 45000));
    employeeList.add(new Employee(3, "Charlie", "Finance", 70000));

    // Serialize
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

      oos.writeObject(employeeList);
      System.out.println("✅ Employees saved successfully!");

    } catch (IOException e) {
      e.printStackTrace();
    }

    // Deserialize
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

      ArrayList<Employee> employees = (ArrayList<Employee>) ois.readObject();

      System.out.println("\n Employee List:");
      for (Employee e : employees) {
        System.out.println(e);
      }

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
