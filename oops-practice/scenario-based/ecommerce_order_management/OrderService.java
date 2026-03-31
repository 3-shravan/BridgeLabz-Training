package scenario_based.ecommerce_order_management;

public interface OrderService {
	void addProduct(Product product);

	void listProducts();

	void placeOrder(int productId, Customer customer, Payment payment) throws PaymentFailedException;

	void cancelOrder(int orderId);

	void listOrders();
}
