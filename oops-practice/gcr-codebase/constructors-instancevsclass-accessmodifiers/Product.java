public class Product {

  private String productName;
  private double price;
  private static int totalProducts;

  public Product() {
    this("Unknown", 0.0);
  }

  public Product(String productName, double price) {
    this.productName = productName;
    this.price = price;
    totalProducts++;
  }

  void displayProductDetails() {
    System.out.println("Product Name: " + productName);
    System.out.println("Price: $" + price);
  }

  void displayTotalProducts() {
    System.out.println("Total Products: " + totalProducts);
  }

  public static void main(String[] args) {
    Product pro = new Product("Laptop", 999.99);
    pro.displayProductDetails();
    pro.displayTotalProducts();
  }
}