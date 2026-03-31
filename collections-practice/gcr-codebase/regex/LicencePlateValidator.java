import java.util.Arrays;
import java.util.regex.Pattern;

public class LicencePlateValidator {
  private static boolean licensePlateValidator(String license) {
    String regex = "^[A-Z][A-Z]\\d{4}$";
    return Pattern.matches(regex, license);
  }

  public static void main(String[] args) {
    String[] licensePlates = { "AB1234", "A12345" };
    Arrays.stream(licensePlates)
        .forEach(x -> System.out.println(x + " → " + (licensePlateValidator(x) ? "Valid" : "Invalid")));
  }

}
