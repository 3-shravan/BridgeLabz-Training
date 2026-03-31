import java.time.LocalDateTime;

class BankAccount {
  private int balance=10000;
  public int getBalance() {
    return balance;
  }

  public synchronized boolean withdraw(int amount) {
    if (balance >= amount) {
      try {
        Thread.sleep(200);

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      balance -= amount;
      return true;
    }
    return false;
  }
}

class Transaction implements Runnable {
  private final BankAccount account;
  private final String customerName;
  private final int amount;

  public Transaction(BankAccount account, String customerName, int amount) {
    this.account = account;
    this.customerName = customerName;
    this.amount = amount;
  }

  @Override
  public void run() {
    System.out.println("[" + Thread.currentThread().getName() +
        "] Attempting to withdraw " + amount);

    boolean success = account.withdraw(amount);

    if (success) {
      System.out.println("Transaction successful: " + customerName +
          ", Amount: " + amount +
          ", Balance: " + account.getBalance() +
          ", Time: " + LocalDateTime.now());
    } else {
      System.out.println("Transaction failed: " + customerName +
          ", Amount: " + amount +
          ", Balance: " + account.getBalance() +
          ", Time: " + LocalDateTime.now());
    }
  }
}

public class BankingSystem {

  public static void main(String[] args) {
    BankAccount account = new BankAccount();

    Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "Customer-1");
    Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "Customer-2");
    Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "Customer-3");
    Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "Customer-4");
    Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "Customer-5");

    // Display thread state before start
    System.out.println("Thread States Before Start:");
    System.out.println(t1.getName() + " : " + t1.getState());
    System.out.println(t2.getName() + " : " + t2.getState());
    System.out.println(t3.getName() + " : " + t3.getState());
    System.out.println(t4.getName() + " : " + t4.getState());
    System.out.println(t5.getName() + " : " + t5.getState());

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
  }
}
