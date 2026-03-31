import java.util.Arrays;

class Attendee {
  private String name;
  private int age;

  public Attendee(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Attendee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

public class WelcomeAttendee {
  public static void main(String[] args) {
    Arrays.asList(
        new Attendee("Shravan", 23),
        new Attendee("Satyarth", 24),
        new Attendee("Neha", 21)).stream().forEach(a -> System.out.println("Welcome " + a.getName() + " "));
  }
}
