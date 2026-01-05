
public class BankAccount1 {

  private static String bankName = "Global Bank";
  private static int totaAccounts = 0;
  private String accountHolderName;
  private final String accountNumber;
  private double balance;

  BankAccount1(String accountHolderName, String accountNumber, double balance) {
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.balance = balance;
    totaAccounts++;
  }

  public static int getTotalAccounts() {
    return totaAccounts;
  }

  public void showDetails(Object obj) {
    if (obj instanceof BankAccount1) {
      BankAccount1 account = (BankAccount1) obj;
      System.out.println("Bank Name: " + bankName);
      System.out.println("Account Holder: " + account.accountHolderName);
      System.out.println("Account Number: " + account.accountNumber);
      System.out.println("Balance: $" + account.balance);
    } else {
      System.out.println("Invalid object type. Expected a BankAccount1 instance.");
    }
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public String setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    return accountHolderName;
  }

  public double deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    }
    return balance;
  }

  public double withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    }
    return balance;
  }

  public static void main(String[] args) {

    BankAccount1 account1 = new BankAccount1("Alice Smith", "123456789", 1500.00);
    BankAccount1 account2 = new BankAccount1("Bob Johnson", "987654321", 2500.00);

    account1.showDetails(account1);
    System.out.println();
    account2.showDetails(account2);
    System.out.println();
    System.out.println("Total Bank Accounts: " + BankAccount1.getTotalAccounts());

    account1.deposit(500);
    System.out
        .println("After depositing $500, " + account1.getAccountHolderName() + "'s balance: $" + account1.withdraw(0));

    account2.withdraw(300);
    System.out
        .println("After withdrawing $300, " + account2.getAccountHolderName() + "'s balance: $" + account2.withdraw(0));
  }

}
