import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
  BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
  String description();
}

class TaskManager2 {

  @BugReport(description = "NullPointerException when input is null")
  @BugReport(description = "Performance issue for large data")
  public void processTask() {
    System.out.println("Processing task...");
  }
}

public class BugReportAnnotation {

  public static void main(String[] args) throws Exception {

    TaskManager2 manager = new TaskManager2();

    Method method = manager.getClass().getMethod("processTask");

    BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

    for (BugReport bug : bugReports) {
      System.out.println("Bug: " + bug.description());
    }

    manager.processTask();
  }

}
