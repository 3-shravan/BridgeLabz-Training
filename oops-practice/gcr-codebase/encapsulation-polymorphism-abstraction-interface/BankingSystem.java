import java.util.List;

interface Loanable {
  void applyForLoan(double amount);

  double calculateLoanEligibility();
}

abstract class BankAccount {
  private final int accountNumber;
  private String holderName;
  protected double balance = 0.0;

  public BankAccount(int accountNumber, String holderName, double initialBalance) {
    this.accountNumber = accountNumber;
    setHolderName(holderName);
    setBalance(initialBalance);
  }

  abstract double calculateInterest();

  void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    } else {
      System.out.println("Deposit amount must be positive.");
    }
  }

  void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    } else {
      System.out.println("Invalid withdrawal amount.");
    }
  }

  void displayAccountInfo(double interest) {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Holder Name: " + holderName);
    System.out.println("Balance: $" + balance);
    System.out.println("Accrued Interest: $" + interest);
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public int getAccountNumber() {
    return accountNumber;
  }
}

class SavingsAccount extends BankAccount implements Loanable {

  public SavingsAccount(int accountNumber, String holderName, double initialBalance) {
    super(accountNumber, holderName, initialBalance);
  }

  // Interest: 4% annually
  @Override
  public double calculateInterest() {
    return balance * 0.04;
  }

  @Override
  public void applyForLoan(double amount) {
    System.out.println("Applying for a loan of $" + amount + " from Savings Account.");
  }

  @Override
  public double calculateLoanEligibility() {
    return balance * 0.5;
  }
}

class CurrentAccount extends BankAccount {
  public CurrentAccount(int accountNumber, String holderName, double initialBalance) {
    super(accountNumber, holderName, initialBalance);
  }

  // Interest: 2% annually
  @Override
  public double calculateInterest() {
    return balance * 0.02;
  }
}

public class BankingSystem {
  public static void main(String[] args) {

    List<BankAccount> accounts = List.of(
        new SavingsAccount(1001, "Alice", 5000),
        new CurrentAccount(1002, "Bob", 3000));

    for (BankAccount account : accounts) {
      if (account instanceof Loanable) {
        Loanable loanableAccount = (Loanable) account;
        System.out.println(account.getHolderName() + " is eligible for a loan of up to $" +
            loanableAccount.calculateLoanEligibility());
        loanableAccount.applyForLoan(1000);
      }
      double interest = account.calculateInterest();
      account.displayAccountInfo(interest);
    }
  }
}
