package list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NthFromEnd {

  public static void main(String[] args) {

    LinkedList<String> list = new LinkedList<>(List.of("A", "B", "C", "D", "E", "F"));

    Iterator<String> fast = list.iterator();
    Iterator<String> slow = list.iterator();

    int n = 2;

    for (int i = 0; i < n; i++) {
      if (fast.hasNext()) {
        fast.next();
      }
    }
    while (fast.hasNext()) {
      fast.next();
      slow.next();
    }

    System.out.println("The " + n + "nd element from the end is: " + slow.next());
  }
}
