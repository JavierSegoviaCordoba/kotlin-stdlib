package com.javiersc.kotlin.test

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class CharSequenceMatchersTest {

    @Test
    fun `assertStartWith should pass when prefix matches`() {
        val result: String = "hello".assertStartWith("he")
        assertTrue(result == "hello")
    }

    @Test
    fun `assertStartWith should fail when prefix does not match`() {
        val exception: AssertionError = assertFailsWith {
            "hello".assertStartWith("hi", "Custom error message")
        }
        assertTrue(exception.message == "Custom error message")
    }

    @Test
    fun `assertStartWith should fail with default message when prefix does not match`() {
        val exception: AssertionError = assertFailsWith { "hello".assertStartWith("hi") }
        assertTrue(exception.message == "hello does not start with hi")
    }

    @Test
    fun `assertNotStartWith should pass when prefix does not match`() {
        val result = "hello".assertNotStartWith("hi")
        assertTrue(result == "hello")
    }

    @Test
    fun `assertNotStartWith should fail when prefix matches`() {
        val exception: AssertionError = assertFailsWith {
            "hello".assertNotStartWith("he", "Custom error message")
        }
        assertTrue(exception.message == "Custom error message")
    }

    @Test
    fun `assertNotStartWith should fail with default message when prefix matches`() {
        val exception: AssertionError = assertFailsWith { "hello".assertNotStartWith("he") }
        assertTrue(exception.message == "hello does start with he")
    }
}
