import java.util.ArrayList;
import java.util.List;

class InsufficientBalanceException extends Exception {
  public InsufficientBalanceException(String message) {
    super(message);
  }
}

interface BankService {
  void transfer(Account from, Account to, double amount) throws InsufficientBalanceException;

}

abstract class Account {
  private String accountNumber;
  protected double balance;
  private String name;
  private List<String> transactionHistory = new ArrayList<>();

  public Account(
      String accountNumber, String name,
      double balance) {
    this.accountNumber = accountNumber;
    this.name = name;
    this.balance = balance;
    transactionHistory.add("Account created with balance: " + balance);
  }

  public abstract double calculateInterest();

  public synchronized void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Deposited: " + amount);
    } else {
      System.out.println("Deposit amount must be positive.");
    }
  }

  public synchronized void withdraw(double amount) throws InsufficientBalanceException {
    if (amount > balance) {
      throw new InsufficientBalanceException("Insufficient balance for withdrawal of: " + amount);
    } else if (amount <= 0) {
      System.out.println("Withdrawal amount must be positive.");
    } else {
      balance -= amount;
      System.out.println("Withdrew: " + amount);
    }

  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  void displayAccountInfo() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder: " + name);
    System.out.println("Current Balance: " + balance);
  }

  public void printTransactionHistory() {
    System.out.println("Transaction History for Account " + accountNumber);
    for (String t : transactionHistory) {
      System.out.println(t);
    }
  }

}

class SavingsAcount extends Account {

  public SavingsAcount(String accountNumber, String name, double balance) {
    super(accountNumber, name, balance);
  }

  @Override
  public double calculateInterest() {
    return balance * 0.04; // 4% interest
  }

  @Override
  void displayAccountInfo() {
    System.out.println("Savings Account Details:");
    super.displayAccountInfo();
  }

}

class CurrentAccount extends Account {

  public CurrentAccount(String accountNumber, String name, double balance) {
    super(accountNumber, name, balance);
  }

  public double calculateInterest() {
    double interest = getBalance() * 0.03;
    deposit(interest);
    System.out.println("Interest of " + interest + " added to the account.");
    return interest;
  }

  @Override
  void displayAccountInfo() {
    System.out.println("Current Account Details:");
    super.displayAccountInfo();
  }

}

class BankServiceImpl implements BankService {
  @Override
  public void transfer(Account from, Account to, double amount) throws InsufficientBalanceException {
    from.withdraw(amount);
    to.deposit(amount);
    System.out.println("Transferred " + amount + " from " + from.getAccountNumber() + " to " + to.getAccountNumber());
  }
}

public class OnlineBankingSystem {
  public static void main(String[] args) {

    try {
      Account savings = new SavingsAcount("SA123", "Alice", 1000);
      Account current = new CurrentAccount("CA456", "Bob", 2000);

      BankService bankService = new BankServiceImpl();

      Thread t1 = new Thread(() -> {
        try {
          bankService.transfer(savings, current, 2000);
        } catch (InsufficientBalanceException e) {
          System.out.println(e.getMessage());
        }
      });

      Thread t2 = new Thread(() -> {
        try {
          savings.deposit(1000);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      });

      t1.start();
      t2.start();

      t1.join();
      t2.join();

      // CRUD – Read
      System.out.println("Savings Balance: " + savings.getBalance());
      System.out.println("Current Balance: " + current.getBalance());

      // Polymorphism demonstration
      System.out.println(
          "Savings Interest: " + savings.calculateInterest());

      // Transaction History
      savings.printTransactionHistory();
      current.printTransactionHistory();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

  }
}
