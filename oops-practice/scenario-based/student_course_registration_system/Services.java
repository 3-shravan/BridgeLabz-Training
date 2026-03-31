import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class Services implements RegistrationService {

  private final Map<String, Student> studentsById = new HashMap<>();
  private final Map<String, Course> coursesById = new HashMap<>();

  @Override
  public void registerStudent(Student student) {
    if (student == null) {
      throw new IllegalArgumentException("student cannot be null");
    }
    studentsById.put(student.getId(), student);
  }

  @Override
  public void addCourse(Course course) {
    if (course == null) {
      throw new IllegalArgumentException("course cannot be null");
    }
    coursesById.put(course.getCourseId(), course);
  }

  @Override
  public void enrollStudentInCourse(String studentId, String courseId)
      throws CourseLimitExceededException {
    Student student = requireStudent(studentId);
    Course course = requireCourse(courseId);
    student.enroll(course);
  }

  @Override
  public void dropStudentFromCourse(String studentId, String courseId) {
    Student student = requireStudent(studentId);
    student.drop(courseId);
  }

  @Override
  public void assignGrade(String studentId, String courseId, double grade) {
    Student student = requireStudent(studentId);
    requireCourse(courseId); // ensures course exists in catalog
    student.assignGrade(courseId, grade);
  }

  @Override
  public List<Course> getEnrolledCourses(String studentId) {
    return requireStudent(studentId).getEnrolledCourses();
  }

  @Override
  public Map<String, Double> getGrades(String studentId) {
    return requireStudent(studentId).getGrades();
  }

  @Override
  public List<Course> getAllCourses() {
    List<Course> courses = new ArrayList<>(coursesById.values());
    return Collections.unmodifiableList(courses);
  }

  @Override
  public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>(studentsById.values());
    return Collections.unmodifiableList(students);
  }

  private Student requireStudent(String studentId) {
    if (studentId == null || studentId.isBlank()) {
      throw new IllegalArgumentException("studentId cannot be empty");
    }
    Student student = studentsById.get(studentId);
    if (student == null) {
      throw new IllegalArgumentException("Student not found: " + studentId);
    }
    return student;
  }

  private Course requireCourse(String courseId) {
    if (courseId == null || courseId.isBlank()) {
      throw new IllegalArgumentException("courseId cannot be empty");
    }
    Course course = coursesById.get(courseId);
    if (course == null) {
      throw new IllegalArgumentException("Course not found: " + courseId);
    }
    return course;
  }
}
