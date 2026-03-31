import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SSNValidator {

    public static void main(String[] args) {

        String text = "My SSN is 123-45-6789.";

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println(matcher.group() + " is valid");
        } else {
            System.out.println("Invalid SSN");
        }

        System.out.println("123-45-6789".matches("^\\d{3}-\\d{2}-\\d{4}$"));
        System.out.println("123456789".matches("^\\d{3}-\\d{2}-\\d{4}$"));
    }
}
