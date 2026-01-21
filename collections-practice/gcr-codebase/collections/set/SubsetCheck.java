package set;

import java.util.Set;

public class SubsetCheck {
  public static void main(String[] args) {
    Set<Integer> s1 = Set.of(3);
    Set<Integer> s2 = Set.of(3, 4, 5);
    boolean isSubset = s2.containsAll(s1);
    System.out.println("Is s1 a subset of s2? " + isSubset);
  }
}
