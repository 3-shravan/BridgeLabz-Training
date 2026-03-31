package list;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 2, 3, 4, 4, 5);
    Set<Integer> set = new LinkedHashSet<>(list);
    System.out.println(new ArrayList<>(set));
  }
}
