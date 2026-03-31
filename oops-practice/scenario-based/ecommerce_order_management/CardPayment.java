package scenario_based.ecommerce_order_management;

public class CardPayment implements Payment {
	@Override

	public void pay(double amount) throws PaymentFailedException {
		if (amount <= 0) {
			throw new PaymentFailedException("Invalid payment amount: " + amount);
		}
		if (amount > 50000) {
			throw new PaymentFailedException("Card payment limit exceeded for amount: " + amount);
		}
		System.out.println("Paid " + amount + " using Card Payment.");
	}

}
