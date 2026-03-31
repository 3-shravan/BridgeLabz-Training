package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 1);
    Map<Integer, List<String>> invertedMap = new HashMap<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
    }

    System.out.println(invertedMap);

  }

}
