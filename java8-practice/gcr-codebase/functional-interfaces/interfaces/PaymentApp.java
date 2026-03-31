package interfaces;
interface Payment {
  void pay();

}

class UPI implements Payment {
  @Override
  public void pay() {
    System.out.println("paid by upi");
  }
}

class CreditCard implements Payment {
  @Override
  public void pay() {
    System.out.println("paid by credit card");
  }
}

class Wallet implements Payment {
  @Override
  public void pay() {
    System.out.println("paid by Wallet");
  }
}

public class PaymentApp {

  public static void main(String[] args) {
    Payment payment;
    payment = new UPI();
    payment.pay();

    payment = new CreditCard();
    payment.pay();

    payment = new Wallet();
    payment.pay();
  }

}