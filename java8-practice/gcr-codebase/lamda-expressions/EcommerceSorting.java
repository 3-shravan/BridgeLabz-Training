import java.util.ArrayList;
import java.util.List;

class Product {
  String name;
  double price;
  double rating;
  int discount;

  Product(String name, double price, double rating, int discount) {
    this.name = name;
    this.price = price;
    this.rating = rating;
    this.discount = discount;
  }

  @Override
  public String toString() {
    return name + "|" + price + " | " + rating + " | " + discount + "% off";
  }
}

public class EcommerceSorting {

  public static void main(String[] args) {

    List<Product> products = new ArrayList<>();
    products.add(new Product("Laptop", 70000, 4.5, 10));
    products.add(new Product("Phone", 40000, 4.7, 15));
    products.add(new Product("Headphones", 3000, 4.2, 25));

    // 🔹 Campaign 1: Sort by Price
    products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
    System.out.println("Sorted by Price:");
    products.forEach(System.out::println);

    // 🔹 Campaign 2: Sort by Rating (High → Low)
    products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
    System.out.println("\nSorted by Rating:");
    products.forEach(System.out::println);

    // 🔹 Campaign 3: Sort by Discount (High → Low)
    products.sort((p1, p2) -> Integer.compare(p2.discount, p1.discount));
    System.out.println("\nSorted by Discount:");
    products.forEach(System.out::println);
  }
}
