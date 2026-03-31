package set;

import java.util.HashSet;
import java.util.Set;

public class UnionAndInterection {
  public static void main(String[] args) {

    Set<Integer> s1 = Set.of(1, 2, 3);
    Set<Integer> s2 = Set.of(3, 4, 5);

    Set<Integer> union = new HashSet<>(s1);
    union.addAll(s2);

    Set<Integer> interection = new HashSet<>(s1);
    interection.retainAll(s2);

    System.out.println("Union: " + union);
    System.out.println("Interection: " + interection);
  }
}
