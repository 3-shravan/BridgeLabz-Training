public class Student {
  private static String universityName = "GLA University";
  private static int totalStudents = 0;

  private final int rollNumber;
  private String name;
  private char grade;

  Student(int rollNumber, String name, char grade) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.grade = grade;
    totalStudents++;
  }

  static void displayTotalStudents() {
    System.out.println("Total students in " + universityName + ": " + totalStudents);
  }

  char updateGrade(Object student) {
    if (student instanceof Student) {
      Student s = (Student) student;
      this.grade = s.grade;
      return this.grade;
    } else {
      System.out.println("Invalid student object.");
      return this.grade;
    }
  }

  public void showStudentDetails(Object student) {
    if (student instanceof Student) {
      Student s = (Student) student;
      System.out.println("University: " + universityName);
      System.out.println("Roll Number: " + s.rollNumber);
      System.out.println("Name: " + s.name);
      System.out.println("Grade: " + s.grade);
    } else {
      System.out.println("Invalid student object.");
    }
  }

  public static void main(String[] args) {
    Student student1 = new Student(1, "Alice", 'A');
    Student student2 = new Student(2, "Bob", 'B');

    // Display total students
    Student.displayTotalStudents();

    // Update grade for student1
    student1.updateGrade(student1);

    // Show student details
    student1.showStudentDetails(student1);
    System.out.println();
    student2.showStudentDetails(student2);
  }
}
