
public class Product {

  private static int discount;
  private final int productId;
  private String productName;
  private double price;
  private int quatity;

  Product(int productId, String productName, double price, int quatity) {
    this.productId = productId;
    this.productName = productName;
    this.price = price;
    this.quatity = quatity;
  }

  static int updateDiscount(int newDiscount) {
    discount = newDiscount;
    return discount;
  }

  public void showProductDetails(Object product) {
    if (product instanceof Product) {
      Product p = (Product) product;
      System.out.println("Product ID: " + p.productId);
      System.out.println("Product Name: " + p.productName);
      System.out.println("Product Price: " + p.price);
      System.out.println("Product Quantity: " + p.quatity);
      System.out.println("Product Discount: " + discount + "%");
    } else {
      System.out.println("Invalid product object.");
    }
  }

  public static void main(String[] args) {
    Product prod1 = new Product(101, "Laptop", 75000.0, 5);
    Product prod2 = new Product(102, "Smartphone", 30000.0, 10);

    // Update discount
    Product.updateDiscount(15);

    // Show product details
    prod1.showProductDetails(prod1);
    System.out.println();
    prod2.showProductDetails(prod2);
  }
}
