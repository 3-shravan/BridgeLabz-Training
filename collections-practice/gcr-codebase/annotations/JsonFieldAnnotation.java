import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.StringJoiner;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
  String name();
}

class User2 {
  @JsonField(name = "user_name")
  String username;

  @JsonField(name = "user_age")
  int age;

  private String password;

  public User2(String username, int age, String password) {
    this.username = username;
    this.age = age;
    this.password = password;
  }
}

class JsonSerializer {
  public static String toJson(Object obj) {
    StringJoiner json = new StringJoiner(", ", "{", "}");
    Arrays.stream(obj.getClass().getDeclaredFields()).filter(f -> f.isAnnotationPresent(JsonField.class))
        .forEach(field -> {
          field.setAccessible(true);
          JsonField annotation = field.getAnnotation(JsonField.class);
          try {
            json.add("\"" + annotation.name() + "\": \"" + field.get(obj) + "\"");
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }

        });
    return json.toString();
  }
}

public class JsonFieldAnnotation {

  public static void main(String[] args) {

    User2 user = new User2("john_doe", 30, "secret");
    String json = JsonSerializer.toJson(user);
    System.out.println(json);
  }

}
