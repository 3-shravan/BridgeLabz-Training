import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception
class InvalidMarkException extends Exception {
  public InvalidMarkException(String message) {
    super(message);
  }
}

// Student Class
class Student {
  private String name;
  private String[] subjects;
  private int[] marks;

  public Student(String name, String[] subjects, int[] marks)
      throws InvalidMarkException {

    this.name = name;
    this.subjects = subjects;
    this.marks = marks;
    validateMarks();
  }

  // Validate marks
  private void validateMarks() throws InvalidMarkException {
    for (int mark : marks) {
      if (mark < 0 || mark > 100) {
        throw new InvalidMarkException(
            "Marks must be between 0 and 100");
      }
    }
  }

  // Calculate average
  public double calculateAverage() {
    int sum = 0;
    for (int mark : marks) {
      sum += mark;
    }
    return sum / (double) marks.length;
  }

  // Assign grade
  public String assignGrade() {
    double avg = calculateAverage();

    if (avg >= 80)
      return "A";
    else if (avg >= 60)
      return "B";
    else if (avg >= 40)
      return "C";
    else
      return "F";
  }

  // Display report card
  public void displayReport() {
    System.out.println("\n==============================");
    System.out.println("Report Card");
    System.out.println("Student Name : " + name);
    System.out.println("------------------------------");

    for (int i = 0; i < subjects.length; i++) {
      System.out.println(
          String.format("%-10s : %3d", subjects[i], marks[i]));
    }

    System.out.println("------------------------------");
    System.out.println(String.format("Average    : %.2f", calculateAverage()));
    System.out.println("Grade      : " + assignGrade());
    System.out.println("==============================");
  }
}

// Main Class
public class StudentReportGenerator {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    System.out.print("Enter number of students: ");
    int count = sc.nextInt();
    sc.nextLine();

    String[] subjects = { "Math", "Science", "English" };

    for (int i = 1; i <= count; i++) {
      try {
        System.out.print("\nEnter student name: ");
        String name = sc.nextLine();

        int[] marks = new int[subjects.length];
        for (int j = 0; j < subjects.length; j++) {
          System.out.print("Enter marks for " + subjects[j] + ": ");
          marks[j] = sc.nextInt();
        }
        sc.nextLine();

        students.add(new Student(name, subjects, marks));

      } catch (InvalidMarkException e) {
        System.out.println("Error: " + e.getMessage());
        sc.nextLine(); // clear buffer
      }
    }

    // Display all report cards
    for (Student s : students) {
      s.displayReport();
    }

    sc.close();
  }
}
