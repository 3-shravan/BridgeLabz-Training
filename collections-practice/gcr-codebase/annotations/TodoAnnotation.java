import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
  String task();

  String assignedTo();

  String priority() default "MEDIUM";
}

class ProjectService {

  @Todo(task = "Implement user authentication", assignedTo = "Shravan", priority = "HIGH")
  public void authFeature() {
    // pending
  }

  @Todo(task = "Add payment gateway", assignedTo = "Amit")
  public void paymentFeature() {
    // pending
  }

  @Todo(task = "Optimize database queries", assignedTo = "Neha", priority = "LOW")
  public void optimizationFeature() {
    // pending
  }
}

public class TodoAnnotation {

  public static void main(String[] args) {
    ProjectService service = new ProjectService();
    Method[] methods = service.getClass().getDeclaredMethods();
    Arrays.stream(methods).filter(m -> m.isAnnotationPresent(Todo.class)).forEach(m -> {
      Todo todo = m.getAnnotation(Todo.class);
      System.out.println("Method: " + m.getName());
      System.out.println(" Task: " + todo.task());
      System.out.println(" Assigned To: " + todo.assignedTo());
      System.out.println(" Priority: " + todo.priority());
    });

  }

}
