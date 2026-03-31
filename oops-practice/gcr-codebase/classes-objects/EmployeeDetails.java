public class EmployeeDetails {
  String name;
  int id;
  int salary;

  public EmployeeDetails(String name, int id, int salary) {
    this.name = name;
    this.id = id;
    this.salary = salary;
  }

  private void displayDetails() {
    System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
  }

  public static void main(String[] args) {
    EmployeeDetails emp1 = new EmployeeDetails("Alice", 101, 50000);
    emp1.displayDetails();
  }
}
