// Problem: Student Vote Checker
// Write a program to take user input for the age of all 10 students in a class 
// and check whether the student can vote depending on his/her age is greater or equal to 18.
// Hint:
// - Create a method public boolean canStudentVote(int age) which takes in age as a parameter and returns true or false
// - Inside the method firstly validate the age for a negative number, if negative return false cannot vote.
//   For valid age check for age is 18 or above return true; else return false.
// - In the main function define an array of 10 integer elements, loop through the array by take user input 
//   for the student's age, call canStudentVote() and display the result

import java.util.Scanner;

public class StudentVoteChecker {
  private static final int VOTING_AGE = 18;
  private static final int NUM_STUDENTS = 10;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] ages = new int[NUM_STUDENTS];

    System.out.println("Enter the age of " + NUM_STUDENTS + " students:");

    for (int i = 0; i < NUM_STUDENTS; i++) {
      System.out.print("Enter age of student " + (i + 1) + ": ");
      ages[i] = scanner.nextInt();

      if (canStudentVote(ages[i])) {
        System.out.println("Student " + (i + 1) + " can vote (Age: " + ages[i] + ")");
      } else {
        System.out.println("Student " + (i + 1) + " cannot vote (Age: " + ages[i] + ")");
      }
    }

    scanner.close();
  }

  public static boolean canStudentVote(int age) {
    if (age < 0) {
      return false;
    }
    return age >= VOTING_AGE;
  }
}
