import java.lang.reflect.Field;

class Configuration {
  private static String API_KEY = "DEFAULT_KEY";

  public static String getApiKey() {
    return API_KEY;
  }
}

public class StaticFieldModification {
  public static void main(String[] args) {
    try {
      System.out.println("Before: " + Configuration.getApiKey());

      Field field = Configuration.class.getDeclaredField("API_KEY");
      field.setAccessible(true);
      field.set(null, "NEW_API_KEY_123");

      System.out.println("After: " + Configuration.getApiKey());
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
