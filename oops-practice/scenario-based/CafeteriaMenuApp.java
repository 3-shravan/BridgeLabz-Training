import java.util.Scanner;

public class CafeteriaMenuApp {

  public static void main(String[] args) {

    String[] menuItems = {
        "Idli", "Dosa", "Poha", "Sandwich", "Burger",
        "Pasta", "Fried Rice", "Noodles", "Coffee", "Tea"
    };

    Scanner sc = new Scanner(System.in);

    displayMenu(menuItems);

    System.out.print("\nEnter item index to order: ");
    int choice = sc.nextInt();

    String selectedItem = getItemByIndex(menuItems, choice);
    System.out.println("You selected: " + selectedItem);

    sc.close();
  }

  public static void displayMenu(String[] menuItems) {
    System.out.println(" Cafeteria Menu:");
    for (int i = 0; i < menuItems.length; i++) {
      System.out.println(i + " - " + menuItems[i]);
    }
  }

  public static String getItemByIndex(String[] menuItems, int index) {
    if (index >= 0 && index < menuItems.length) {
      return menuItems[index];
    } else {
      return "Invalid item index!";
    }
  }
}
