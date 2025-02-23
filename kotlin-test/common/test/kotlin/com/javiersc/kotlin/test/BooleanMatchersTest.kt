package com.javiersc.kotlin.test

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class BooleanMatchersTest {

    @Test
    fun `assertFalse should pass for false`() {
        false.assertFalse()
    }

    @Test
    fun `assertFalse should fail for true`() {
        assertFailsWith<AssertionError> { true.assertFalse() }
    }

    @Test
    fun `assertFalse should fail for true with custom message`() {
        val message = "Custom error message"
        val exception = assertFailsWith<AssertionError> { true.assertFalse(message) }
        assertTrue(exception.message == message)
    }

    @Test
    fun `assertTrue should pass for true`() {
        true.assertTrue()
    }

    @Test
    fun `assertTrue should fail for false`() {
        assertFailsWith<AssertionError> { false.assertTrue() }
    }

    @Test
    fun `assertTrue should fail for false with custom message`() {
        val message = "Custom error message"
        val exception = assertFailsWith<AssertionError> { false.assertTrue(message) }
        assertTrue(exception.message == message)
    }
}
