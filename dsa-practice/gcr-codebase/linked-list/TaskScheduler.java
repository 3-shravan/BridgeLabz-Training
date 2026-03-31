import java.util.Scanner;

class TaskNode {
  int taskId;
  String taskName;
  int priority;
  String dueDate;

  TaskNode next;

  TaskNode(int taskId, String taskName, int priority, String dueDate) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.priority = priority;
    this.dueDate = dueDate;
  }
}

class TaskSchedulerList {
  private TaskNode head;
  private TaskNode tail;
  private TaskNode currentTask;

  void addAtBeginning(int id, String name, int priority, String dueDate) {
    TaskNode newNode = new TaskNode(id, name, priority, dueDate);

    if (head == null) {
      head = tail = currentTask = newNode;
      newNode.next = newNode; // circular
      return;
    }

    newNode.next = head;
    head = newNode;
    tail.next = head;
  }

  void addAtEnd(int id, String name, int priority, String dueDate) {
    TaskNode newNode = new TaskNode(id, name, priority, dueDate);

    if (head == null) {
      addAtBeginning(id, name, priority, dueDate);
      return;
    }

    tail.next = newNode;
    newNode.next = head;
    tail = newNode;
  }

  void addAtPosition(int position, int id, String name, int priority, String dueDate) {
    if (position < 0) {
      throw new InvalidPositionException("Position cannot be negative");
    }

    if (position == 0) {
      addAtBeginning(id, name, priority, dueDate);
      return;
    }

    if (head == null) {
      throw new EmptyListException("Task list is empty");
    }

    TaskNode temp = head;
    for (int i = 1; i < position; i++) {
      temp = temp.next;
      if (temp == head) {
        throw new InvalidPositionException("Position out of bounds");
      }
    }

    TaskNode newNode = new TaskNode(id, name, priority, dueDate);
    newNode.next = temp.next;
    temp.next = newNode;

    if (temp == tail) {
      tail = newNode;
    }
  }

  void removeByTaskId(int taskId) {
    if (head == null) {
      throw new EmptyListException("Task list is empty");
    }

    TaskNode curr = head;
    TaskNode prev = tail;

    do {
      if (curr.taskId == taskId) {

        // single node case
        if (head == tail) {
          head = tail = currentTask = null;
          return;
        }

        prev.next = curr.next;

        if (curr == head)
          head = curr.next;
        if (curr == tail)
          tail = prev;
        if (curr == currentTask)
          currentTask = curr.next;

        return;
      }
      prev = curr;
      curr = curr.next;
    } while (curr != head);

    throw new NotFoundException("Task not found: " + taskId);
  }

  void viewAndMoveToNextTask() {
    if (currentTask == null) {
      throw new EmptyListException("No tasks available");
    }

    printTask(currentTask);
    currentTask = currentTask.next; // circular move
  }

  void displayAllTasks() {
    if (head == null) {
      throw new EmptyListException("No tasks to display");
    }

    TaskNode temp = head;
    do {
      printTask(temp);
      temp = temp.next;
    } while (temp != head);
  }

  void searchByPriority(int priority) {
    if (head == null) {
      throw new EmptyListException("Task list is empty");
    }

    TaskNode temp = head;
    boolean found = false;

    do {
      if (temp.priority == priority) {
        printTask(temp);
        found = true;
      }
      temp = temp.next;
    } while (temp != head);

    if (!found) {
      throw new NotFoundException(
          "No task found with priority " + priority);
    }
  }

  private void printTask(TaskNode t) {
    System.out.println(
        "TaskID: " + t.taskId +
            ", Name: " + t.taskName +
            ", Priority: " + t.priority +
            ", Due: " + t.dueDate);
  }

}

public class TaskScheduler {

  private static void printMenu() {
    System.out.println("\n==== Task Scheduler ====");
    System.out.println("1. Add task (beginning)");
    System.out.println("2. Add task (end)");
    System.out.println("3. Add task (at position)");
    System.out.println("4. Remove task (by taskId)");
    System.out.println("5. View current task (move next)");
    System.out.println("6. Display all tasks");
    System.out.println("7. Search tasks (by priority)");
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

  private static String readNonEmptyString(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Input cannot be empty.");
    }
  }

  public static void main(String[] args) {
    TaskSchedulerList taskList = new TaskSchedulerList();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printMenu();
      int choice = readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            int id = readInt(scanner, "Enter task ID: ");
            String name = readNonEmptyString(scanner, "Enter task name: ");
            int priority = readInt(scanner, "Enter priority: ");
            String dueDate = readNonEmptyString(scanner, "Enter due date: ");
            taskList.addAtBeginning(id, name, priority, dueDate);
            System.out.println("Task added at beginning.");
            break;
          }
          case 2: {
            int id = readInt(scanner, "Enter task ID: ");
            String name = readNonEmptyString(scanner, "Enter task name: ");
            int priority = readInt(scanner, "Enter priority: ");
            String dueDate = readNonEmptyString(scanner, "Enter due date: ");
            taskList.addAtEnd(id, name, priority, dueDate);
            System.out.println("Task added at end.");
            break;
          }
          case 3: {
            int position = readInt(scanner, "Enter position (0-based): ");
            int id = readInt(scanner, "Enter task ID: ");
            String name = readNonEmptyString(scanner, "Enter task name: ");
            int priority = readInt(scanner, "Enter priority: ");
            String dueDate = readNonEmptyString(scanner, "Enter due date: ");
            taskList.addAtPosition(position, id, name, priority, dueDate);
            System.out.println("Task added at position " + position + ".");
            break;
          }
          case 4: {
            int id = readInt(scanner, "Enter task ID to remove: ");
            taskList.removeByTaskId(id);
            System.out.println("Task removed.");
            break;
          }
          case 5: {
            taskList.viewAndMoveToNextTask();
            break;
          }
          case 6: {
            taskList.displayAllTasks();
            break;
          }
          case 7: {
            int priority = readInt(scanner, "Enter priority to search: ");
            taskList.searchByPriority(priority);
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
