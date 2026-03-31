package scenario_based.online_banking_system;

public class CurrentAccount extends Account {

	private double interestRate = 2.0;

	public CurrentAccount(String accNo, String accountHolderName, double initialDeposit) {
		super(accNo, accountHolderName, initialDeposit);
	}

	@Override
	double calculateInterest() {
		return getBalance() * interestRate / 100;
	}

}
