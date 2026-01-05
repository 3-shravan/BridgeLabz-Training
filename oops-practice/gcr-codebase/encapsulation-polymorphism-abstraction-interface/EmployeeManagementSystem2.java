/// Interface for Department
interface Department {
  void assignDepartment(String departmentName);

  String getDepartmentDetails();
}

// Abstract class
abstract class Employee implements Department {

  private final int employeeId;
  private String name;
  protected double baseSalary;
  private String department;

  public Employee(int employeeId, String name, double baseSalary) {
    this.employeeId = employeeId;
    this.name = name;
    this.baseSalary = baseSalary;
    this.department = "Not Assigned";
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public String getName() {
    return name;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public abstract double calculateSalary();

  public void displayDetails() {
    System.out.println("Employee ID: " + employeeId);
    System.out.println("Name: " + name);
    System.out.println("Base Salary: " + baseSalary);
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  // interface methods
  @Override
  public void assignDepartment(String departmentName) {
    this.department = departmentName;
  }

  @Override
  public String getDepartmentDetails() {
    return "Department: " + department;
  }
}

// Full-time Employee sub-class
class FullTimeEmployee extends Employee {

  FullTimeEmployee(int employeeId, String name, double baseSalary) {
    super(employeeId, name, baseSalary);
  }

  @Override
  public double calculateSalary() {
    return getBaseSalary();
  }
}

// Part-time Employee sub-class
class PartTimeEmployee extends Employee {
  private final double HOUR_RATE = 20.0;
  private int hoursWorked;

  PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked) {
    super(employeeId, name, baseSalary);
    this.hoursWorked = hoursWorked;
  }

  public int getHoursWorked() {
    return hoursWorked;
  }

  public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double calculateSalary() {
    return HOUR_RATE * hoursWorked;
  }

}

// Main class
public class EmployeeManagementSystem2 {

  public static void main(String[] args) {
    Employee emp1 = new FullTimeEmployee(1, "Alice", 50000);
    emp1.assignDepartment("Engineering");
    emp1.displayDetails();
    System.out.println(emp1.getDepartmentDetails());
    System.out.println("Calculated Salary: " + emp1.calculateSalary());
    System.out.println();

    Employee emp2 = new PartTimeEmployee(2, "Bob", 0, 120);
    emp2.assignDepartment("Marketing");
    emp2.displayDetails();
    System.out.println(emp2.getDepartmentDetails());
    System.out.println("Calculated Salary: " + emp2.calculateSalary());
    System.out.println();

  }
}