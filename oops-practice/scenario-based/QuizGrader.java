public class QuizGrader {
  public static void main(String[] args) {
    String[] correctAnswers = {
        "A", "B", "C", "D", "A",
        "C", "B", "D", "A", "C"
    };

    String[] studentAnswers = {
        "a", "B", "D", "D", "A",
        "c", "b", "A", "A", "c"
    };
    int score = quizScore(correctAnswers, studentAnswers);
    System.out.println("Student's score: " + score + " out of " + correctAnswers.length);

    double percentage = (score / (double) correctAnswers.length) * 100;
    System.out.printf("Percentage: %.2f%%\n", percentage);

    if (percentage >= 33) {
      System.out.println("Result: Pass");
    } else {
      System.out.println("Result: Fail");
    }

  }

  static int quizScore(String[] correctAnswers, String[] studentAnswers) {
    int score = 0;
    for (int i = 0; i < correctAnswers.length; i++) {
      if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
        score++;
        System.out.println("Question " + (i + 1) + ": Correct");
      } else {
        System.out.println("Question " + (i + 1) + ": Incorrect");
      }
    }
    return score;
  }
}
