import java.lang.reflect.Method;

class Work {
  public void fastTask() {
    int sum = 0;
    for (int i = 0; i < 1000; i++) {
      sum += i;
    }
  }

  public void slowTask() {
    long sum = 0;
    for (int i = 0; i < 5_000_000; i++) {
      sum += i;
    }
  }
}

public class MethodTimingDemo {
  public static void main(String[] args) {
    try {
      Work work = new Work();
      Class<?> clazz = work.getClass();

      for (Method method : clazz.getDeclaredMethods()) {
        if (method.getParameterCount() == 0) {
          long start = System.nanoTime();
          method.invoke(work);
          long end = System.nanoTime();

          long timeMs = (end - start) / 1_000_000;
          System.out.println(method.getName() + " took " + timeMs + " ms");
        }
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
