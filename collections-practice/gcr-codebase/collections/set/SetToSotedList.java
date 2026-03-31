package set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SetToSotedList {

  public static void main(String[] args) {
    Set<Integer> set = Set.of(5, 3, 9, 1);
    List<Integer> list = new ArrayList<>(set);
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
  }

}
