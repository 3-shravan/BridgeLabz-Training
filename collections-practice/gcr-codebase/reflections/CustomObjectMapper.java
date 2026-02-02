import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Person2 {
  private String name;
  private int age;
  private boolean active;

  @Override
  public String toString() {
    return "Person{name='" + name + "', age=" + age + ", active=" + active + "}";
  }
}

public class CustomObjectMapper {
  public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
    try {
      T obj = clazz.getDeclaredConstructor().newInstance();

      for (Map.Entry<String, Object> entry : properties.entrySet()) {
        String fieldName = entry.getKey();
        Object value = entry.getValue();

        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);

      }

      return obj;
    } catch (Exception e) {
      throw new RuntimeException("Mapping failed: " + e.getMessage(), e);
    }
  }

  public static void main(String[] args) {
    Map<String, Object> data = new HashMap<>();
    data.put("name", "Shravan");
    data.put("age", 21);
    data.put("active", true);

    Person2 person = toObject(Person2.class, data);
    System.out.println(person);
  }
}
