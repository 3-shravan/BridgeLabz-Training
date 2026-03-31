package map;

import java.util.HashMap;
import java.util.Map;

public class MaxKey {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 10);
    map.put("b", 20);
    map.put("c", 5);

    int max = Integer.MIN_VALUE;
    String keyWithMaxValue = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        keyWithMaxValue = entry.getKey();
      }
    }
    System.out.println("Key with max value: " + keyWithMaxValue);
  }
}
