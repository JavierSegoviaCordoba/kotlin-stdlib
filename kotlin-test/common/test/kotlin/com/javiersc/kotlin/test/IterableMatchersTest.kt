package com.javiersc.kotlin.test

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class IterableMatchersTest {

    @Test
    fun `assertContains should fail with custom message`() {
        val list: List<Int> = listOf(1, 2, 3)
        val element = 4
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith { list.assertContains(element, message) }
        assertTrue(
            exception.message ==
                "Custom error message. Expected the collection to contain the element.\n" +
                    "Collection <[1, 2, 3]>, element <4>."
        )
    }

    @Test
    fun `assertContains should work with different types`() {
        val list: List<Double> = listOf(1.0, 2.0, 3.0)
        val element = 2.0
        val result: List<Double> = list.assertContains(element)
        assertTrue(result === list)
    }

    @Test
    fun `assertCount should pass when count matches`() {
        val list: List<Int> = listOf(1, 2, 3)
        val result: List<Int> = list.assertCount(3)
        assertTrue(result === list)
    }

    @Test
    fun `assertCount should fail when count does not match`() {
        val list: List<Int> = listOf(1, 2, 3)
        val exception: AssertionError = assertFailsWith { list.assertCount(2) }
        assertTrue(exception.message == "Expected size 2 but was 3")
    }

    @Test
    fun `assertNotContains should pass when element is not in the iterable`() {
        listOf(1, 2, 3).assertNotContains(4)
    }

    @Test
    fun `assertNotContains should fail when element is in the iterable`() {
        assertFailsWith<AssertionError> { listOf(1, 2, 3).assertNotContains(2) }
    }

    @Test
    fun `assertNotContains should fail with custom message when element is in the iterable`() {
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith {
            listOf(1, 2, 3).assertNotContains(2, message)
        }
        assertTrue(exception.message == message)
    }

    @Test
    fun `assertSize should pass when size matches`() {
        val list: List<Int> = listOf(1, 2, 3)
        val result: List<Int> = list.assertSize(3)
        assertTrue(result === list)
    }

    @Test
    fun `assertSize should fail when size does not match`() {
        val list: List<Int> = listOf(1, 2, 3)
        val exception: AssertionError = assertFailsWith { list.assertSize(2) }
        assertTrue(exception.message == "Expected size 2 but was 3")
    }

    @Test
    fun `assertSize should fail with custom message`() {
        val list: List<Int> = listOf(1, 2, 3)
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith { list.assertSize(2, message) }
        assertTrue(exception.message == message)
    }
}
