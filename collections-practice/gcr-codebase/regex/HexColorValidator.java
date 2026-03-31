import java.util.List;
import java.util.regex.Pattern;

public class HexColorValidator {
  private static boolean validateHexColor(String color) {
    String regex = "^[#]\\w{6}$";
    return Pattern.matches(regex, color);
  }

  public static void main(String[] args) {
    List.of("#FFA500", "#ff4500", "#123", "11111").stream()
        .forEach(x -> System.out.println(validateHexColor(x) ? "vaild" : "invalid"));
  }

}
