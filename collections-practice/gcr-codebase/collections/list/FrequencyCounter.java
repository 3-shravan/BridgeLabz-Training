package list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {
  public static void main(String[] args) {
    List<String> list = List.of("apple", "banana", "apple", "orange");

    Map<String, Integer> freqMap = new HashMap<>();
    for (String item : list) {
      freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
    }
    System.out.println(freqMap);
  }
}
