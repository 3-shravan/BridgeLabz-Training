import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExamProctor {
  static class ExamSession {
    private Stack<Integer> questions = new Stack<>();
    private Map<Integer, String> answers = new HashMap<>();

    public void visitQuestion(int questionId) {
      questions.push(questionId);
      System.out.println("Visiting question: " + questionId);
    }

    public void submitAnswer(int questionId, String answer) {
      answers.put(questionId, answer);
      System.out.println("Submitted answer for question " + questionId + ": " + answer);
    }

    public int evaluate(Map<Integer, String> correctAnswers) {
      int score = 0;

      for (Map.Entry<Integer, String> entry : answers.entrySet()) {
        if (entry.getValue().equals(correctAnswers.get(entry.getKey()))) {
          score++;
        }
      }
      return score;
    }

    public void reviewNavigation() {
      System.out.println("Question Navigation Order:");
      while (!questions.isEmpty()) {
        System.out.println("Q" + questions.pop());
      }
    }

  }

  public static void main(String[] args) {
    ExamSession exam = new ExamSession();

    exam.visitQuestion(1);
    exam.visitQuestion(2);
    exam.visitQuestion(3);

    exam.submitAnswer(1, "A");
    exam.submitAnswer(2, "B");
    exam.submitAnswer(3, "C");

    Map<Integer, String> correct = new HashMap<>();
    correct.put(1, "A");
    correct.put(2, "C");
    correct.put(3, "C");

    int score = exam.evaluate(correct);
    System.out.println("Final Score: " + score);

    exam.reviewNavigation();
  }
}
