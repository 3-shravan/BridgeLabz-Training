package com.shravan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    @Test
    void testValidDate() {
        assertEquals("25-12-2024",
                DateFormatter.formatDate("2024-12-25"));

        assertEquals("01-01-2023",
                DateFormatter.formatDate("2023-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.formatDate("25-12-2024"));
    }

    @Test
    void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.formatDate("2024-13-01"));
    }

    @Test
    void testNullDate() {
        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.formatDate(null));
    }
}
