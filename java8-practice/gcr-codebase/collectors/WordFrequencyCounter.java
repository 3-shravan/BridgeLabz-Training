
import java.util.Arrays;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
  public static void main(String[] args) {
    String paragraph = "This is a sample paragraph. This paragraph is just a sample.";
    Arrays.stream(paragraph.toLowerCase().split("\\W+"))
        .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
        .forEach((word, count) -> System.out.println("Word: " + word + ", Count: " + count));

  }
}