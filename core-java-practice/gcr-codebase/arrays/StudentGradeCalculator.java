import java.util.Scanner;

public class StudentGradeCalculator {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of students: ");
    int n = sc.nextInt();

    int[] physics = new int[n];
    int[] chemistry = new int[n];
    int[] maths = new int[n];
    double[] percentage = new double[n];
    char[] grade = new char[n];

    for (int i = 0; i < n; i++) {
      System.out.println("\nEnter marks for Student " + (i + 1));

      System.out.print("Physics: ");
      physics[i] = sc.nextInt();

      System.out.print("Chemistry: ");
      chemistry[i] = sc.nextInt();

      System.out.print("Maths: ");
      maths[i] = sc.nextInt();

      if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
        System.out.println("Marks cannot be negative. Please re-enter.");
        i--;
        continue;
      }

      percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

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
      System.out.println("Physics: " + physics[i]);
      System.out.println("Chemistry: " + chemistry[i]);
      System.out.println("Maths: " + maths[i]);
      System.out.printf("Percentage: %.2f%%\n", percentage[i]);
      System.out.println("Grade: " + grade[i]);
      System.out.println();
    }

    sc.close();
  }
}
