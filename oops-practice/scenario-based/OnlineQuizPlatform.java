import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
  public InvalidQuizSubmissionException(String message) {
    super(message);
  }
}

// Quiz Processor Class
class QuizProcessor {

  // Compare answers and return score
  public static int calculateScore(String[] correctAnswers, String[] userAnswers)
      throws InvalidQuizSubmissionException {

    if (correctAnswers.length != userAnswers.length) {
      throw new InvalidQuizSubmissionException(
          "Number of answers does not match the quiz.");
    }

    int score = 0;
    for (int i = 0; i < correctAnswers.length; i++) {
      if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
        score++;
      }
    }
    return score;
  }

  // Return grade based on score
  public static String getGrade(int score, int total) {
    double percentage = (score * 100.0) / total;

    if (percentage >= 80)
      return "A";
    else if (percentage >= 60)
      return "B";
    else if (percentage >= 40)
      return "C";
    else
      return "F";
  }
}

// Main Class
public class OnlineQuizPlatform {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String[] correctAnswers = { "A", "B", "C", "D", "A" };
    int totalQuestions = correctAnswers.length;

    System.out.print("Enter number of users: ");
    int users = sc.nextInt();
    sc.nextLine();

    List<Integer> scores = new ArrayList<>();

    for (int u = 1; u <= users; u++) {
      System.out.println("\nUser " + u + " answers:");

      String[] userAnswers = new String[totalQuestions];
      for (int i = 0; i < totalQuestions; i++) {
        System.out.print("Q" + (i + 1) + ": ");
        userAnswers[i] = sc.nextLine();
      }

      try {
        int score = QuizProcessor.calculateScore(correctAnswers, userAnswers);
        scores.add(score);

        String grade = QuizProcessor.getGrade(score, totalQuestions);
        System.out.println("Score: " + score + "/" + totalQuestions);
        System.out.println("Grade: " + grade);

      } catch (InvalidQuizSubmissionException e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.println("\nAll user scores: " + scores);
    sc.close();
  }
}
