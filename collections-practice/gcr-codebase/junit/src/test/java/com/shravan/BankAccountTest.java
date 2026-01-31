package com.shravan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
  private BankAccount account;

  @BeforeEach
  void setup() {
    account = new BankAccount(1000.0);
  }

  @Test
  void testDepositIncreasesBalance() {
    account.deposit(500.0);
    assertEquals(1500.0, account.getBalance());
  }

  @Test
  void testWithdrawDecreasesBalance() {
    account.withdraw(300.0);
    assertEquals(700.0, account.getBalance());
  }

  @Test
  void testMultipleTransactions() {
    account.deposit(200.0);
    account.withdraw(400.0);
    account.deposit(100.0);

    assertEquals(900.0, account.getBalance());
  }

  @Test
  void testDepositNegativeAmountThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
  }

  @Test
  void testWithdrawNegativeAmountThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
  }
}
