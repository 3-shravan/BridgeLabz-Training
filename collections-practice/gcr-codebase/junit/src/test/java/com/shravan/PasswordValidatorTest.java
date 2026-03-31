package com.shravan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

  @Test
  void testValidPassword() {
    assertTrue(PasswordValidator.isValid("Password1"));
    assertTrue(PasswordValidator.isValid("Secure9A"));
  }

  @Test
  void testPasswordTooShort() {
    assertFalse(PasswordValidator.isValid("Pass1"));
  }

  @Test
  void testPasswordWithoutUppercase() {
    assertFalse(PasswordValidator.isValid("password1"));
  }

  @Test
  void testPasswordWithoutDigit() {
    assertFalse(PasswordValidator.isValid("Password"));
  }

  @Test
  void testNullPassword() {
    assertFalse(PasswordValidator.isValid(null));
  }
}
