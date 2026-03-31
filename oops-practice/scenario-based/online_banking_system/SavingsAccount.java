package scenario_based.online_banking_system;

public class SavingsAccount extends Account {

	private double interestRate = 4.0;

	public SavingsAccount(String accNo, String accountHolderName, double initialDeposit) {
		super(accNo, accountHolderName, initialDeposit);
	}

	@Override
	double calculateInterest() {
		return getBalance() * interestRate / 100;
	}

}
