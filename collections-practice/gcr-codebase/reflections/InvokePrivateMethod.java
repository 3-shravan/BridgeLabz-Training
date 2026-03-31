import java.lang.reflect.Method;

// Calculator class with a private multiply method
class Calculator {
  private int multiply(int a, int b) {
    return a * b;
  }
}

public class InvokePrivateMethod {
  public static void main(String[] args) {
    try {
      // Create an instance of Calculator
      Calculator calculator = new Calculator();

      // Get the Class object
      Class<?> calculatorClass = calculator.getClass();

      // Get the private method 'multiply' with int, int parameters
      Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

      // Make the private method accessible
      multiplyMethod.setAccessible(true);

      // Invoke the private method with arguments
      int a = 7;
      int b = 8;
      Object result = multiplyMethod.invoke(calculator, a, b);

      System.out.println("Invoking private method 'multiply' using Reflection");
      System.out.println("Arguments: a = " + a + ", b = " + b);
      System.out.println("Result: " + a + " * " + b + " = " + result);

    } catch (NoSuchMethodException e) {
      System.out.println("Method not found: " + e.getMessage());
    } catch (IllegalAccessException e) {
      System.out.println("Cannot access method: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
