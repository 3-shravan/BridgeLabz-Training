import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LanguageExtractor {

  public static void main(String[] args) {

    String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
    String[] languages = { "Java", "Python", "Go" };

    String regex = "\\b(" + String.join("|", languages) + ")\\b";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
