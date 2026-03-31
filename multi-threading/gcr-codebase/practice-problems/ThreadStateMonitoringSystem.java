import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TaskRunner extends Thread {
  public TaskRunner(String name) {
    super(name);
  }

  @Override
  public void run() {
    // RUNNABLE (doing computation)
    long sum = 0;
    for (int i = 0; i < 1_000_000; i++) {
      sum += i;
    }

    try {
      Thread.sleep(2000); // TIMED_WAITING
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    // RUNNABLE again (post-sleep computation)
    for (int i = 0; i < 500_000; i++) {
      sum += i;
    }

  }
}

class StateMonitor extends Thread {
  private final Thread[] threads;
  private final Map<String, Set<Thread.State>> stateHistory = new HashMap<>();

  public StateMonitor(Thread... threads) {
    this.threads = threads;
  }

  @Override
  public void run() {
    boolean allTerminated = false;
    while (!allTerminated) {
      allTerminated = true;
      for (Thread t : threads) {
        Thread.State state = t.getState();
        stateHistory.computeIfAbsent(t.getName(), k -> new HashSet<>())
            .add(state);

        System.out.println("[Monitor] " + t.getName() +
            " is in " + state +
            " state at " + LocalTime.now());
        if (state != Thread.State.TERMINATED) {
          allTerminated = false;
        }

      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    printSummary();

  }

  private void printSummary() {
    System.out.println("\nSummary:");
    for (Map.Entry<String, Set<Thread.State>> entry : stateHistory.entrySet()) {
      System.out.println(entry.getKey() +
          " went through " + entry.getValue().size() +
          " states -> " + entry.getValue());
    }
  }
}

public class ThreadStateMonitoringSystem {

  public static void main(String[] args) {
    TaskRunner task1 = new TaskRunner("Task-1");
    TaskRunner task2 = new TaskRunner("Task-2");

    StateMonitor monitor = new StateMonitor(task1, task2);

    monitor.start();
    task1.start();
    task2.start();
  }
}
