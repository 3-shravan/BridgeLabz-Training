import java.util.ArrayList;
import java.util.List;

interface Discountable {
  double applyDiscount();

  String getDiscountDetails();
}

abstract class FoodItem {

  // Encapsulation: private fields
  private String itemName;
  protected double price;
  private int quantity;

  public FoodItem(String itemName, double price, int quantity) {
    setItemName(itemName);
    setPrice(price);
    setQuantity(quantity);
  }

  // Abstract method
  public abstract double calculateTotalPrice();

  // Concrete method
  public void getItemDetails(double finalPrice) {
    System.out.println("Item Name     : " + itemName);
    System.out.println("Price         : ₹" + price);
    System.out.println("Quantity      : " + quantity);
    System.out.println("Final Amount  : ₹" + finalPrice);
    System.out.println("--------------------------------");
  }

  // Encapsulation with validation
  public String getItemName() {
    return itemName;
  }

  private void setItemName(String itemName) {
    if (itemName == null || itemName.trim().isEmpty()) {
      throw new IllegalArgumentException("Item name cannot be empty");
    }
    this.itemName = itemName;
  }

  protected void setPrice(double price) {
    if (price <= 0) {
      throw new IllegalArgumentException("Price must be greater than zero");
    }
    this.price = price;
  }

  protected int getQuantity() {
    return quantity;
  }

  private void setQuantity(int quantity) {
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity must be positive");
    }
    this.quantity = quantity;
  }
}

/*
 * Veg food item
 */
class VegItem extends FoodItem implements Discountable {

  public VegItem(String name, double price, int quantity) {
    super(name, price, quantity);
  }

  // No extra charges
  @Override
  public double calculateTotalPrice() {
    return price * getQuantity();
  }

  // 10% discount
  @Override
  public double applyDiscount() {
    return calculateTotalPrice() * 0.10;
  }

  @Override
  public String getDiscountDetails() {
    return "Veg Item Discount: 10%";
  }
}

/*
 * Non-veg food item
 */
class NonVegItem extends FoodItem implements Discountable {

  private static final double NON_VEG_CHARGE = 50; // extra charge per item

  public NonVegItem(String name, double price, int quantity) {
    super(name, price, quantity);
  }

  @Override
  public double calculateTotalPrice() {
    return (price * getQuantity()) + (NON_VEG_CHARGE * getQuantity());
  }

  // 5% discount
  @Override
  public double applyDiscount() {
    return calculateTotalPrice() * 0.05;
  }

  @Override
  public String getDiscountDetails() {
    return "Non-Veg Item Discount: 5%";
  }
}

public class OnlineFoodDeliverySystem {
  public static void main(String[] args) {
    List<FoodItem> order = new ArrayList<>();

    order.add(new VegItem("Paneer Butter Masala", 250, 2));
    order.add(new NonVegItem("Chicken Biryani", 300, 1));

    processOrder(order);
  }

  public static void processOrder(List<FoodItem> items) {

    for (FoodItem item : items) {

      double totalPrice = item.calculateTotalPrice();
      double discount = 0;

      if (item instanceof Discountable) {
        Discountable discountItem = (Discountable) item;
        discount = discountItem.applyDiscount();
        System.out.println(discountItem.getDiscountDetails());
      }

      double finalPrice = totalPrice - discount;

      item.getItemDetails(finalPrice);
    }
  }
}
