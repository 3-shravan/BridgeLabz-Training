
import java.util.Scanner;

class Student {
  String name;
  int rollNumber;
  int age;
  char grade;
  Student next;

  Student(String name, int rollNumber, int age, char grade) {
    this.name = name;
    this.rollNumber = rollNumber;
    this.age = age;
    this.grade = grade;
    this.next = null;
  }
}

class StudentList {
  private Student head;

  void addBeginning(int rollNumber, String name, int age, char grade) {
    Student newStudent = new Student(name, rollNumber, age, grade);
    newStudent.next = head;
    head = newStudent;
  }

  void addEnd(int rollNumber, String name, int age, char grade) {
    Student newStudent = new Student(name, rollNumber, age, grade);
    if (head == null) {
      head = newStudent;
      return;
    }
    Student current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newStudent;
  }

  void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
    if (position < 0) {
      throw new InvalidPositionException("Position cannot be nagative");
    }
    if (position == 0) {
      addBeginning(rollNumber, name, age, grade);
      return;
    }
    if (head == null) {
      throw new EmptyListException("cannot insert at this position in empty list");
    }
    Student newStudent = new Student(name, rollNumber, age, grade);
    Student current = head;
    for (int i = 0; i < position - 1; i++) {
      if (current.next == null) {
        throw new InvalidPositionException("Position out of bounds");
      }
      current = current.next;
    }
    newStudent.next = current.next;
    current.next = newStudent;
  }

  void deleteByRollNumber(int rollNumber) {
    if (head == null) {
      throw new EmptyListException("List is empty");
    }
    if (head.rollNumber == rollNumber) {
      head = head.next;
      return;
    }
    Student current = head;
    while (current.next != null && current.next.rollNumber != rollNumber) {
      current = current.next;
    }
    if (current.next == null) {
      throw new NotFoundException("Student with roll number " + rollNumber + " not found");
    }
    current.next = current.next.next;
  }

  Student search(int rollNumber) {
    if (head == null) {
      throw new EmptyListException("Student list is empty");
    }
    Student current = head;
    while (current != null) {
      if (current.rollNumber == rollNumber) {
        return current;
      }
      current = current.next;
    }
    throw new NotFoundException("Student with this roll number not found");
  }

  void updateGrade(int roll, char newGrade) {
    Student student = search(roll);
    student.grade = newGrade;
  }

  void displayAll() {
    if (head == null) {
      System.out.println("No students in the list.");
      return;
    }
    Student current = head;
    while (current != null) {
      System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name +
          ", Age: " + current.age + ", Grade: " + current.grade);
      current = current.next;
    }
  }

}

public class StudentManagementSystem {

  private static void printMenu() {
    System.out.println("\n==== Student Management System ====");
    System.out.println("1. Add student (beginning)");
    System.out.println("2. Add student (end)");
    System.out.println("3. Add student (at position)");
    System.out.println("4. Delete student (by roll number)");
    System.out.println("5. Search student (by roll number)");
    System.out.println("6. Update grade (by roll number)");
    System.out.println("7. Display all students");
    System.out.println("0. Exit");
  }

  private static int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid integer.");
      }
    }
  }

  private static String readNonEmptyString(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Input cannot be empty.");
    }
  }

  private static char readGrade(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
        return Character.toUpperCase(input.charAt(0));
      }
      System.out.println("Please enter a single letter grade (e.g., A, B, C).");
    }
  }

  public static void main(String[] args) {
    StudentList studentList = new StudentList();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printMenu();
      int choice = readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            int rollNumber = readInt(scanner, "Enter roll number: ");
            String name = readNonEmptyString(scanner, "Enter name: ");
            int age = readInt(scanner, "Enter age: ");
            char grade = readGrade(scanner, "Enter grade: ");
            studentList.addBeginning(rollNumber, name, age, grade);
            System.out.println("Student added at beginning.");
            break;
          }
          case 2: {
            int rollNumber = readInt(scanner, "Enter roll number: ");
            String name = readNonEmptyString(scanner, "Enter name: ");
            int age = readInt(scanner, "Enter age: ");
            char grade = readGrade(scanner, "Enter grade: ");
            studentList.addEnd(rollNumber, name, age, grade);
            System.out.println("Student added at end.");
            break;
          }
          case 3: {
            int position = readInt(scanner, "Enter position (0-based): ");
            int rollNumber = readInt(scanner, "Enter roll number: ");
            String name = readNonEmptyString(scanner, "Enter name: ");
            int age = readInt(scanner, "Enter age: ");
            char grade = readGrade(scanner, "Enter grade: ");
            studentList.addAtPosition(position, rollNumber, name, age, grade);
            System.out.println("Student added at position " + position + ".");
            break;
          }
          case 4: {
            int rollNumber = readInt(scanner, "Enter roll number to delete: ");
            studentList.deleteByRollNumber(rollNumber);
            System.out.println("Student deleted.");
            break;
          }
          case 5: {
            int rollNumber = readInt(scanner, "Enter roll number to search: ");
            Student student = studentList.search(rollNumber);
            System.out.println("Student found: Roll Number: " + student.rollNumber + ", Name: " + student.name +
                ", Age: " + student.age + ", Grade: " + student.grade);
            break;
          }
          case 6: {
            int rollNumber = readInt(scanner, "Enter roll number to update: ");
            char newGrade = readGrade(scanner, "Enter new grade: ");
            studentList.updateGrade(rollNumber, newGrade);
            System.out.println("Grade updated.");
            break;
          }
          case 7: {
            studentList.displayAll();
            break;
          }
          case 0: {
            System.out.println("Exiting...");
            scanner.close();
            return;
          }
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (RuntimeException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }

}
