package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
  Queue<Integer> queue1 = new LinkedList<>();
  Queue<Integer> queue2 = new LinkedList<>();

  void push(int x) {

    queue2.add(x);
    while (!queue1.isEmpty())
      queue2.add(queue1.poll());
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
  }

  void pop() {
    if (!queue1.isEmpty()) {
      queue1.poll();
    }
  }

  public static void main(String[] args) {
    StackWithTwoQueues stack = new StackWithTwoQueues();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.pop();
    System.out.println(stack.queue1);
  }

}
