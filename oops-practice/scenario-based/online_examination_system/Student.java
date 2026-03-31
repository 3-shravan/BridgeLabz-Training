package online_examination_system;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/*
 WHY Student class?
 - Encapsulates exam attempts & answers
*/
public class Student {

    private final String studentId;
    private final String name;

    private Map<String, LocalDateTime> examStartTimes = new HashMap<>();
    private Map<String, Integer> examScores = new HashMap<>();

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void startExam(String examId) {
        examStartTimes.put(examId, LocalDateTime.now());
    }

    public LocalDateTime getExamStartTime(String examId) {
        return examStartTimes.get(examId);
    }

    public void setScore(String examId, int score) {
        examScores.put(examId, score);
    }

    public Integer getScore(String examId) {
        return examScores.get(examId);
    }

    public String getStudentId() {
        return studentId;
    }
}
