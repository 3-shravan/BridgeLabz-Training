import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
  String priority();

  String assignedTo();
}

class TaskManager {
  @TaskInfo(priority = "High", assignedTo = "Alice")
  public void completeTask() {
    System.out.println("Task is being completed...");
  }
}

public class TaskInfoAnnotationDemo {
  public static void main(String[] args) throws Exception {
    TaskManager taskManager = new TaskManager();
    Method method = taskManager.getClass().getMethod("completeTask");

    TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
    System.out.println("Task Priority: " + taskInfo.priority() + ", Assigned To: " + taskInfo.assignedTo());

    taskManager.completeTask();
  }

}
