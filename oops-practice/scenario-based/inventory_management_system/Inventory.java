package scenario_based.inventory_management_system;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

	private Map<String, Product> products = new HashMap<>();
	private AlertService alertService;

	public Inventory(AlertService alertService) {
		this.alertService = alertService;
	}

	public void addProduct(String id, String name, int stock) {
		products.put(id, new Product(id, name, stock));
		System.out.println("Product added successfully");

	}

	public void updateStock(String productId, int quantity) throws OutOfStockException {

		Product product = products.get(productId);
		product.reduceStock(quantity);
		alertService.sendLowStockAlert(product);
		System.out.println("Stock updated successfully");
	}

	public void viewAllProducts() {
		System.out.println("----- Inventory -----");
		for (Product p : products.values()) {
			System.out.println(p.getProductId() + " | " + p.getName() + " | Stock: " + p.getStock());
		}
	}
}
