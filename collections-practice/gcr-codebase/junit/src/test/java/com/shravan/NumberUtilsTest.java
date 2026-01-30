package com.shravan;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

  @ParameterizedTest
  @ValueSource(ints = { 2, 4, 6 })
  void testIsEvenTrue(int number) {
    assertTrue(NumberUtils.isEven(number));
  }

  @ParameterizedTest
  @ValueSource(ints = { 7, 9 })
  void testIsEvenFalse(int number) {
    assertFalse(NumberUtils.isEven(number));
  }

}
