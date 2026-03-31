package online_examination_system;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ExamService {

    private Map<String, Exam> exams = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    public void createExam(String examId, int duration) {
        exams.put(examId, new Exam(examId, duration));
        System.out.println("Exam created successfully");
    }

    public void addQuestion(String examId, String question, String answer, boolean objective) {
        exams.get(examId).addQuestion(new Question(question, answer, objective));
        System.out.println("Question added");
    }

    public void enrollStudent(String studentId, String name) {
        students.put(studentId, new Student(studentId, name));
        System.out.println("Student enrolled");
    }

    public void startExam(String studentId, String examId) {
        students.get(studentId).startExam(examId);
        System.out.println("Exam started");
    }

    public void submitExam(String studentId, String examId) throws ExamTimeExpiredException {

        Student student = students.get(studentId);
        Exam exam = exams.get(examId);

        LocalDateTime start = student.getExamStartTime(examId);
        long minutesTaken = Duration.between(start, LocalDateTime.now()).toMinutes();

        if (minutesTaken > exam.getDurationMinutes()) {
            throw new ExamTimeExpiredException("Exam time expired");
        }

        EvaluationStrategy strategy = exam.getQuestions().get(0).isObjective() ? new ObjectiveEvaluation()
                : new DescriptiveEvaluation();

        int score = strategy.evaluate(exam);
        student.setScore(examId, score);

        System.out.println("Exam submitted. Score: " + score);
    }

    public void viewResult(String studentId, String examId) {
        Integer score = students.get(studentId).getScore(examId);
        System.out.println("Result: " + (score == null ? "Not available" : score));
    }
}
