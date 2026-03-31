package scenario_based.online_banking_system;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UtilInput read = new UtilInput(sc);
		Services service = new Services();

		System.out.println("Welcome to the Online Banking System!");
		while (true) {
			int choice = readUserChoice(read);
			try {

				switch (choice) {
				case 1:
					String accountType = read.readString("Enter account type (Savings/Current): ");
					String accountHolderName = read.readString("Enter account holder name: ");
					double initialDeposit = read.readDouble("Enter initial deposit amount: ");
					service.createAccount(accountType, accountHolderName, initialDeposit);
					break;
				case 2:
					String fromAccNo = read.readString("Enter your account number: ");
					String toAccNo = read.readString("Enter recipient's account number: ");
					double amount = read.readDouble("Enter amount to transfer: ");
					service.transferFunds(fromAccNo, toAccNo, amount);
					break;
				case 3:
					String accNo = read.readString("Enter your account number: ");
					double balance = service.checkBalance(accNo);
					if (balance != -1) {
						System.out.println("Your current balance is: " + balance);
					}
					break;
				case 4:
					String accNumber = read.readString("Enter your account number: ");
					service.getTransactionHistory(accNumber);
					break;
				case 5:
					System.out.println("Thank you for using the Online Banking System. Goodbye!");
					sc.close();
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;

				}
			} catch (Exception e) {
				System.out.println("An error occurred: " + e.getMessage());
			}

		}
	}

	private static int readUserChoice(UtilInput read) {
		System.out.println(
				"1. Create Account \n2. Transfer Funds \n3. Check Balance \n4. View Transaction History \n5. Exit");
		return read.readInt("Enter your choice: ");

	}
}