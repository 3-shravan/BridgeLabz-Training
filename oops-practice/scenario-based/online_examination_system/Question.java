package online_examination_system;

public class Question {

  private final String questionText;
  private final String correctAnswer;
  private final boolean objective;

  public Question(String questionText, String correctAnswer, boolean objective) {
    this.questionText = questionText;
    this.correctAnswer = correctAnswer;
    this.objective = objective;
  }

  public boolean isObjective() {
    return objective;
  }

  public boolean evaluate(String studentAnswer) {
    return correctAnswer.equalsIgnoreCase(studentAnswer);
  }
}
