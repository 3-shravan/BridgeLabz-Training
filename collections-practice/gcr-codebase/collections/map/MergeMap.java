package map;

import java.util.HashMap;
import java.util.Map;

public class MergeMap {
  public static void main(String[] args) {
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("A", 1);
    map1.put("B", 2);
    map1.put("C", 3);

    Map<String, Integer> map2 = new HashMap<>();
    map2.put("B", 4);
    map2.put("E", 5);
    map2.put("F", 6);

    Map<String, Integer> mergedMap = new HashMap<>(map1);
    for (Map.Entry<String, Integer> entry : map2.entrySet()) {
      mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
    }
    System.out.println(mergedMap);
  }

}