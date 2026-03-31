package scenario_based.ecommerce_order_management;

public class UpiPayment implements Payment {

	@Override
	public void pay(double amount) throws PaymentFailedException {
		if (amount <= 0) {
			throw new PaymentFailedException("Invalid amount for UPI Payment");
		}

		System.out.println("Processed UPI payment of amount: " + amount);
	}

}
