import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
  int value();
}

class User {
  @MaxLength(10)
  String username;

  public User(String username) {
    Arrays.stream(this.getClass().getDeclaredFields()).filter(f -> f.isAnnotationPresent(MaxLength.class))
        .forEach(f -> {
          MaxLength maxLength = f.getAnnotation(MaxLength.class);
          if (username.length() > maxLength.value()) {
            throw new IllegalArgumentException(
                "Field " + f.getName() + " exceeds maximum length of " + maxLength.value());
          }

        });

    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}

public class MaxLengthAnnotation {

  public static void main(String[] args) {

    User user1 = new User("Shravan");
    System.out.println("User created: " + user1.getUsername());

    User user2 = new User("VeryLongUsername");
    System.out.println("User created: " + user2.getUsername());
  }

}
