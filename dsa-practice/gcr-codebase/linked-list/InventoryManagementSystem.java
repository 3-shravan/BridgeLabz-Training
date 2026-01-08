import java.util.Scanner;

class EmptyInventoryException extends RuntimeException {
  public EmptyInventoryException(String message) {
    super(message);
  }
}

class ItemNotFoundException extends RuntimeException {
  public ItemNotFoundException(String message) {
    super(message);
  }
}

class InvalidPositionException extends RuntimeException {
  public InvalidPositionException(String message) {
    super(message);
  }
}

class ItemNode {
  int itemId;
  String itemName;
  int quantity;
  double price;

  ItemNode next;

  ItemNode(int itemId, String itemName, int quantity, double price) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.quantity = quantity;
    this.price = price;
  }
}

class InventoryLinkedList {
  private ItemNode head;

  void addAtBeginning(int id, String name, int qty, double price) {
    ItemNode newNode = new ItemNode(id, name, qty, price);
    newNode.next = head;
    head = newNode;
  }

  void addAtEnd(int id, String name, int qty, double price) {
    ItemNode newNode = new ItemNode(id, name, qty, price);

    if (head == null) {
      head = newNode;
      return;
    }

    ItemNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
  }

  void addAtPosition(int position, int id, String name, int qty, double price) {
    if (position < 0) {
      throw new InvalidPositionException("Position cannot be negative");
    }

    if (position == 0) {
      addAtBeginning(id, name, qty, price);
      return;
    }

    if (head == null) {
      throw new EmptyInventoryException("Inventory is empty");
    }

    ItemNode temp = head;
    for (int i = 1; i < position; i++) {
      if (temp.next == null) {
        throw new InvalidPositionException("Position out of bounds");
      }
      temp = temp.next;
    }

    ItemNode newNode = new ItemNode(id, name, qty, price);
    newNode.next = temp.next;
    temp.next = newNode;
  }

  void removeByItemId(int itemId) {
    if (head == null) {
      throw new EmptyInventoryException("Inventory is empty");
    }

    if (head.itemId == itemId) {
      head = head.next;
      return;
    }

    ItemNode curr = head;
    ItemNode prev = null;

    while (curr != null && curr.itemId != itemId) {
      prev = curr;
      curr = curr.next;
    }

    if (curr == null) {
      throw new ItemNotFoundException("Item not found: " + itemId);
    }

    prev.next = curr.next;
    curr.next = null;
  }

  void updateQuantity(int itemId, int newQty) {
    ItemNode item = searchById(itemId);
    item.quantity = newQty;
  }

  ItemNode searchById(int itemId) {
    if (head == null) {
      throw new EmptyInventoryException("Inventory is empty");
    }

    ItemNode temp = head;
    while (temp != null) {
      if (temp.itemId == itemId) {
        return temp;
      }
      temp = temp.next;
    }

    throw new ItemNotFoundException("Item not found: " + itemId);
  }

  void searchByName(String name) {
    if (head == null) {
      throw new EmptyInventoryException("Inventory is empty");
    }

    ItemNode temp = head;
    boolean found = false;

    while (temp != null) {
      if (temp.itemName.equalsIgnoreCase(name)) {
        printItem(temp);
        found = true;
      }
      temp = temp.next;
    }

    if (!found) {
      throw new ItemNotFoundException("Item not found: " + name);
    }
  }

  double calculateTotalValue() {
    if (head == null) {
      throw new EmptyInventoryException("Inventory is empty");
    }

    double total = 0;
    ItemNode temp = head;

    while (temp != null) {
      total += temp.price * temp.quantity;
      temp = temp.next;
    }

    return total;
  }

  void sortByName(boolean ascending) {
    head = mergeSort(head, (a, b) -> ascending
        ? a.itemName.compareToIgnoreCase(b.itemName)
        : b.itemName.compareToIgnoreCase(a.itemName));
  }

  void sortByPrice(boolean ascending) {
    head = mergeSort(head, (a, b) -> ascending
        ? Double.compare(a.price, b.price)
        : Double.compare(b.price, a.price));
  }

  private ItemNode mergeSort(ItemNode node, java.util.Comparator<ItemNode> cmp) {
    if (node == null || node.next == null)
      return node;

    ItemNode mid = getMiddle(node);
    ItemNode nextOfMid = mid.next;
    mid.next = null;

    ItemNode left = mergeSort(node, cmp);
    ItemNode right = mergeSort(nextOfMid, cmp);

    return sortedMerge(left, right, cmp);
  }

  private ItemNode sortedMerge(ItemNode a, ItemNode b, java.util.Comparator<ItemNode> cmp) {
    if (a == null)
      return b;
    if (b == null)
      return a;

    ItemNode result;
    if (cmp.compare(a, b) <= 0) {
      result = a;
      result.next = sortedMerge(a.next, b, cmp);
    } else {
      result = b;
      result.next = sortedMerge(a, b.next, cmp);
    }
    return result;
  }

