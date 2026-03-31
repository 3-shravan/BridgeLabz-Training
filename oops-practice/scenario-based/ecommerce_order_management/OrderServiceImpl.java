package scenario_based.ecommerce_order_management;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

	private final List<Product> products = new ArrayList<>();
	private final List<Order> orders = new ArrayList<>();
	private int orderCounter = 1;

	private Product findProduct(int productId) {
		for (Product p : products) {
			if (p.getProductId() == productId) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void listProducts() {
		if (products.isEmpty()) {
			System.out.println("No products available.");
			return;
		}
		for (Product p : products) {
			System.out.println(p);
		}
	}

	private Order findOrder(int orderId) {
		for (Order o : orders) {
			if (o.getOrderId() == orderId) {
				return o;
			}
		}
		return null;
	}

	@Override
	public void addProduct(Product product) {
		products.add(product);
		System.out.println("Product added: " + product.getName());
	}

	@Override
	public void placeOrder(int productId, Customer customer, Payment payment) throws PaymentFailedException {

		Product product = findProduct(productId);
		if (product == null) {
			throw new PaymentFailedException("Product not found: " + productId);
		}

		payment.pay(product.getPrice());

		Order order = new Order(orderCounter++, customer, product);
		order.markPaid();
		orders.add(order);

		System.out.println("Order placed successfully. Order ID: " + order.getOrderId());
	}

	@Override
	public void cancelOrder(int orderId) {
		Order order = findOrder(orderId);
		order.cancel();
		System.out.println("Order " + orderId + " cancelled");
	}

	@Override
	public void listOrders() {
		for (Order o : orders) {
			System.out.println(o);
		}
	}
}
