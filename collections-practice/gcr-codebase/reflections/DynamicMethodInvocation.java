import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }
}

public class DynamicMethodInvocation {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      MathOperations operations = new MathOperations();

      System.out.print("Enter method name (add/subtract/multiply): ");
      String methodName = scanner.nextLine().trim();

      System.out.print("Enter first number: ");
      int a = scanner.nextInt();

      System.out.print("Enter second number: ");
      int b = scanner.nextInt();

      Method method = operations.getClass().getMethod(methodName, int.class, int.class);
      Object result = method.invoke(operations, a, b);

      System.out.println("Result: " + result);
    } catch (NoSuchMethodException e) {
      System.out.println("Invalid method name.");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
