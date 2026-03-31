package online_examination_system;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ExamService service = new ExamService();

    System.out.println("   WELCOME TO ONLINE EXAMINATION SYSTEM");

    while (true) {
      showMenu();
      System.out.print("Please enter your choice: ");
      int choice = sc.nextInt();

      try {
        switch (choice) {

        case 1:
          System.out.println("\n--- CREATE EXAM ---");
          System.out.print("Enter Exam ID: ");
          String examId = sc.next();
          System.out.print("Enter Exam Duration (in minutes): ");
          int duration = sc.nextInt();

          service.createExam(examId, duration);
          System.out.println("✔ Exam created successfully.\n");
          break;

        case 2:
          System.out.println("\n--- ADD QUESTION TO EXAM ---");
          System.out.print("Enter Exam ID: ");
          String qExamId = sc.next();
          System.out.print("Enter Question Text: ");
          String question = sc.next();
          System.out.print("Enter Correct Answer: ");
          String answer = sc.next();
          System.out.print("Is this an Objective question? (true/false): ");
          boolean isObjective = sc.nextBoolean();

          service.addQuestion(qExamId, question, answer, isObjective);
          System.out.println("✔ Question added successfully.\n");
          break;

        case 3:
          System.out.println("\n--- STUDENT ENROLLMENT ---");
          System.out.print("Enter Student ID: ");
          String studentId = sc.next();
          System.out.print("Enter Student Name: ");
          String name = sc.next();

          service.enrollStudent(studentId, name);
          System.out.println("✔ Student enrolled successfully.\n");
          break;

        case 4:
          System.out.println("\n--- START EXAM ---");
          System.out.println("NOTE: Exam timer starts immediately!");
          System.out.print("Enter Student ID: ");
          String startStudentId = sc.next();
          System.out.print("Enter Exam ID: ");
          String startExamId = sc.next();

          service.startExam(startStudentId, startExamId);
          System.out.println("✔ Exam started. All the best!\n");
          break;

        case 5:
          System.out.println("\n--- SUBMIT EXAM ---");
          System.out.print("Enter Student ID: ");
          String submitStudentId = sc.next();
          System.out.print("Enter Exam ID: ");
          String submitExamId = sc.next();

          service.submitExam(submitStudentId, submitExamId);
          System.out.println("✔ Exam submitted successfully.\n");
          break;

        case 6:
          System.out.println("\n--- VIEW RESULT ---");
          System.out.print("Enter Student ID: ");
          String resultStudentId = sc.next();
          System.out.print("Enter Exam ID: ");
          String resultExamId = sc.next();

          service.viewResult(resultStudentId, resultExamId);
          System.out.println();
          break;

        case 7:
          System.out.println("\nThank you for using the Online Examination System.");
          System.out.println("Goodbye!");
          sc.close();
          return;

        default:
          System.out.println(" Invalid choice. Please select a valid option.\n");
        }

      } catch (Exception e) {
        System.out.println(" ERROR: " + e.getMessage());
        System.out.println("Please try again.\n");
      }
    }
  }

  private static void showMenu() {
    System.out.println("""

        ----------- MAIN MENU -------
        1. Create Exam
        2. Add Question to Exam
        3. Enroll Student
        4. Start Exam
        5. Submit Exam
        6. View Result
        7. Exit
        """);
  }
}
