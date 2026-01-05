class Employee {
  public int employeeId;
  protected String department;
  private double salary;

  public Employee(int employeeId, String department, double salary) {
    this.employeeId = employeeId;
    this.department = department;
    this.salary = salary;
  }

  public double getSalary(double salary) {
    this.salary = salary;
    return this.salary;
  }

}

class Manager extends Employee {

  Manager(int employeeId, String department, double salary) {
    super(employeeId, department, salary);
  }

  public static void main(String[] args) {
    Manager manager = new Manager(101, "Sales", 75000);
    System.out.println("Employee ID: " + manager.employeeId); // Accessible
    System.out.println("Department: " + manager.department); // Accessible
    // System.out.println("Salary: " + manager.salary); // Not Accessible
    System.out.println("Salary: " + manager.getSalary(80000)); // Accessible via method
  }
}