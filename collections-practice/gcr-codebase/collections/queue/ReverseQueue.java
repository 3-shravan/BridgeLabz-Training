package queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseQueue {

  public static void main(String[] args) {

    Queue<Integer> q = new LinkedList<>(List.of(1, 2, 3, 4, 5));

    reverseQueue(q);
    System.out.println(q);
  }

  private static void reverseQueue(Queue<Integer> q) {
    if (q.isEmpty())
      return;
    int front = q.remove();
    reverseQueue(q);
    q.add(front);
  }

}
