import java.util.Arrays;
import java.util.List;

abstract class CourseType {

  private String evaluationMethod;

  protected CourseType(String evaluationMethod) {
    this.evaluationMethod = evaluationMethod;
  }

  public String getEvaluationMethod() {
    return evaluationMethod;
  }

  public abstract String getType();
}

class ExamCourse extends CourseType {

  public ExamCourse() {
    super("Written Examination");
  }

  @Override
  public String getType() {
    return "Exam-Based Course";
  }
}

class AssignmentCourse extends CourseType {

  public AssignmentCourse() {
    super("Assignments & Projects");
  }

  @Override
  public String getType() {
    return "Assignment-Based Course";
  }
}

class ResearchCourse extends CourseType {

  public ResearchCourse() {
    super("Research & Thesis");
  }

  @Override
  public String getType() {
    return "Research-Based Course";
  }
}

class Course<T extends CourseType> {

  private String courseName;
  private int credits;
  private T courseType;

  public Course(String courseName, int credits, T courseType) {
    this.courseName = courseName;
    this.credits = credits;
    this.courseType = courseType;
  }

  public String getDetails() {
    return "Course: " + courseName + ", Credits: " + credits + ", Type: " + courseType.getType() + ", Evaluation: "
        + courseType.getEvaluationMethod();
  }
}

class DepartmentUtil {

  public static void displayCourses(List<? extends CourseType> courseTypes) {
    for (CourseType type : courseTypes) {
      System.out.println(type.getType() + " | Evaluation: " + type.getEvaluationMethod());
    }
  }
}

public class UniversityCourseManagement {

  public static void main(String[] args) {

    Course<ExamCourse> math = new Course<>("Mathematics", 4, new ExamCourse());

    Course<AssignmentCourse> cs = new Course<>("Computer Science", 3, new AssignmentCourse());

    Course<ResearchCourse> phd = new Course<>("AI Research", 6, new ResearchCourse());

    System.out.println(math.getDetails());
    System.out.println(cs.getDetails());
    System.out.println(phd.getDetails());

    System.out.println("\n--- Department Course Types ---");
    List<CourseType> courseTypes = Arrays.asList(new ExamCourse(), new AssignmentCourse(), new ResearchCourse());

    DepartmentUtil.displayCourses(courseTypes);
  }

}
