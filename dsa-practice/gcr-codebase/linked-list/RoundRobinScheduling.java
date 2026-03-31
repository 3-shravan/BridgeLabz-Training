import java.util.Scanner;

class EmptyQueueException extends RuntimeException {
  public EmptyQueueException(String message) {
    super(message);
  }
}

class ProcessNotFoundException extends RuntimeException {
  public ProcessNotFoundException(String message) {
    super(message);
  }
}

class ProcessNode {
  int pid;
  int burstTime;
  int remainingTime;
  int priority;

  int waitingTime;
  int turnaroundTime;

  ProcessNode next;

  ProcessNode(int pid, int burstTime, int priority) {
    this.pid = pid;
    this.burstTime = burstTime;
    this.remainingTime = burstTime;
    this.priority = priority;
  }
}

class RoundRobinScheduler {
  private ProcessNode head;
  private ProcessNode tail;
  private int timeQuantum;

  void setTimeQuantum(int timeQuantum) {
    if (timeQuantum <= 0) {
      throw new IllegalArgumentException("Time quantum must be > 0");
    }
    this.timeQuantum = timeQuantum;
  }

  void addProcess(int pid, int burstTime, int priority) {
    ProcessNode newNode = new ProcessNode(pid, burstTime, priority);

    if (head == null) {
      head = tail = newNode;
      newNode.next = newNode; // circular
      return;
    }

    tail.next = newNode;
    newNode.next = head;
    tail = newNode;
  }

  private void removeProcess(ProcessNode prev, ProcessNode curr) {
    if (head == tail) {
      head = tail = null;
      return;
    }

    if (curr == head) {
      head = head.next;
      tail.next = head;
    } else if (curr == tail) {
      tail = prev;
      tail.next = head;
    } else {
      prev.next = curr.next;
    }
  }

  void simulateScheduling() {
    if (timeQuantum <= 0) {
      throw new IllegalStateException("Time quantum not set. Please set it before scheduling.");
    }
    if (head == null) {
      throw new EmptyQueueException("No processes to schedule");
    }

    int currentTime = 0;
    int completed = 0;
    int totalWaiting = 0;
    int totalTurnaround = 0;

    ProcessNode curr = head;
    ProcessNode prev = tail;

    while (head != null) {

      if (curr.remainingTime > 0) {

        int executedTime = Math.min(timeQuantum, curr.remainingTime);
        curr.remainingTime -= executedTime;
        currentTime += executedTime;

        // update waiting time for others
        ProcessNode temp = head;
        do {
          if (temp != curr && temp.remainingTime > 0) {
            temp.waitingTime += executedTime;
          }
          temp = temp.next;
        } while (temp != head);

        // process completed
        if (curr.remainingTime == 0) {
          curr.turnaroundTime = currentTime;
          totalWaiting += curr.waitingTime;
          totalTurnaround += curr.turnaroundTime;
          completed++;

          ProcessNode nextProcess = curr.next;
          removeProcess(prev, curr);
          curr = nextProcess;
          continue;
        }
      }

      prev = curr;
      curr = curr.next;
      displayQueue();
    }

    System.out.println("\nAverage Waiting Time: " +
        (double) totalWaiting / completed);

    System.out.println("Average Turnaround Time: " +
        (double) totalTurnaround / completed);
  }

  void displayQueue() {
    if (head == null) {
      System.out.println("Queue empty");
      return;
    }

    System.out.print("Queue: ");
    ProcessNode temp = head;

    do {
      System.out.print(
          "[PID:" + temp.pid +
              ", RT:" + temp.remainingTime + "] -> ");
      temp = temp.next;
    } while (temp != head);

    System.out.println("(back to head)");
  }

}

public class RoundRobinScheduling {

  private static void printMenu() {
    System.out.println("\n==== Round Robin Scheduling ====");
    System.out.println("1. Set time quantum");
    System.out.println("2. Add process");
    System.out.println("3. Display queue");
    System.out.println("4. Run scheduling simulation");
    System.out.println("0. Exit");
  }

  private static int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid integer.");
      }
    }
  }

  public static void main(String[] args) {
    RoundRobinScheduler scheduler = new RoundRobinScheduler();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printMenu();
      int choice = readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            int tq = readInt(scanner, "Enter time quantum: ");
            scheduler.setTimeQuantum(tq);
            System.out.println("Time quantum set to " + tq);
            break;
          }
          case 2: {
            int pid = readInt(scanner, "Enter PID: ");
            int burst = readInt(scanner, "Enter burst time: ");
            int priority = readInt(scanner, "Enter priority: ");
            scheduler.addProcess(pid, burst, priority);
            System.out.println("Process added.");
            break;
          }
          case 3: {
            scheduler.displayQueue();
            break;
          }
          case 4: {
            scheduler.simulateScheduling();
            System.out.println("Simulation complete.");
            break;
          }
          case 0: {
            System.out.println("Exiting...");
            scanner.close();
            return;
          }
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (RuntimeException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }

}
