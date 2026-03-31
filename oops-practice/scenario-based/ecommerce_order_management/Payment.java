package scenario_based.ecommerce_order_management;

public interface Payment {

	void pay(double amount) throws PaymentFailedException;

}
