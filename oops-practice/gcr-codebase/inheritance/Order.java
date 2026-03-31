import java.time.LocalDate;

public class Order {
  protected int orderId;
  protected LocalDate orderDate;

  public Order(int orderId, LocalDate orderDate) {
    this.orderId = orderId;
    this.orderDate = orderDate;
  }

  String getOrderStatus() {
    return "Order Placed";
  }

  public static void main(String[] args) {
    Order order1 = new Order(101, LocalDate.of(2024, 6, 1));
    System.out.println("Order ID: " + order1.orderId + ", Status: " + order1.getOrderStatus());

    ShippedOrder order2 = new ShippedOrder(102, LocalDate.of(2024, 6, 2), 123456);
    System.out.println("Order ID: " + order2.orderId + ", Status: " + order2.getOrderStatus());

    DeliveredOrder order3 = new DeliveredOrder(103, LocalDate.of(2024, 6, 3), 654321, LocalDate.of(2024, 6, 5));
    System.out.println("Order ID: " + order3.orderId + ", Status: " + order3.getOrderStatus());
  }

}

class ShippedOrder extends Order {
  int trackingNumber;

  ShippedOrder(int orderId, LocalDate orderDate, int trackingNumber) {
    super(orderId, orderDate);
    this.trackingNumber = trackingNumber;
  }

  @Override
  String getOrderStatus() {
    return "Order Shipped (Tracking No: " + trackingNumber + ")";
  }

}

class DeliveredOrder extends ShippedOrder {

  LocalDate deliveryDate;

  DeliveredOrder(int orderId, LocalDate orderDate, int trackingNumber, LocalDate deliveryDate) {
    super(orderId, orderDate, trackingNumber);
    this.deliveryDate = deliveryDate;
  }

  @Override
  String getOrderStatus() {
    return "Order Delivered on " + deliveryDate;
  }

}
