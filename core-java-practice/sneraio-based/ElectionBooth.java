/*Election Booth Manager ️
Design a polling booth system.
● Take age input.
● Use if to check if eligible (>=18).
● Record vote (1, 2, or 3 for candidates).
● Loop for multiple voters, exit on special code. */

import java.util.Scanner;

public class ElectionBooth {
  private static int CANDIDATE_1 = 0;
  private static int CANDIDATE_2 = 0;
  private static int CANDIDATE_3 = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("Enter your age (or -1 to exit): ");
      int age = sc.nextInt();
      if (age == -1) {
        break;
      }
      if (age < 18) {
        System.out.println("You are not eligible to vote.");
        continue;
      }
      System.out.print("Enter your vote (1, 2, or 3 for candidates): ");
      int vote = sc.nextInt();
      switch (vote) {
        case 1:
          CANDIDATE_1++;
          break;
        case 2:
          CANDIDATE_2++;
          break;
        case 3:
          CANDIDATE_3++;
          break;
        default:
          System.out.println("Invalid vote.");
      }
    }
    sc.close();
    System.out.println("Voting Results:");
    System.out.println("Candidate 1: " + CANDIDATE_1 + " votes");
    System.out.println("Candidate 2: " + CANDIDATE_2 + " votes");
    System.out.println("Candidate 3: " + CANDIDATE_3 + " votes");

  }

}
