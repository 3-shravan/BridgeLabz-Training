package com.shravan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

  @Test
  void testReverse() {
    assertEquals("olleh", StringUtils.reverse("hello"));
    assertEquals("", StringUtils.reverse(""));
    assertNull(StringUtils.reverse(null));
  }

  @Test
  void testIsPalindrome() {
    assertTrue(StringUtils.isPalindrome("madam"));
    assertTrue(StringUtils.isPalindrome("level"));
    assertFalse(StringUtils.isPalindrome("hello"));
    assertFalse(StringUtils.isPalindrome(null));
  }

  @Test
  void testToUpperCase() {
    assertEquals("HELLO", StringUtils.toUpperCase("hello"));
    assertEquals("JAVA", StringUtils.toUpperCase("java"));
    assertEquals("", StringUtils.toUpperCase(""));
    assertNull(StringUtils.toUpperCase(null));
  }

}
