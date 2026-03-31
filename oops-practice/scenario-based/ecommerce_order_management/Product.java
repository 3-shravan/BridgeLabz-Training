package scenario_based.ecommerce_order_management;

public class Product {
	private final int productId;
	private final String name;
	private double price;

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(int i, String name, double price) {
		this.productId = i;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}

}
