import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    RegistrationService service = new Services();

    // Optional starter data
    service.addCourse(new Course("C101", "Java Basics", 3));
    service.addCourse(new Course("C102", "OOP in Java", 4));
    service.addCourse(new Course("C103", "DSA", 4));

    Scanner scanner = new Scanner(System.in);

    boolean running = true;
    while (running) {
      printMenu();
      int choice = readInt(scanner, "Enter choice: ");

      try {
        switch (choice) {
          case 1:
            handleAddCourse(scanner, service);
            break;
          case 2:
            handleRegisterStudent(scanner, service);
            break;
          case 3:
            handleEnroll(scanner, service);
            break;
          case 4:
            handleDrop(scanner, service);
            break;
          case 5:
            handleAssignGrade(scanner, service);
            break;
          case 6:
            handleViewEnrolled(scanner, service);
            break;
          case 7:
            handleViewGrades(scanner, service);
            break;
          case 8:
            handleViewCourses(service);
            break;
          case 9:
            handleViewStudents(service);
            break;
          case 0:
            running = false;
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid choice. Try again.");
        }
      } catch (CourseLimitExceededException e) {
        System.out.println("Operation failed: " + e.getMessage());
      } catch (IllegalArgumentException | IllegalStateException e) {
        System.out.println("Error: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
      }

      System.out.println();
    }

    scanner.close();
  }

  private static void printMenu() {
    System.out.println("==== Student Course Registration System ====");
    System.out.println("1. Add Course");
    System.out.println("2. Register Student");
    System.out.println("3. Enroll Student in Course");
    System.out.println("4. Drop Course");
    System.out.println("5. Assign Grade");
    System.out.println("6. View Enrolled Courses");
    System.out.println("7. View Grades");
    System.out.println("8. View All Courses");
    System.out.println("9. View All Students");
    System.out.println("0. Exit");
  }

  private static void handleAddCourse(Scanner scanner, RegistrationService service) {
    String courseId = readNonEmpty(scanner, "Course ID: ");
    String courseName = readNonEmpty(scanner, "Course Name: ");
    int credits = readInt(scanner, "Credits: ");
    service.addCourse(new Course(courseId, courseName, credits));
    System.out.println("Course added.");
  }

  private static void handleRegisterStudent(Scanner scanner, RegistrationService service) {
    String studentId = readNonEmpty(scanner, "Student ID: ");
    String name = readNonEmpty(scanner, "Name: ");
    int maxCourses = readInt(scanner, "Max courses allowed: ");
    service.registerStudent(new Student(studentId, name, maxCourses));
    System.out.println("Student registered.");
  }

  private static void handleEnroll(Scanner scanner, RegistrationService service)
      throws CourseLimitExceededException {
    String studentId = readNonEmpty(scanner, "Student ID: ");
    String courseId = readNonEmpty(scanner, "Course ID: ");
    service.enrollStudentInCourse(studentId, courseId);
    System.out.println("Enrollment successful.");
  }

  private static void handleDrop(Scanner scanner, RegistrationService service) {
    String studentId = readNonEmpty(scanner, "Student ID: ");
    String courseId = readNonEmpty(scanner, "Course ID: ");
    service.dropStudentFromCourse(studentId, courseId);
    System.out.println("Course dropped (if enrolled).");
  }

  private static void handleAssignGrade(Scanner scanner, RegistrationService service) {
    String studentId = readNonEmpty(scanner, "Student ID: ");
    String courseId = readNonEmpty(scanner, "Course ID: ");
    double grade = readDouble(scanner, "Grade (0-100): ");
    service.assignGrade(studentId, courseId, grade);
    System.out.println("Grade assigned.");
  }

  private static void handleViewEnrolled(Scanner scanner, RegistrationService service) {
    String studentId = readNonEmpty(scanner, "Student ID: ");
    List<Course> enrolled = service.getEnrolledCourses(studentId);
    if (enrolled.isEmpty()) {
      System.out.println("No courses enrolled.");
      return;
    }
    System.out.println("Enrolled Courses:");
    for (Course c : enrolled) {
      System.out.println("- " + c);
    }
  }

  private static void handleViewGrades(Scanner scanner, RegistrationService service) {
    String studentId = readNonEmpty(scanner, "Student ID: ");
    Map<String, Double> grades = service.getGrades(studentId);
    if (grades.isEmpty()) {
      System.out.println("No grades available.");
      return;
    }
    System.out.println("Grades:");
    for (Map.Entry<String, Double> entry : grades.entrySet()) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
  }

  private static void handleViewCourses(RegistrationService service) {
    List<Course> courses = service.getAllCourses();
    if (courses.isEmpty()) {
      System.out.println("No courses available.");
      return;
    }
    System.out.println("Course Catalog:");
    for (Course c : courses) {
      System.out.println("- " + c);
    }
  }

  private static void handleViewStudents(RegistrationService service) {
    List<Student> students = service.getAllStudents();
    if (students.isEmpty()) {
      System.out.println("No students registered.");
      return;
    }
    System.out.println("Registered Students:");
    for (Student s : students) {
      System.out.println("- " + s.getId() + " : " + s.getName() + " (max " + s.getMaxCourses() + ")");
    }
  }

  private static String readNonEmpty(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      if (value != null) {
        value = value.trim();
      }
      if (value != null && !value.isBlank()) {
        return value;
      }
      System.out.println("Input cannot be empty. Try again.");
    }
  }

  private static int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      try {
        return Integer.parseInt(value.trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
  }

  private static double readDouble(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      try {
        return Double.parseDouble(value.trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid decimal number.");
      }
    }
  }
}