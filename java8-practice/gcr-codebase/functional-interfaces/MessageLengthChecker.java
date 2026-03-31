import java.util.function.Function;

public class MessageLengthChecker {
  private static final int CHAR_LIMIT = 10;

  public static void main(String[] args) {
    String message = "helo world";

    Function<String, Integer> lengthCalculator = msg -> msg.length();
    int length = lengthCalculator.apply(message);
    if (length > CHAR_LIMIT) {
      System.out.println("Message is too long");
    } else {
      System.out.println("Message is within the limit");
    }
  }
}