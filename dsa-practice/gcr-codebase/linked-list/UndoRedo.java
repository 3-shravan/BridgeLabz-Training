import java.util.Scanner;

class NoUndoException extends RuntimeException {
  public NoUndoException(String message) {
    super(message);
  }
}

class NoRedoException extends RuntimeException {
  public NoRedoException(String message) {
    super(message);
  }
}

class TextState {
  String content;
  TextState prev;
  TextState next;

  TextState(String content) {
    this.content = content;
  }
}

class TextEditor {
  private TextState head;
  private TextState tail;
  private TextState current;

  private int size = 0;
  private final int MAX_HISTORY = 10;

  void addState(String content) {
    TextState newState = new TextState(content);

    // If we undo and then type → discard redo history
    if (current != null && current.next != null) {
      current.next.prev = null;
      current.next = null;
      tail = current;
      size = countNodes();
    }

    if (head == null) {
      head = tail = current = newState;
      size = 1;
      return;
    }

    tail.next = newState;
    newState.prev = tail;
    tail = newState;
    current = newState;
    size++;

    // Maintain fixed history size
    if (size > MAX_HISTORY) {
      head = head.next;
      head.prev = null;
      size--;
    }
  }

  void undo() {
    if (current == null || current.prev == null) {
      throw new NoUndoException("Nothing to undo");
    }
    current = current.prev;
  }

  void redo() {
    if (current == null || current.next == null) {
      throw new NoRedoException("Nothing to redo");
    }
    current = current.next;
  }

  void displayCurrentState() {
    if (current == null) {
      System.out.println("Editor is empty");
    } else {
      System.out.println("Current Text: " + current.content);
    }
  }

  void displayHistory() {
    if (head == null) {
      System.out.println("No history available");
      return;
    }

    System.out.println("\n--- History (oldest to newest) ---");
    int index = 0;
    TextState temp = head;
    while (temp != null) {
      String marker = (temp == current) ? " <-- current" : "";
      System.out.println(index + ": " + temp.content + marker);
      temp = temp.next;
      index++;
    }
  }

  private int countNodes() {
    int count = 0;
    TextState temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

}

public class UndoRedo {

  private static void printMenu() {
    System.out.println("\n==== Text Editor (Undo/Redo) ====");
    System.out.println("1. Type/Set text (creates new state)");
    System.out.println("2. Undo");
    System.out.println("3. Redo");
    System.out.println("4. Show current text");
    System.out.println("5. Show history");
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

  private static String readLine(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printMenu();
      int choice = readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            String text = readLine(scanner, "Enter text (can be empty): ");
            editor.addState(text);
            System.out.println("State saved.");
            editor.displayCurrentState();
            break;
          }
          case 2: {
            editor.undo();
            System.out.println("Undo successful.");
            editor.displayCurrentState();
            break;
          }
          case 3: {
            editor.redo();
            System.out.println("Redo successful.");
            editor.displayCurrentState();
            break;
          }
          case 4: {
            editor.displayCurrentState();
            break;
          }
          case 5: {
            editor.displayHistory();
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
