package scenario_based.inventory_management_system;

public class Product {

	private final String productId;
	private final String name;
	private int stock;

	public Product(String productId, String name, int stock) {
		this.productId = productId;
		this.name = name;
		this.stock = stock;
	}

	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}

	public void addStock(int quantity) {
		this.stock += quantity;
	}

	public void reduceStock(int quantity) throws OutOfStockException {
		if (stock < quantity) {
			throw new OutOfStockException("Not enough stock for product: " + name);
		}
		this.stock -= quantity;
	}
}
