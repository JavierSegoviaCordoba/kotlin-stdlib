package com.javiersc.kotlin.test

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class GenericMatchersTest {

    @Test
    fun `assertInstance should pass for correct type`() {
        val value: Any = "test"
        val result: String = value.assertIs()
        assertTrue(result == "test")
    }

    @Test
    fun `assertInstance should fail for incorrect type`() {
        val value: Any = 123
        assertFailsWith<AssertionError> { value.assertIs<String>() }
    }

    @Test
    fun `assertInstance should fail with custom message`() {
        val value: Any = 123
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith { value.assertIs<String>(message) }
        assertTrue(exception.message == message)
    }
}
