package com.shravan.junit_scenario_based_Problem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        // Arrange
        Program account = new Program(1000.0);

        // Act
        account.Deposit(500.0);

        // Assert (only ONE assert)
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        // Arrange
        Program account = new Program(1000.0);

        // Act & Assert (only ONE assert)
        Exception exception = assertThrows(Exception.class, () -> {
            account.Deposit(-200.0);
        });

        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        // Arrange
        Program account = new Program(1000.0);

        // Act
        account.Withdraw(400.0);

        // Assert (only ONE assert)
        assertEquals(600.0, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        // Arrange
        Program account = new Program(1000.0);

        // Act & Assert (only ONE assert)
        Exception exception = assertThrows(Exception.class, () -> {
            account.Withdraw(2000.0);
        });

        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
