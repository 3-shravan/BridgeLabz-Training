import java.util.Scanner;

public class StudentScores {

  static class Student {
    String name;
    int score;

    Student(String name, int score) {
      this.name = name;
      this.score = score;

    }

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of students:");
    int n = scanner.nextInt();

    Student[] students = new Student[n];
    int totalScore = 0;
    for (int i = 0; i < n; i++) {
      System.out.println("Enter name of student " + (i + 1) + ":");
      String name = scanner.next();

      int score;
      while (true) {
        System.out.println("Enter score of " + name + " (0-100):");
        score = scanner.nextInt();
        if (score >= 0 && score <= 100) {
          break;
        } else {
          System.out.println("Invalid score. Please enter a score between 0 and 100.");
          scanner.nextInt();
        }
      }
      students[i] = new Student(name, score);
      totalScore += score;
    }
    double averageScore = (double) totalScore / n;
    System.out.printf("The average score of the class is: %.2f%n", averageScore);

    int highest = students[0].score;
    int lowest = students[0].score;

    for (int i = 1; i < n; i++) {
      if (students[i].score > highest) {
        highest = students[i].score;
      }
      if (students[i].score < lowest) {
        lowest = students[i].score;
      }
    }
    System.out.println("Highest score: " + highest);
    System.out.println("Lowest score: " + lowest);

    System.out.println("\nStudents scoring above average:");
    for (int i = 0; i < n; i++) {
      if (students[i].score > averageScore) {
        System.out.println(students[i].name + " - " + students[i].score);
      }
    }

    scanner.close();
  }

}
