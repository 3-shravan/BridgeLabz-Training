public class Item {
  int itemCode;
  int itemPrice;
  String itemName;

  Item(int code, int price, String name) {
    this.itemCode = code;
    this.itemPrice = price;
    this.itemName = name;
  }

  void displayItemDetails(int quantity) {
    System.out.println("Item Code: " + itemCode);
    System.out.println("Item Price: " + itemPrice);
    System.out.println("Item Name: " + itemName);

  }

  void calculateTotalPrice(int quantity) {
    int totalPrice = itemPrice * quantity;
    System.out.println("Total Price for " + quantity + " " + itemName + "(s): " + totalPrice);
  }

  public static void main(String[] args) {
    Item item1 = new Item(101, 50, "Pen");
    Item item2 = new Item(102, 100, "Notebook");

    int quantity1 = 3;
    int quantity2 = 2;

    item1.displayItemDetails(quantity1);
    item1.calculateTotalPrice(quantity1);

    System.out.println();

    item2.displayItemDetails(quantity2);
    item2.calculateTotalPrice(quantity2);
  }

}
