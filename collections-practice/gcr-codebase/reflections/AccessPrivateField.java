import java.lang.reflect.Field;

class Person {
  private int age;
}

public class AccessPrivateField {
  public static void main(String[] args) throws Exception {
    Person p = new Person();

    Field ageField = Person.class.getDeclaredField("age");
    ageField.setAccessible(true);

    ageField.set(p, 25);

    System.out.println("Age: " + ageField.get(p));
  }
}
