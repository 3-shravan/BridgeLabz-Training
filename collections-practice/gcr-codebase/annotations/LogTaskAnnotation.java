import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceService {

  @LogExecutionTime
  public void fastTask() {
    for (int i = 0; i < 1_000_000; i++) {
      // simulate fast work
    }
  }

  @LogExecutionTime
  public void slowTask() {
    for (int i = 0; i < 50_000_000; i++) {
      // simulate slow work
    }
  }

  public void normalTask() {
    for (int i = 0; i < 10_000_000; i++) {
      // not logged
    }
  }
}

public class LogTaskAnnotation {

  public static void main(String[] args) {

    PerformanceService performanceService = new PerformanceService();

    Arrays.stream(performanceService.getClass().getDeclaredMethods())
        .filter(m -> m.isAnnotationPresent(LogExecutionTime.class)).forEach(m -> {
          try {
            long start = System.nanoTime();
            m.invoke(performanceService);
            long end = System.nanoTime();
            long duration = end - start;

            System.out.println("Method: " + m.getName() + " | Execution Time: " + duration + " ns");
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

  }

}
