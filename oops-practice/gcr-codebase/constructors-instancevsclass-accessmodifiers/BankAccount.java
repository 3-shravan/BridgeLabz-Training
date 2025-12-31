public class BankAccount {
  public String accountNumber;
  protected String accountHolder;
  private double balance;

  public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = initialBalance;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double amount) {
    this.balance = amount;
  }

}

class SavingsAccount extends BankAccount {
  SavingsAccount(String accountNumber, String accountHolder, double initialBalance) {
    super(accountNumber, accountHolder, initialBalance);
  }

  public static void main(String[] args) {
    SavingsAccount sa = new SavingsAccount("123456", "John Doe", 1000.0);
    System.out.println("Account Number: " + sa.accountNumber); // Accessible (public)
    System.out.println("Account Holder: " + sa.accountHolder); // Accessible (protected)
    // System.out.println("Balance: " + sa.balance); // Not Accessible (private)
    System.out.println("Balance: " + sa.getBalance()); // Accessible via public method
  }
}