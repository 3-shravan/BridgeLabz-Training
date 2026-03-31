import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class InspectClass {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter class name: ");
    String className = scanner.nextLine();

    try {
      Class<?> cls = Class.forName(className);
      System.out.println("Class Name: " + cls.getName());

      // Constructors
      System.out.println("Constructors:----------------------------");
      Constructor<?>[] constructors = cls.getDeclaredConstructors();
      Arrays.stream(constructors)
          .forEach(constructor -> System.out.println(Modifier.toString(constructor.getModifiers()) + " "
              + constructor.getDeclaringClass().getSimpleName() + " " + constructor.getName()));

      // Methods
      System.out.println("Methods:----------------------------");
      Method[] declaredMethods = cls.getDeclaredMethods();
      Arrays.stream(declaredMethods).forEach(method -> System.out.println(Modifier.toString(method.getModifiers()) + " "
          + method.getReturnType().getSimpleName() + " " + method.getName()));

      // Fields
      System.out.println("Fields:----------------------------");
      Field[] declaredFields = cls.getDeclaredFields();
      Arrays.stream(declaredFields).forEach(field -> System.out.println(
          Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName()));

    } catch (ClassNotFoundException e) {
      System.out.println("Class not found: " + e.getMessage());
    } finally {
      scanner.close();
    }

  }
}
