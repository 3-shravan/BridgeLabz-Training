package com.shravan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

        @Test
        void testValidUserRegistration() {
                assertTrue(UserRegistration.registerUser("shravan", "shravan@gmail.com", "password123"));
        }

        @Test
        void testInvalidUsername() {
                assertThrows(IllegalArgumentException.class,
                                () -> UserRegistration.registerUser("", "user@gmail.com", "password123"));
        }

        @Test
        void testInvalidEmail() {
                assertThrows(IllegalArgumentException.class,
                                () -> UserRegistration.registerUser("user", "usergmail.com", "password123"));
        }

        @Test
        void testInvalidPassword() {
                assertThrows(IllegalArgumentException.class,
                                () -> UserRegistration.registerUser("user", "user@gmail.com", "123"));
        }

        @Test
        void testNullInputs() {
                assertThrows(IllegalArgumentException.class,
                                () -> UserRegistration.registerUser(null, "user@gmail.com", "password123"));
        }
}
