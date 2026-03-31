
import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
  private String name;

  public WarehouseItem(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract String getCategory();
}

class Electronics extends WarehouseItem {
  public Electronics(String name) {
    super(name);
  }

  @Override
  public String getCategory() {
    return "Electronics";
  }
}

class Groceries extends WarehouseItem {
  public Groceries(String name) {
    super(name);
  }

  @Override
  public String getCategory() {
    return "Groceries";
  }
}

class Furniture extends WarehouseItem {
  public Furniture(String name) {
    super(name);
  }

  @Override
  public String getCategory() {
    return "Furniture";
  }
}

class Storage<T extends WarehouseItem> {

  private List<T> items = new ArrayList<>();

  public void addItem(T item) {
    items.add(item);
  }

  public T getItem(int index) {
    return items.get(index);
  }

  public List<T> getItems() {
    return items;
  }
}

class WarehouseUtil {

  public static void displayItems(List<? extends WarehouseItem> items) {
    for (WarehouseItem item : items) {
      System.out.println("Item: " + item.getName() + ", Category: " + item.getCategory());
    }
  }
}

public class WarehouseManagementSystem {

  public static void main(String[] args) {

    Storage<Electronics> electronicsStorage = new Storage<>();
    electronicsStorage.addItem(new Electronics("Laptop"));
    electronicsStorage.addItem(new Electronics("Smartphone"));

    Storage<Groceries> groceryStorage = new Storage<>();
    groceryStorage.addItem(new Groceries("Rice"));
    groceryStorage.addItem(new Groceries("Milk"));

    Storage<Furniture> furnitureStorage = new Storage<>();
    furnitureStorage.addItem(new Furniture("Chair"));

    System.out.println("---- Electronics ----");
    WarehouseUtil.displayItems(electronicsStorage.getItems());

    System.out.println("\n---- Groceries ----");
    WarehouseUtil.displayItems(groceryStorage.getItems());

    System.out.println("\n---- Furniture ----");
    WarehouseUtil.displayItems(furnitureStorage.getItems());
  }

}
