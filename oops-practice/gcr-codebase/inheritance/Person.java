class Person {
  String name;
  int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  void displayInfo() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
  }

  public static void main(String[] args) {
    Teacher teacher = new Teacher("Alice", 30, "Mathematics");
    Student student = new Student("Bob", 20, "A");
    Staff staff = new Staff("Charlie", 40, "Administration");

    System.out.println("Teacher Info:");
    teacher.displayInfo();
    teacher.displayRole();

    System.out.println("\nStudent Info:");
    student.displayInfo();
    student.displayRole();

    System.out.println("\nStaff Info:");
    staff.displayInfo();
    staff.displayRole();
  }
}

class Teacher extends Person {
  String subject;

  Teacher(String name, int age, String subject) {
    super(name, age);
    this.subject = subject;
  }

  void displayRole() {
    System.out.println("Role: Teacher");
    System.out.println("Subject: " + subject);
  }
}

class Student extends Person {
  String grade;

  Student(String name, int age, String grade) {
    super(name, age);
    this.grade = grade;
  }

  void displayRole() {
    System.out.println("Role: Student");
    System.out.println("Grade: " + grade);
  }
}

class Staff extends Person {
  String department;

  Staff(String name, int age, String department) {
    super(name, age);
    this.department = department;
  }

  void displayRole() {
    System.out.println("Role: Staff");
    System.out.println("Department: " + department);
  }
}
