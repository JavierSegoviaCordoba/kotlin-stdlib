package com.javiersc.kotlin.test

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class GenericMatchersTest {

    @Test
    fun `assertNotNull passes with non-null value`() {
        val value: String? = "test"
        val result: String = value.assertNotNull()
        assertTrue(result == "test")
    }

    @Test
    fun `assertNotNull fails with null value`() {
        val value: String? = null
        assertFailsWith<AssertionError> { value.assertNotNull() }
    }

    @Test
    fun `assertNull passes with null value`() {
        val value: String? = null
        value.assertNull()
    }

    @Test
    fun `assertNull fails with non-null value`() {
        val value: String? = "test"
        assertFailsWith<AssertionError> { value.assertNull() }
    }

    @Test
    fun `assertEquals passes with equal values`() {
        val value = "test"
        val result = value.assertEquals("test")
        assertTrue(result == "test")
    }

    @Test
    fun `assertEquals fails with different values`() {
        val value = "test"
        assertFailsWith<AssertionError> { value.assertEquals("other") }
    }

    @Test
    fun `assertNotEquals passes with different values`() {
        val value = "test"
        val result = value.assertNotEquals("other")
        assertTrue(result == "test")
    }

    @Test
    fun `assertNotEquals fails with equal values`() {
        val value = "test"
        assertFailsWith<AssertionError> { value.assertNotEquals("test") }
    }

    @Test
    fun `assertIs passes with correct type`() {
        val value: Any = "test"
        val result: String = value.assertIs()
        assertTrue(result == "test")
    }

    @Test
    fun `assertIs fails with wrong type`() {
        val value: Any = "test"
        assertFailsWith<AssertionError> { value.assertIs<Int>() }
    }

    @Test
    fun `assertIsNot passes with different type`() {
        val value: Any = "test"
        value.assertIsNot<Int>()
    }

    @Test
    fun `assertIsNot fails with same type`() {
        val value: Any = "test"
        assertFailsWith<AssertionError> { value.assertIsNot<String>() }
    }

    @Test
    fun `typed assertIsNot passes with different type`() {
        val value = "test"
        value.assertIsNot<Int>()
    }

    @Test
    fun `typed assertIsNot fails with same type`() {
        val value = "test"
        assertFailsWith<AssertionError> { value.assertIsNot<String>() }
    }
}
