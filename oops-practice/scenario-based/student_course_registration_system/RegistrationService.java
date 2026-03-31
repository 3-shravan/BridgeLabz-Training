import java.util.List;
import java.util.Map;

public interface RegistrationService {

  void registerStudent(Student student);

  void addCourse(Course course);

  void enrollStudentInCourse(String studentId, String courseId) throws CourseLimitExceededException;

  void dropStudentFromCourse(String studentId, String courseId);

  void assignGrade(String studentId, String courseId, double grade);

  List<Course> getEnrolledCourses(String studentId);

  Map<String, Double> getGrades(String studentId);

  List<Course> getAllCourses();

  List<Student> getAllStudents();
}
