package scenario_based.online_banking_system;

import java.util.ArrayList;
import java.util.List;

public class Services implements BankService {

	List<Account> accounts = new ArrayList<>();

	@Override
	public void createAccount(String accountType, String accountHolderName, double initialDeposit) {

		String accNo = "ACC" + System.currentTimeMillis();

		if (accountType == null) {
			System.out.println("Invalid account type specified.");
			return;
		}

		if (accountType.equalsIgnoreCase("Savings")) {
			Account sa = new SavingsAccount(accNo, accountHolderName, initialDeposit);
			accounts.add(sa);
			System.out.println("Savings Account created successfully for " + accountHolderName + ". Account No: "
					+ sa.getAccountNumber());

		} else if (accountType.equalsIgnoreCase("Current")) {
			Account ca = new CurrentAccount(accNo, accountHolderName, initialDeposit);
			accounts.add(ca);
			System.out.println("Current Account created successfully for " + accountHolderName + ". Account No: "
					+ ca.getAccountNumber());
		} else {
			System.out.println("Invalid account type specified.");
		}
	}

	@Override
	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(fromAccountNumber)) {
				double fromBalance = account.getBalance();
				if (fromBalance < amount) {
					System.out.println("Insufficient funds in account " + fromAccountNumber);
					return;
				}

				try {
					account.withdraw(amount);
					System.out
							.println("Transferred " + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
					break;
				} catch (InsufficientBalanceException e) {
					System.out.println(e.getMessage());
					return;
				}

			}
		}
		for (Account accountTo : accounts) {
			if (accountTo.getAccountNumber().equals(toAccountNumber)) {
				accountTo.deposit(amount);
				System.out.println("Received " + amount + " in " + toAccountNumber + " from " + fromAccountNumber);
				return;
			}
		}
	}

	@Override
	public double checkBalance(String accountNumber) {
		double balance = 0;
		boolean found = false;
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				balance = account.getBalance();
				found = true;
			}
		}
		if (!found) {
			System.out.println("Account number " + accountNumber + " not found.");
			return -1;
		}
		return balance;
	}

	@Override
	public void getTransactionHistory(String accountNumber) {
		boolean found = false;
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				account.showTransactionHistory();
				found = true;
			}
		}
		if (!found) {
			System.out.println("Account number " + accountNumber + " not found.");
		}
	}

}