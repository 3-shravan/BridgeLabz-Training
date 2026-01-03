public class BankAccount {
  String accountNumber;
  double balance;

  BankAccount(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  void displayDetails() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Balance: ₹" + balance);
  }

  public static void main(String[] args) {

    SavingsAccount savings = new SavingsAccount("SA123", 5000.0, 3.5);
    savings.displayDetails();

    CheckingAccount checking = new CheckingAccount("CA456", 2000.0, 1000.0);
    checking.displayDetails();

    FixedDepositAccount fixedDeposit = new FixedDepositAccount("FDA789", 10000.0, 5);
    fixedDeposit.displayDetails();

  }
}

class SavingsAccount extends BankAccount {
  double interestRate;

  SavingsAccount(String accountNumber, double balance, double interestRate) {
    super(accountNumber, balance);
    this.interestRate = interestRate;
  }

  @Override
  void displayDetails() {
    super.displayDetails();
    System.out.println("Account Type: Savings Account");
    System.out.println("Interest Rate: " + interestRate + "%");
  }
}

class CheckingAccount extends BankAccount {
  double withdrawalLimit;

  CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
    super(accountNumber, balance);
    this.withdrawalLimit = withdrawalLimit;
  }

  @Override
  void displayDetails() {
    super.displayDetails();
    System.out.println("Account Type: Checking Account");
    System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
  }
}

class FixedDepositAccount extends BankAccount {
  int tenure;

  FixedDepositAccount(String accountNumber, double balance, int tenure) {
    super(accountNumber, balance);
    this.tenure = tenure;
  }

  @Override
  void displayDetails() {
    super.displayDetails();
    System.out.println("Account Type: Fixed Deposit Account");
    System.out.println("Tenure: " + tenure + " years");
  }
}
