package com.javiersc.kotlin.test

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class StringMatchersTest {

    @Test
    fun `assertNotBlank should pass for non-blank string`() {
        val value = "test"
        val result: String = value.assertNotBlank()
        assertTrue(result === value)
    }

    @Test
    fun `assertNotBlank should fail for blank string`() {
        val value = "   "
        val exception: AssertionError = assertFailsWith { value.assertNotBlank() }
        assertTrue(exception.message == "Expected not blank but was 'null' or blank")
    }

    @Test
    fun `assertNotBlank should fail for null`() {
        val value: String? = null
        val exception: AssertionError = assertFailsWith { value.assertNotBlank() }
        assertTrue(exception.message == "Expected not blank but was 'null' or blank")
    }

    @Test
    fun `assertNotEmpty should pass for non-empty string`() {
        val value = "test"
        val result: String = value.assertNotEmpty()
        assertTrue(result === value)
    }

    @Test
    fun `assertNotEmpty should fail for empty string`() {
        val value = ""
        val exception: AssertionError = assertFailsWith { value.assertNotEmpty() }
        assertTrue(exception.message == "Expected not blank but was 'null' or empty")
    }

    @Test
    fun `assertNotEmpty should fail for null`() {
        val value: String? = null
        val exception: AssertionError = assertFailsWith { value.assertNotEmpty() }
        assertTrue(exception.message == "Expected not blank but was 'null' or empty")
    }
}
