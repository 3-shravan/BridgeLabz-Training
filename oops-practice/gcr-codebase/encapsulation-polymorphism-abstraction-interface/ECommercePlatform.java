/*
 * Interface defining tax-related behavior
 */

import java.util.ArrayList;
import java.util.List;

interface Taxable {
  double calculateTax();

  String getTaxDetails();
}

abstract class Product {

  private final int productId;
  private String name;

  public Product(int productId, String name, double price) {
    this.productId = productId;
    setName(name);
    setPrice(price);
  }

  // Abstract method for discount calculation
  public abstract double calculateDiscount();

  // Concrete method for displaying product details
  public void displayDetails(double finalPrice) {
    System.out.println("Product ID    : " + productId);
    System.out.println("Product Name  : " + name);
    System.out.println("Base Price    : ₹" + price);
    System.out.println("Final Price   : ₹" + finalPrice);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  protected double price;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}

/*
 * Electronics product
 * Taxable category
 */
class Electronics extends Product implements Taxable {

  public Electronics(int id, String name, double price) {
    super(id, name, price);
  }

  @Override
  public double calculateDiscount() {
    // 10% discount
    return price * 0.10;
  }

  @Override
  public double calculateTax() {
    // 18% GST
    return price * 0.18;
  }

  @Override
  public String getTaxDetails() {
    return "Electronics GST: 18%";
  }
}

/*
 * Clothing product
 * Taxable category
 */
class Clothing extends Product implements Taxable {

  public Clothing(int id, String name, double price) {
    super(id, name, price);
  }

  @Override
  public double calculateDiscount() {
    // Flat ₹500 discount
    return 500;
  }

  @Override
  public double calculateTax() {
    // 12% GST
    return price * 0.12;
  }

  @Override
  public String getTaxDetails() {
    return "Clothing GST: 12%";
  }
}

/*
 * Groceries product
 * Non-taxable category
 */
class Groceries extends Product {

  public Groceries(int id, String name, double price) {
    super(id, name, price);
  }

  @Override
  public double calculateDiscount() {
    // 5% discount
    return price * 0.05;
  }
}

public class ECommercePlatform {

  public static void main(String[] args) {
    List<Product> cart = new ArrayList<>();

    cart.add(new Electronics(1, "Laptop", 75000));
    cart.add(new Clothing(2, "Jacket", 4000));
    cart.add(new Groceries(3, "Rice Bag", 2000));
    calculateFinalPrices(cart);
  }

  private static void calculateFinalPrices(List<Product> cart) {

    for (Product product : cart) {
      double discount = product.calculateDiscount();
      double tax = 0;
      if (product instanceof Taxable) {
        Taxable taxableItem = (Taxable) product;
        tax = taxableItem.calculateTax();

        System.out.println(taxableItem.getTaxDetails());
      }
      double finalPrice = product.getPrice() - discount + tax;
      product.displayDetails(finalPrice);
    }
  }

}
