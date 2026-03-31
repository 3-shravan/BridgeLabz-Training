/*
Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade as shown in figure below

Hint => 
Write a method to generate random 2-digit scores for Physics, Chemistry and Math (PCM) for the students and return the scores. This method returns a 2D array with PCM scores for all students
Write a Method to calculate the total, average, and percentages for each student and return a 2D array with the corresponding values. Please ensure to round off the values to 2 Digits using Math.round() method
Write a Method to calculate the grade based on the percentage as shown in the ref table and return a 2D array of students' grade
Finally write a Method to display the scorecard of all students with their scores, total, average, percentage, and grade in a tabular format. 
 */

import java.util.Random;

public class StudentGradeCalculatorString {

  public static void main(String[] args) {

    int students = 5;

    // Step a: Generate random PCM scores
    int[][] pcmScores = generatePCMScores(students);

    // Step b: Calculate total, average, percentage
    double[][] results = calculateResults(pcmScores);

    // Step c: Calculate grades
    char[] grades = calculateGrades(results);

    // Step d: Display scorecard
    displayScorecard(pcmScores, results, grades);
  }

  // a. Generate random 2-digit PCM scores
  public static int[][] generatePCMScores(int students) {

    Random rand = new Random();
    int[][] scores = new int[students][3];

    for (int i = 0; i < students; i++) {
      scores[i][0] = rand.nextInt(90) + 10; // Physics
      scores[i][1] = rand.nextInt(90) + 10; // Chemistry
      scores[i][2] = rand.nextInt(90) + 10; // Math
    }
    return scores;
  }

  // b. Calculate total, average, percentage
  public static double[][] calculateResults(int[][] scores) {

    double[][] result = new double[scores.length][3];

    for (int i = 0; i < scores.length; i++) {
      int total = scores[i][0] + scores[i][1] + scores[i][2];
      double average = total / 3.0;
      double percentage = (total / 300.0) * 100;

      result[i][0] = Math.round(total * 100.0) / 100.0;
      result[i][1] = Math.round(average * 100.0) / 100.0;
      result[i][2] = Math.round(percentage * 100.0) / 100.0;
    }
    return result;
  }

  // c. Calculate grade based on percentage
  public static char[] calculateGrades(double[][] results) {

    char[] grades = new char[results.length];

    for (int i = 0; i < results.length; i++) {
      double percentage = results[i][2];

      if (percentage >= 80)
        grades[i] = 'A';
      else if (percentage >= 70)
        grades[i] = 'B';
      else if (percentage >= 60)
        grades[i] = 'C';
      else if (percentage >= 50)
        grades[i] = 'D';
      else if (percentage >= 40)
        grades[i] = 'E';
      else
        grades[i] = 'R';
    }
    return grades;
  }

  // d. Display scorecard
  public static void displayScorecard(int[][] pcm, double[][] results, char[] grades) {

    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
    System.out.println("--------------------------------------------------------------------------------");

    for (int i = 0; i < pcm.length; i++) {
      System.out.println((i + 1) + "\t" +
          pcm[i][0] + "\t" +
          pcm[i][1] + "\t" +
          pcm[i][2] + "\t" +
          results[i][0] + "\t" +
          results[i][1] + "\t" +
          results[i][2] + "\t" +
          grades[i]);
    }
    System.out.println("--------------------------------------------------------------------------------");
  }
}
