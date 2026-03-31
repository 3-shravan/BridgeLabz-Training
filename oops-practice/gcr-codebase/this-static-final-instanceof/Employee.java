public class Employee {
  private static String companyName = "Solutions";
  private static int totalEmployees = 0;

  private final int id;
  private String name;
  private String designation;

  public Employee(int id, String name, String designation) {
    this.id = id;
    this.name = name;
    this.designation = designation;
    totalEmployees++;
  }

  static void displayTotalEmployees() {
    System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
  }

  public void displayEmployeeDetails(Object obj) {
    if (obj instanceof Employee) {
      Employee emp = (Employee) obj;
      System.out.println("Employee ID: " + emp.id);
      System.out.println("Employee Name: " + emp.name);
      System.out.println("Employee Designation: " + emp.designation);
    } else {
      System.out.println("Provided object is not an Employee.");
    }
  }

  public static void main(String[] args) {
    Employee emp1 = new Employee(1, "Shravan", "Developer");
    Employee emp2 = new Employee(2, "K", "Developer");
    Employee.displayTotalEmployees();
    emp1.displayEmployeeDetails(emp1);
    emp2.displayEmployeeDetails(emp2);
  }
}
