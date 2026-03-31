import java.util.Arrays;

class Stock {
  private String name;
  private double price;

  public Stock(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Stock{name='" + name + "', price=" + price + "}";
  }
}

public class StockPriceLogger {
  public static void main(String[] args) {
    Arrays.asList(
        new Stock("AAPL", 150.0),
        new Stock("GOOGL", 2800.0),
        new Stock("AMZN", 3400.0))
        .stream()
        .forEach(System.out::println);
  }
}
