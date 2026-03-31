package scenario_based.inventory_management_system;

public class LowStockAlertService implements AlertService {

	private static final int THRESHOLD = 5;

	@Override
	public void sendLowStockAlert(Product product) {
		if (product.getStock() <= THRESHOLD) {
			System.out
					.println("ALERT: Low stock for " + product.getName() + " (Remaining: " + product.getStock() + ")");
		}
	}
}
