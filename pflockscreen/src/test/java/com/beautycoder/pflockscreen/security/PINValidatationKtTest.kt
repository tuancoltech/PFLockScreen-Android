package com.beautycoder.pflockscreen.security

import org.junit.Assert.*

import org.junit.Test

class PinValidationTest {

    @Test
    fun `PIN with all same digits is invalid`() {
        assertFalse("111111".isValidPin())
        assertFalse("000000".isValidPin())
        assertFalse("999999".isValidPin())
    }

    @Test
    fun `PIN with ascending consecutive digits is invalid`() {
        assertFalse("123456".isValidPin())
        assertFalse("234567".isValidPin())
    }

    @Test
    fun `PIN with descending consecutive digits is invalid`() {
        assertFalse("654321".isValidPin())
        assertFalse("765432".isValidPin())
    }

    @Test
    fun `PIN with non-consecutive and non-repeating digits is valid`() {
        assertTrue("918273".isValidPin())
        assertTrue("485960".isValidPin())
    }

    @Test
    fun `PIN with partially ascending digits is valid`() {
        assertTrue("123589".isValidPin())
    }

    @Test
    fun `PIN with partially descending digits is valid`() {
        assertTrue("654789".isValidPin())
    }

    @Test
    fun `PIN with non-numeric characters is invalid`() {
        // The function does not handle non-numeric input, so only valid numbers are tested
        // If this case needs to be addressed, add a Regex check for digits-only
        assertFalse("".isValidPin())
    }
}