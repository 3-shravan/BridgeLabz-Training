import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentScoreAnalyzer {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> scores = new ArrayList<>();

    while (true) {
      System.out.println("Enter student scores separated by spaces (or type 'exit' to quit):");
      String input = scanner.nextLine();

      if (input.equalsIgnoreCase("exit")) {
        break;
      }

      String[] parts = input.split("\\s+");

      for (String part : parts) {
        try {
          int score = Integer.parseInt(part);

          if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
          }

          scores.add(score);

        } catch (NumberFormatException e) {
          System.out.println("Invalid input: " + part);
        }
      }
    }

    scanner.close();

    System.out.println("Average Score: " + averageScore(scores));
    System.out.println("Highest Score: " + highestScore(scores));
    System.out.println("Lowest Score: " + lowestScore(scores));
  }

  private static int averageScore(List<Integer> scores) {
    if (scores.isEmpty())
      return 0;

    int sum = 0;
    for (int score : scores) {
      sum += score;
    }
    return sum / scores.size();
  }

  static int highestScore(List<Integer> scores) {
    if (scores.isEmpty())
      return 0;

    int highest = scores.get(0);
    for (int score : scores) {
      if (score > highest) {
        highest = score;
      }
    }
    return highest;
  }

  static int lowestScore(List<Integer> scores) {
    if (scores.isEmpty())
      return 0;

    int lowest = scores.get(0);
    for (int score : scores) {
      if (score < lowest) {
        lowest = score;
      }
    }
    return lowest;
  }
}
