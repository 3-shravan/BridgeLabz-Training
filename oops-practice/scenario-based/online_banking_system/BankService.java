package scenario_based.online_banking_system;

public interface BankService {

	void createAccount(String accountType, String accountHolderName, double initialDeposit);

	void transferFunds(String fromAccountNumber, String toAccountNumber, double amount);

	double checkBalance(String accountNumber);
	
	void getTransactionHistory(String accountNumber);

}
