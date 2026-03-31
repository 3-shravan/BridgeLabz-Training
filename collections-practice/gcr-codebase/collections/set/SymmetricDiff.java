package set;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDiff {

  public static void main(String[] args) {

    Set<Integer> s1 = Set.of(1, 2, 3);
    Set<Integer> s2 = Set.of(3, 4, 5);

    Set<Integer> union = new HashSet<>(s1);
    union.addAll(s2);

    Set<Integer> intersection = new HashSet<>(s1);
    intersection.retainAll(s2);

    Set<Integer> diff = new HashSet<>(union);
    diff.removeAll(intersection);

    System.out.println(diff);

  }
}
