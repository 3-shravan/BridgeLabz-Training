import java.lang.reflect.Field;
import java.util.StringJoiner;

class Student2 {
  private String name;
  private int age;

  public Student2(String name, int age) {
    this.name = name;
    this.age = age;
  }
}

public class ObjectToJson {
  public static String toJson(Object obj) throws IllegalAccessException {
    StringJoiner joiner = new StringJoiner(", ", "{", "}");
    Field[] fields = obj.getClass().getDeclaredFields();

    for (Field field : fields) {
      field.setAccessible(true);
      Object value = field.get(obj);

      String formattedValue = (value instanceof String) ? "\"" + value + "\"" : String.valueOf(value);

      joiner.add("\"" + field.getName() + "\":" + formattedValue);
    }

    return joiner.toString();
  }

  public static void main(String[] args) throws IllegalAccessException {
    Student2 student = new Student2("Asha", 21);
    System.out.println(toJson(student));
  }
}
