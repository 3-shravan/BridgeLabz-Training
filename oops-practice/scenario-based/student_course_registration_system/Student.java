import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {

  private final int maxCourses;
  private final List<Course> enrolledCourses;
  private final Map<String, Double> gradesByCourseId;

  public Student(String studentId, String name, int maxCourses) {
    super(studentId, name);
    if (maxCourses <= 0) {
      throw new IllegalArgumentException("maxCourses must be positive");
    }
    this.maxCourses = maxCourses;
    this.enrolledCourses = new ArrayList<>();
    this.gradesByCourseId = new LinkedHashMap<>();
  }

  public int getMaxCourses() {
    return maxCourses;
  }

  public List<Course> getEnrolledCourses() {
    return Collections.unmodifiableList(enrolledCourses);
  }

  public Map<String, Double> getGrades() {
    return Collections.unmodifiableMap(gradesByCourseId);
  }

  public boolean isEnrolledIn(String courseId) {
    for (Course course : enrolledCourses) {
      if (course.getCourseId().equals(courseId)) {
        return true;
      }
    }
    return false;
  }

  public void enroll(Course course) throws CourseLimitExceededException {
    if (course == null) {
      throw new IllegalArgumentException("course cannot be null");
    }
    if (isEnrolledIn(course.getCourseId())) {
      return; // already enrolled, no-op
    }
    if (enrolledCourses.size() >= maxCourses) {
      throw new CourseLimitExceededException(
          "Cannot enroll in more than " + maxCourses + " courses");
    }
    enrolledCourses.add(course);
  }

  public void drop(String courseId) {
    if (courseId == null || courseId.isBlank()) {
      throw new IllegalArgumentException("courseId cannot be empty");
    }
    enrolledCourses.removeIf(c -> c.getCourseId().equals(courseId));
    gradesByCourseId.remove(courseId);
  }

  public void assignGrade(String courseId, double grade) {
    if (courseId == null || courseId.isBlank()) {
      throw new IllegalArgumentException("courseId cannot be empty");
    }
    if (!isEnrolledIn(courseId)) {
      throw new IllegalStateException("Student is not enrolled in course: " + courseId);
    }
    if (grade < 0.0 || grade > 100.0) {
      throw new IllegalArgumentException("grade must be between 0 and 100");
    }
    gradesByCourseId.put(courseId, grade);
  }
}
