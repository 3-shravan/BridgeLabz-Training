import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Cart {

  // product -> price
  private Map<String, Double> priceMap = new HashMap<>();
  private Map<String, Double> insertionOrderMap = new LinkedHashMap<>();
  private TreeMap<Double, List<String>> sortedByPriceMap = new TreeMap<>();

  public void addItem(String product, double price) {
    priceMap.put(product, price);
    insertionOrderMap.put(product, price);
    sortedByPriceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
  }

  public void removeItem(String product) {
    Double price = priceMap.remove(product);
    insertionOrderMap.remove(product);
    if (price != null) {
      List<String> productsAtPrice = sortedByPriceMap.get(price);
      if (productsAtPrice != null) {
        productsAtPrice.remove(product);
        if (productsAtPrice.isEmpty()) {
          sortedByPriceMap.remove(price);
        }
      }
    }
  }

  public void displayItemsInOrder() {
    System.out.println("Items in Insertion Order:");
    insertionOrderMap.forEach((k, v) -> System.out.println(k + " -> $" + v));
  }

  public void displayBySortedPrice() {
    sortedByPriceMap.clear();
    for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
      sortedByPriceMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
    }
    System.out.println("\nItems Sorted by Price:");
    sortedByPriceMap.forEach((price, products) -> {
      for (String product : products) {
        System.out.println(product + " -> $" + price);
      }
    });
  }

  public void displayMostExpensiveItem() {
    if (sortedByPriceMap.isEmpty()) {
      System.out.println("\nNo items in the cart.");
      return;
    }
    Double highestPrice = sortedByPriceMap.lastKey();
    List<String> mostExpensiveItems = sortedByPriceMap.get(highestPrice);

    System.out.println("\nMost Expensive Item(s):");
    for (String item : mostExpensiveItems) {
      System.out.println(item + " -> $" + highestPrice);
    }
  }

}

public class ShoppingCart {

  public static void main(String[] args) {
    Cart cart = new Cart();

    cart.addItem("Laptop", 999.99);
    cart.addItem("Smartphone", 499.49);
    cart.addItem("Headphones", 199.99);
    cart.addItem("Monitor", 299.99);
    cart.addItem("Smartwatch", 199.99);

    cart.displayItemsInOrder();
    cart.displayBySortedPrice();
    cart.displayMostExpensiveItem();

    cart.removeItem("Laptop");
    System.out.println("\nAfter removing Laptop:");
    cart.displayItemsInOrder();
    cart.displayBySortedPrice();
    cart.displayMostExpensiveItem();
  }

}
