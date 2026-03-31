import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
  String level() default "HIGH";
}

class Service {

  @ImportantMethod
  public void processPayment() {
    System.out.println("Processing payment...");
  }

  @ImportantMethod(level = "MEDIUM")
  public void generateReport() {
    System.out.println("Generating report...");
  }

  public void helperMethod() {
    System.out.println("Helper method (not important)");
  }
}

public class ImportantMethodAnnotation {
  public static void main(String[] args) {
    Service service = new Service();

    Method[] methods = service.getClass().getDeclaredMethods();
    Arrays.stream(methods).filter(m -> m.isAnnotationPresent(ImportantMethod.class)).forEach(m -> {
      ImportantMethod annotation = m.getAnnotation(ImportantMethod.class);
      System.out.println("Method: " + m.getName() + ", Importance Level: " + annotation.level());
    });
  }
}
