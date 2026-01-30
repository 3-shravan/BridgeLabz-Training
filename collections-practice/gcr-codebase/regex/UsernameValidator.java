import java.util.Arrays;
import java.util.regex.Pattern;

public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z]\\w{4,14}$";
        return Pattern.matches(regex, username);
    }

    public static void main(String[] args) {
        String[] testUsernames = { "user_123", "123user", "us", "Valid_User1", "user@123" };
        Arrays.stream(testUsernames).forEach(x -> System.out.println(isValidUsername(x) ? "Valid" : "Invalid"));
    }
}
