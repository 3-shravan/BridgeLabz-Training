import java.util.LinkedList;
import java.util.Queue;

public class TrafficManager {

  static class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
      this.number = number;
      this.next = null;
    }
  }

  static class Roundabout {
    private Vehicle head;

    public void addVehicle(String number) {
      Vehicle newVehicle = new Vehicle(number);
      if (head == null) {
        head = newVehicle;
        newVehicle.next = head;
      } else {
        Vehicle temp = head;
        while (temp.next != head) {
          temp = temp.next;
        }
        temp.next = newVehicle;
        newVehicle.next = head;
      }

      System.out.println("Vehicle " + number + " added to the roundabout.");
    }

    public void removeVehicle(String number) {
      if (head == null) {
        System.out.println("No vehicles in the roundabout.");
        return;
      }
      Vehicle current = head;
      Vehicle previous = null;

      do {
        if (current.number.equals(number)) {
          if (previous != null) {
            previous.next = current.next;
          } else {
            Vehicle temp = head;
            while (temp.next != head) {
              temp = temp.next;
            }
            head = head.next;
            temp.next = head;
          }
          System.out.println("Vehicle " + number + " removed from the roundabout.");
          return;
        }
        previous = current;
        current = current.next;
      } while (current != head);
      System.out.println("Vehicle " + number + " not found in the roundabout.");
    }

    public void printVehicles() {
      if (head == null) {
        System.out.println("No vehicles in the roundabout.");
        return;
      }
      Vehicle temp = head;
      System.out.print("Vehicles in the roundabout: ");
      do {
        System.out.print(temp.number + " ");
        temp = temp.next;
      } while (temp != head);
      System.out.println();
    }

  }

  static class WaitingQueue {
    private final int capacity;
    private final Queue<Vehicle> queue = new LinkedList<>();

    WaitingQueue(int capacity) {
      this.capacity = capacity;
    }

    void enqueue(String number) {
      if (queue.size() == capacity)
        throw new RuntimeException("Queue Overflow");
      queue.add(new Vehicle(number));
    }

    void dequeue() {
      if (queue.isEmpty())
        throw new RuntimeException("Queue Underflow");
      queue.poll();
    }

  }

  public static void main(String[] args) {
    Roundabout roundabout = new Roundabout();
    WaitingQueue waitingQueue = new WaitingQueue(5);

    roundabout.addVehicle("KA-01-HH-1234");
    roundabout.addVehicle("KA-01-HH-9999");
    roundabout.printVehicles();

    roundabout.removeVehicle("KA-01-HH-1234");
    roundabout.printVehicles();

    waitingQueue.enqueue("KA-01-HH-5678");
    waitingQueue.enqueue("KA-01-HH-0001");
    waitingQueue.dequeue();
  }

}
