package com.shravan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class HandleExceptionTest {
  @Test
  void testDivideSuccess() {
    assertEquals(5, HandleException.divide(10, 2));
  }

  @Test
  void testDivideByZeroThrowsException() {

    ArithmeticException exception = assertThrows(ArithmeticException.class, () -> HandleException.divide(2, 0));
    assertEquals("Division by zero is not allowed", exception.getMessage());
  }

}
