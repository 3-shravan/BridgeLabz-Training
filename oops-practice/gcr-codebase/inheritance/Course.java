public class Course {
  private String coruseName;
  private int durationInWeeks;

  public Course(String courseName, int durationInWeeks) {
    this.coruseName = courseName;
    this.durationInWeeks = durationInWeeks;
  }

  void displayCourseDetails() {
    System.out.println("Course Name: " + coruseName);
    System.out.println("Duration (weeks): " + durationInWeeks);
  }

  public static void main(String[] args) {
    PaidOnlineCouse paidCourse = new PaidOnlineCouse("Java Programming", 8, "Udemy", true, 199.99, 20);
    paidCourse.displayCourseDetails();
  }
}

class OnlineCourse extends Course {
  String platform;
  boolean isRecorded;

  OnlineCourse(String courseName, int durationInWeeks, String platform, boolean isRecorded) {
    super(courseName, durationInWeeks);
    this.platform = platform;
    this.isRecorded = isRecorded;
  }

  @Override
  void displayCourseDetails() {
    super.displayCourseDetails();
    System.out.println("Platform: " + platform);
    System.out.println("Is Recorded: " + isRecorded);
  }

}

class PaidOnlineCouse extends OnlineCourse {
  double fee;
  int discount;

  PaidOnlineCouse(String courseName, int durationInWeeks, String platform, boolean isRecorded, double fee,
      int discount) {
    super(courseName, durationInWeeks, platform, isRecorded);
    this.fee = fee;
    this.discount = discount;
  }

  @Override
  void displayCourseDetails() {
    super.displayCourseDetails();
    System.out.println("Fee: " + fee);
    System.out.println("Discount: " + discount + "%");
  }
}
