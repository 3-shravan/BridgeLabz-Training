package map;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounterMap {

  public static void main(String[] args) {
    String text = "hello world hello everyone";
    Map<String, Integer> frequencyMap = new HashMap<>();
    for (String word : text.toLowerCase().split("\\s+")) {
      frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
    }
    System.out.println(frequencyMap);
  }

}
