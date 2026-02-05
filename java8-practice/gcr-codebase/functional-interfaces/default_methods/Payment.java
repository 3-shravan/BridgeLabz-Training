package default_methods;

interface PaymentProcessor {

  void pay(double amount);

  default void refund(double amount) {
    System.out.println("Refunded ₹" + amount + " using standard process");
  }
}

class UPIProcessor implements PaymentProcessor {

  @Override
  public void pay(double amount) {
    System.out.println("Paid ₹" + amount + " via UPI");
  }
}

class CardProcessor implements PaymentProcessor {

  @Override
  public void pay(double amount) {
    System.out.println("Paid ₹" + amount + " via Card");
  }
}

class WalletProcessor implements PaymentProcessor {

  @Override
  public void pay(double amount) {
    System.out.println("Paid ₹" + amount + " via Wallet");
  }

  @Override
  public void refund(double amount) {
    System.out.println("Refunded ₹" + amount + " instantly to Wallet");
  }
}

public class Payment {
  public static void main(String[] args) {

    PaymentProcessor upi = new UPIProcessor();
    PaymentProcessor card = new CardProcessor();
    PaymentProcessor wallet = new WalletProcessor();

    upi.pay(500);
    upi.refund(200);

    card.pay(1000);
    card.refund(300);

    wallet.pay(700);
    wallet.refund(400);
  }
}