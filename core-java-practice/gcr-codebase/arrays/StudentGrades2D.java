/*
Rewrite the program to store the marks of the students in Physics, Chemistry, and Maths in a 2D array and then compute the percentage and grade.
Hint => 
- All the steps are the same as the earlier program except the marks are stored in a 2D array
- Use the 2D array to calculate the percentages and grades of the students
*/

import java.util.Scanner;

public class StudentGrades2D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of students: ");
    int n = sc.nextInt();
    if (n <= 0) {
      System.out.println("Invalid number of students.");
      sc.close();
      return;
    }

    int[][] marks = new int[n][3];
    double[] percentage = new double[n];
    char[] grade = new char[n];

    for (int i = 0; i < n; i++) {
      System.out.println("\nEnter marks for Student " + (i + 1));

      System.out.print("Physics: ");
      marks[i][0] = sc.nextInt();

      System.out.print("Chemistry: ");
      marks[i][1] = sc.nextInt();

      System.out.print("Maths: ");
      marks[i][2] = sc.nextInt();

      if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
        System.out.println("Marks cannot be negative. Please re-enter.");
        i--; 
        continue;
      }

      int sum = marks[i][0] + marks[i][1] + marks[i][2];
      percentage[i] = sum / 3.0;

      if (percentage[i] >= 80) {
        grade[i] = 'A';
      } else if (percentage[i] >= 70) {
        grade[i] = 'B';
      } else if (percentage[i] >= 60) {
        grade[i] = 'C';
      } else if (percentage[i] >= 50) {
        grade[i] = 'D';
      } else if (percentage[i] >= 40) {
        grade[i] = 'E';
      } else {
        grade[i] = 'R';
      }
    }

    System.out.println("\n--- Student Results ---");
    for (int i = 0; i < n; i++) {
      System.out.println("Student " + (i + 1));
      System.out.println("Physics: " + marks[i][0]);
      System.out.println("Chemistry: " + marks[i][1]);
      System.out.println("Maths: " + marks[i][2]);
      System.out.printf("Percentage: %.2f%%\n", percentage[i]);
      System.out.println("Grade: " + grade[i]);
      System.out.println();
    }

    sc.close();
  }
}
