package scenario_based.ecommerce_order_management;

public class Order {

	private final int orderId;
	private final Customer customer;
	private final Product product;
	private String status;

	public Order(int orderId, Customer customer, Product product) {
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.status = "Pending";
	}

	public int getOrderId() {
		return orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Product getProduct() {
		return product;
	}

	public String getStatus() {
		return status;
	}

	public void cancel() {
		this.status = "Cancelled";
	}

	public void deliver() {
		this.status = "Delivered";
	}

	public void markPaid() {
		this.status = "PAID";
	}

}
