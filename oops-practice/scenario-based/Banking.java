abstract class BankAccount {

  private final String accountNumber;
  private final double balance;

  protected BankAccount(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public final double getBalance() {
    return balance;
  }

  public abstract double calculateFee();
}

class SavingsAccount extends BankAccount {

  public SavingsAccount(String accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public double calculateFee() {
    return getBalance() * 0.005; // 0.5%
  }
}

class CheckingAccount extends BankAccount {

  public CheckingAccount(String accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public double calculateFee() {
    return getBalance() < 1000 ? 1.0 : 0.0;
  }
}

public class Banking {
  public static void main(String[] args) {

    BankAccount savings = new SavingsAccount("12345", 1000.0);
    System.out.printf("%.2f%n", savings.calculateFee());

    BankAccount c1 = new CheckingAccount("888", 1500);
    BankAccount c2 = new CheckingAccount("999", 500);

    System.out.printf("%.2f%n", c1.calculateFee());
    System.out.printf("%.2f%n", c2.calculateFee());

  }
}
