
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Order {

  String orderId;
  String customerId;
  double amount;

  public Order(String orderId, String customerId, double amount) {
    this.orderId = orderId;
    this.customerId = customerId;
    this.amount = amount;
  }
}

public class OrderRevenueSummary {
  public static void main(String[] args) {
    List<Order> orders = Arrays.asList(
        new Order("O1", "C1", 100.0),
        new Order("O2", "C2", 150.0),
        new Order("O3", "C1", 200.0),
        new Order("O4", "C3", 50.0));

    orders.stream()
        .collect(Collectors.groupingBy(o -> o.customerId,
            Collectors.summingDouble(o -> o.amount)))
        .forEach((cid, total) -> System.out.println(cid + " -> " + total));
  }
}
