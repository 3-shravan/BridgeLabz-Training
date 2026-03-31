package scenario_based.ecommerce_order_management;

public class PaymentFailedException extends Exception {
	public PaymentFailedException(String message) {
		super(message);
	}

}
