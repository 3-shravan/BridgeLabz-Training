import java.util.ArrayList;
import java.util.List;

interface Category {
  String getName();

  double getMinPrice();

  double getMaxPrice();
}

class BookCategory implements Category {
  public String getName() {
    return "Books";
  }

  public double getMinPrice() {
    return 100;
  }

  public double getMaxPrice() {
    return 2000;
  }
}

class ClothingCategory implements Category {
  public String getName() {
    return "Clothing";
  }

  public double getMinPrice() {
    return 300;
  }

  public double getMaxPrice() {
    return 5000;
  }
}

class GadgetCategory implements Category {
  public String getName() {
    return "Gadgets";
  }

  public double getMinPrice() {
    return 1000;
  }

  public double getMaxPrice() {
    return 100000;
  }
}

class Product<T extends Category> {

  private String name;
  private double price;
  private T category;

  public Product(String name, double price, T category) {
    if (price < category.getMinPrice() || price > category.getMaxPrice()) {
      throw new IllegalArgumentException("Invalid price for category: " + category.getName());
    }
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDetails() {
    return name + " | Category: " + category.getName() + " | Price: ₹" + price;
  }
}

class MarketplaceCatalog {

  private List<Product<?>> products = new ArrayList<>();

  public void addProduct(Product<?> product) {
    products.add(product);
  }

  public void displayAllProducts() {
    for (Product<?> product : products) {
      System.out.println(product.getDetails());
    }
  }
}

class DiscountService {

  public static <T extends Product<?>> void applyDiscount(T product, double percentage) {

    double discount = product.getPrice() * (percentage / 100);
    product.setPrice(product.getPrice() - discount);
  }
}

public class OnlineMarketPlace {

  public static void main(String[] args) {

    Product<BookCategory> book = new Product<>("Java Generics Guide", 1200, new BookCategory());

    Product<ClothingCategory> shirt = new Product<>("Denim Jacket", 2500, new ClothingCategory());

    Product<GadgetCategory> phone = new Product<>("Smartphone", 45000, new GadgetCategory());

    DiscountService.applyDiscount(book, 10);
    DiscountService.applyDiscount(shirt, 20);
    DiscountService.applyDiscount(phone, 5);

    MarketplaceCatalog catalog = new MarketplaceCatalog();
    catalog.addProduct(book);
    catalog.addProduct(shirt);
    catalog.addProduct(phone);

    catalog.displayAllProducts();
  }

}
