package scenario_based.online_banking_system;

import java.util.List;
import java.util.ArrayList;

public abstract class Account {

	private String accountNumber;
	private String accountHolderName;
	private double balance;
	List<String> transactionHistory = new ArrayList<>();

	public Account(String accountNumber, String accountHolderName, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = initialDeposit;
	}

	abstract double calculateInterest();

	String getAccountNumber() {
		return accountNumber;
	}

	String getAccountHolderName() {
		return accountHolderName;
	}

	double getBalance() {
		return balance;
	}

	double deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Deposit amount must be positive.");
			return balance;
		}
		balance += amount;
		transactionHistory.add("" + amount + " deposited.");
		return balance;
	}

	double withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive.");
			return balance;
		}
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
		}
		balance -= amount;
		transactionHistory.add("" + amount + " withdrawn.");

		return balance;
	}

	void showTransactionHistory() {
		if (transactionHistory.isEmpty()) {
			System.out.println("No transactions found.");
			return;
		}
		System.out.println("Transaction History for Account " + accountNumber + ":");
		for (String record : transactionHistory) {
			System.out.println(record);
		}
	}

}
