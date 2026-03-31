import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class BankingServies {
  Map<Integer, Double> accountMap = new HashMap<>();
  Map<Double, List<Integer>> sortedByBalanceMap = new TreeMap<>();
  Queue<Integer> withdrawlQueue = new LinkedList<>();

  public void createAccount(int accountNumber, double initialBalance) {
    accountMap.put(accountNumber, initialBalance);
    sortedByBalanceMap.put(initialBalance, new ArrayList<>());
  }

  public void requestWithdrawl(int accoundNumber) {
    if (accountMap.containsKey(accoundNumber))
      withdrawlQueue.add(accoundNumber);
    else
      System.out.println("Account number " + accoundNumber + " does not exist.");
  }

  public void processWithdrawls(int amount) {
    while (!withdrawlQueue.isEmpty()) {
      int accountNumber = withdrawlQueue.poll();
      double balance = accountMap.get(accountNumber);
      if (balance < amount) {
        System.out.println("Insufficient balance in account number " + accountNumber);
        return;
      }
      accountMap.put(accountNumber, balance - amount);
      System.out.println("Withdrawl of $" + amount + " processed for account number " + accountNumber);
    }

  }

  public void displayAccountsSortedByBalance() {
    System.out.println("Accounts sorted by balance:");
    sortedByBalanceMap.clear();
    for (Map.Entry<Integer, Double> entry : accountMap.entrySet()) {
      sortedByBalanceMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
    }
    sortedByBalanceMap.forEach((balance, accounts) -> {
      for (Integer account : accounts) {
        System.out.println("Account Number: " + account + " -> Balance: $" + balance);
      }
    });
  }

  public void displayAllAccounts() {
    System.out.println("\n🔹 All Accounts:");
    accountMap.forEach((acc, bal) -> System.out.println("Account " + acc + " -> ₹" + bal));
  }

}

public class BankingSystem {

  public static void main(String[] args) {
    BankingServies bankingServies = new BankingServies();
    bankingServies.createAccount(101, 5000);
    bankingServies.createAccount(102, 3000);
    bankingServies.createAccount(103, 7000);
    bankingServies.createAccount(104, 6000);

    bankingServies.displayAllAccounts();

    bankingServies.requestWithdrawl(102);
    bankingServies.requestWithdrawl(104);
    bankingServies.requestWithdrawl(105);

    bankingServies.processWithdrawls(2000);

    bankingServies.displayAllAccounts();

    bankingServies.displayAccountsSortedByBalance();
  }

}