  private ItemNode getMiddle(ItemNode head) {
    ItemNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  void displayAll() {
    if (head == null) {
      throw new EmptyInventoryException("No items in inventory");
    }

    ItemNode temp = head;
    while (temp != null) {
      printItem(temp);
      temp = temp.next;
    }
  }

  private void printItem(ItemNode i) {
    System.out.println(
        "ID: " + i.itemId +
            ", Name: " + i.itemName +
            ", Qty: " + i.quantity +
            ", Price: " + i.price);
  }

}

class Input {

  int readInt(Scanner scanner, String prompt) {
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

  double readDouble(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      try {
        return Double.parseDouble(input);
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
  }

  String readNonEmptyString(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Input cannot be empty.");
    }
  }

  boolean readAscending(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim().toLowerCase();
      if (input.equals("asc") || input.equals("a") || input.equals("ascending")) {
        return true;
      }
      if (input.equals("desc") || input.equals("d") || input.equals("descending")) {
        return false;
      }
      System.out.println("Please enter 'asc' or 'desc'.");
    }
  }
}

public class InventoryManagementSystem {

  private static void printMenu() {
    System.out.println("\n==== Inventory Management System ====");
    System.out.println("1. Add item (beginning)");
    System.out.println("2. Add item (end)");
    System.out.println("3. Add item (at position)");
    System.out.println("4. Remove item (by itemId)");
    System.out.println("5. Search item (by itemId)");
    System.out.println("6. Search item (by name)");
    System.out.println("7. Update quantity (by itemId)");
    System.out.println("8. Display all items");
    System.out.println("9. Calculate total inventory value");
    System.out.println("10. Sort by name (asc/desc)");
    System.out.println("11. Sort by price (asc/desc)");
    System.out.println("0. Exit");
  }

  public static void main(String[] args) {
    InventoryLinkedList inventory = new InventoryLinkedList();
    Scanner scanner = new Scanner(System.in);
    Input input = new Input();

    while (true) {
      printMenu();
      int choice = input.readInt(scanner, "Enter your choice: ");
      try {
        switch (choice) {
          case 1: {
            System.out.println("Adding item at beginning:");
            int id = input.readInt(scanner, "Enter item ID: ");
            String name = input.readNonEmptyString(scanner, "Enter item name: ");
            int qty = input.readInt(scanner, "Enter quantity: ");
            double price = input.readDouble(scanner, "Enter price: ");
            inventory.addAtBeginning(id, name, qty, price);
            System.out.println("Item added at beginning.");
            break;
          }
          case 2: {
            int id = input.readInt(scanner, "Enter item ID: ");
            String name = input.readNonEmptyString(scanner, "Enter item name: ");
            int qty = input.readInt(scanner, "Enter quantity: ");
            double price = input.readDouble(scanner, "Enter price: ");
            inventory.addAtEnd(id, name, qty, price);
            System.out.println("Item added at end.");
            break;
          }
          case 3: {
            int position = input.readInt(scanner, "Enter position (0-based): ");
            int id = input.readInt(scanner, "Enter item ID: ");
            String name = input.readNonEmptyString(scanner, "Enter item name: ");
            int qty = input.readInt(scanner, "Enter quantity: ");
            double price = input.readDouble(scanner, "Enter price: ");
            inventory.addAtPosition(position, id, name, qty, price);
            System.out.println("Item added at position " + position + ".");
            break;
          }
          case 4: {
            int id = input.readInt(scanner, "Enter item ID to remove: ");
            inventory.removeByItemId(id);
            System.out.println("Item removed.");
            break;
          }
          case 5: {
            int id = input.readInt(scanner, "Enter item ID to search: ");
            ItemNode item = inventory.searchById(id);
            System.out.println(
                "ID: " + item.itemId + ", Name: " + item.itemName + ", Qty: " + item.quantity + ", Price: "
                    + item.price);
            break;
          }
          case 6: {
            String name = input.readNonEmptyString(scanner, "Enter item name to search: ");
            inventory.searchByName(name);
            break;
          }
          case 7: {
            int id = input.readInt(scanner, "Enter item ID to update quantity: ");
            int qty = input.readInt(scanner, "Enter new quantity: ");
            inventory.updateQuantity(id, qty);
            System.out.println("Quantity updated.");
            break;
          }
          case 8: {
            inventory.displayAll();
            break;
          }
          case 9: {
            double total = inventory.calculateTotalValue();
            System.out.println("Total inventory value: " + total);
            break;
          }
          case 10: {
            boolean asc = input.readAscending(scanner, "Sort by name (asc/desc): ");
            inventory.sortByName(asc);
            System.out.println("Sorted by name " + (asc ? "ascending" : "descending") + ".");
            break;
          }
          case 11: {
            boolean asc = input.readAscending(scanner, "Sort by price (asc/desc): ");
            inventory.sortByPrice(asc);
            System.out.println("Sorted by price " + (asc ? "ascending" : "descending") + ".");
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
