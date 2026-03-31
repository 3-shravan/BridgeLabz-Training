package scenario_based.ecommerce_order_management;

public class WalletPayment implements Payment {
	@Override
	public void pay(double amount) throws PaymentFailedException {
		if (amount <= 0) {
			throw new PaymentFailedException("Invalid amount for Wallet Payment");
		}
		if (amount > 10000) {
			throw new PaymentFailedException("Insufficient wallet balance");
		}
		System.out.println("Paid ₹" + amount + " using Wallet");
	}

}
