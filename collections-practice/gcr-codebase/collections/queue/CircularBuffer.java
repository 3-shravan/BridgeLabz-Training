package queue;

import java.util.Arrays;

public class CircularBuffer {
  private int[] buffer;
  private int size;
  private int front;
  private int rear;
  private int count;

  public CircularBuffer(int capacity) {
    buffer = new int[capacity];
    size = capacity;
    front = 0;
    rear = 0;
    count = 0;
  }

  public void insert(int value) {
    if (count == size) {
      front = (front + 1) % size;
      count--;
    }
    buffer[rear] = value;
    rear = (rear + 1) % size;
    count++;
  }

  public void display() {
    int[] result = new int[count];
    for (int i = 0; i < count; i++) {
      result[i] = buffer[(front + i) % size];
    }
    System.out.println(Arrays.toString(result));
  }

  public static void main(String[] args) {

    CircularBuffer cb = new CircularBuffer(3);

    cb.insert(1);
    cb.insert(2);
    cb.insert(3);
    cb.display();

    cb.insert(4);
    cb.display();
  }
}
