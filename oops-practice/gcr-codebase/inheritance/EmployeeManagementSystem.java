class EmployeeManagementSystem {
  String name;
  int id;
  double salary;

  EmployeeManagementSystem(String name, int id, double salary) {
    this.name = name;
    this.id = id;
    this.salary = salary;
  }

  public void displayDetails() {
    System.out.println("Name: " + name);
    System.out.println("ID: " + id);
    System.out.println("Salary: " + salary);
  }

  public static void main(String[] args) {
    Manager manager = new Manager("Alice", 101, 75000, 10);
    Developer developer = new Developer("Bob", 102, 60000, "Java");
    Intern intern = new Intern("Charlie", 103, 30000, 6);

    System.out.println("Manager Details:");
    manager.displayDetails();
    System.out.println();

    System.out.println("Developer Details:");
    developer.displayDetails();
    System.out.println();

    System.out.println("Intern Details:");
    intern.displayDetails();
  }
}

class Manager extends EmployeeManagementSystem {
  int teamSize;

  Manager(String name, int id, double salary, int teamSize) {
    super(name, id, salary);
    this.teamSize = teamSize;
  }

  @Override
  public void displayDetails() {
    super.displayDetails();
    System.out.println("Team Size: " + teamSize);
  }
}

class Developer extends EmployeeManagementSystem {
  String programmingLanguage;

  Developer(String name, int id, double salary, String programmingLanguage) {
    super(name, id, salary);
    this.programmingLanguage = programmingLanguage;
  }

  @Override
  public void displayDetails() {
    super.displayDetails();
    System.out.println("Programming Language: " + programmingLanguage);
  }
}

class Intern extends EmployeeManagementSystem {
  int duration;

  Intern(String name, int id, double salary, int duration) {
    super(name, id, salary);
    this.duration = duration;
  }

  @Override
  public void displayDetails() {
    super.displayDetails();
    System.out.println("Internship Duration: " + duration + " months");
  }
}
