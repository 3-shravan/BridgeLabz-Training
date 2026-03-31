import java.util.Objects;

public class Course {

  private final String courseId;
  private final String courseName;
  private final int credits;

  public Course(String courseId, String courseName, int credits) {
    if (courseId == null || courseId.isBlank()) {
      throw new IllegalArgumentException("courseId cannot be empty");
    }
    if (courseName == null || courseName.isBlank()) {
      throw new IllegalArgumentException("courseName cannot be empty");
    }
    if (credits <= 0) {
      throw new IllegalArgumentException("credits must be positive");
    }
    this.courseId = courseId;
    this.courseName = courseName;
    this.credits = credits;
  }

  public String getCourseId() {
    return courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public int getCredits() {
    return credits;
  }

  @Override
  public String toString() {
    return courseId + " - " + courseName + " (" + credits + " credits)";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Course)) {
      return false;
    }
    Course course = (Course) o;
    return courseId.equals(course.courseId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseId);
  }
}
