import java.util.Arrays;
import java.util.Comparator;

public class Streaming {
  public static void main(String[] args) {

    String str = "swiss";
    char c = firstNonRepeatingChar(str.toLowerCase());
    System.out.println(c);
    String[] strArray = str.split("");

    String ans = Arrays.stream(strArray).filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch)).findFirst().orElse(null);
    System.out.println(ans);

    String sentence = "India is my Country";
    String[] stn = sentence.split(
        " ");
    Arrays.stream(stn).sorted(Comparator.comparingInt(String::length).reversed()).findFirst()
        .ifPresent(System.out::println);

    Arrays.stream(stn).max(Comparator.comparingInt(String::length)).ifPresent(System.out::println);
  }

  public static Character firstNonRepeatingChar(String s) {
    for (char c : s.toCharArray()) {
      if (s.indexOf(c) == s.lastIndexOf(c)) {
        return c;
      }
    }
    return null;
  }

}