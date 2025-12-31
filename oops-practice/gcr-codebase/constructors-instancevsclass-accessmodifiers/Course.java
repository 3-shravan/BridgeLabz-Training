public class Course {
  private String courseName;
  private int duration;
  private double fee;

  private static String instituteName = "ABC Institute";

  public Course() {
    this("Not Assigned", 0, 0.0);
  }

  public Course(String courseName, int duration, double fee) {
    this.courseName = courseName;
    this.duration = duration;
    this.fee = fee;
  }

  void displayCourseDetails() {
    System.out.println("Course Name: " + courseName);
    System.out.println("Duration: " + duration + " hours");
    System.out.println("Fee: $" + fee);
    System.out.println("Institute Name: " + instituteName);

  }

  void updateInstituteName(String name) {
    instituteName = name;
  }
}