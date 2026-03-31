import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class MathService {

  @CacheResult
  public int slowSquare(int number) {
    System.out.println("Computing square for: " + number);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return number * number;
  }
}

class CacheExecutor {

  private static final Map<String, Object> cache = new HashMap<>();

  public static Object execute(Object target, String methodName, Object... args) throws Exception {

    Class<?> clazz = target.getClass();

    Method method = Arrays.stream(clazz.getDeclaredMethods()).filter(m -> m.getName().equals(methodName)).findFirst()
        .orElseThrow(() -> new RuntimeException("Method not found"));

    // If method is cacheable
    if (method.isAnnotationPresent(CacheResult.class)) {

      String cacheKey = buildCacheKey(method, args);

      if (cache.containsKey(cacheKey)) {
        System.out.println("Returning cached result...");
        return cache.get(cacheKey);
      }

      Object result = method.invoke(target, args);
      cache.put(cacheKey, result);
      return result;
    }

    // Not cacheable
    return method.invoke(target, args);
  }

  private static String buildCacheKey(Method method, Object[] args) {
    return method.getName() + Arrays.toString(args);
  }
}

public class CacheResultAnnotation {

  public static void main(String[] args) throws Exception {

    MathService service = new MathService();

    System.out.println(CacheExecutor.execute(service, "slowSquare", 5));
    System.out.println(CacheExecutor.execute(service, "slowSquare", 5)); // cached
    System.out.println(CacheExecutor.execute(service, "slowSquare", 6));
    System.out.println(CacheExecutor.execute(service, "slowSquare", 6)); // cached
  }
}
