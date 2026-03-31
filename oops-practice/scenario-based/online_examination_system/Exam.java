package online_examination_system;

import java.util.ArrayList;
import java.util.List;

/*
 WHY Exam class?
 - Groups questions
 - Maintains exam duration
*/
public class Exam {

  private final String examId;
  private final int durationMinutes;
  private final List<Question> questions = new ArrayList<>();

  public Exam(String examId, int durationMinutes) {
    this.examId = examId;
    this.durationMinutes = durationMinutes;
  }

  public String getExamId() {
    return examId;
  }

  public int getDurationMinutes() {
    return durationMinutes;
  }

  public void addQuestion(Question question) {
    questions.add(question);
  }

  public List<Question> getQuestions() {
    return questions;
  }
}
