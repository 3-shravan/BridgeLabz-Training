package set;

import java.util.Set;

public class IsEqualSet {
  public static void main(String[] args) {
    Set<Integer> s1 = Set.of(1, 2, 3);
    Set<Integer> s2 = Set.of(3, 2, 1);
    System.out.println(s1.equals(s2));

  }

}
