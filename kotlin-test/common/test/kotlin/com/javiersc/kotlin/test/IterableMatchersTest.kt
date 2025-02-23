package com.javiersc.kotlin.test

import com.javiersc.kotlin.stdlib.CurrentPlatform
import com.javiersc.kotlin.stdlib.isJS
import com.javiersc.kotlin.stdlib.isNative
import com.javiersc.kotlin.stdlib.isWAsm
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class IterableMatchersTest {

    private val shouldChangeMessage: Boolean
        get() = CurrentPlatform.isJS || CurrentPlatform.isNative || CurrentPlatform.isWAsm

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
    fun `assertContains should fail`() {
        val list: List<Int> = listOf(1, 2, 3)
        val element = 4
        val exception: AssertionError = assertFailsWith { list.assertContains(element) }
        assertTrue(
            exception.message ==
                "Expected the collection to contain the element.\n" +
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
    fun `assertContains should work`() {
        val list: List<String> = listOf("AA", "BB", "CC")
        val element = "BB"
        val result: List<String> = list.assertContains(element)
        assertTrue(result === list)
    }

    @Test
    fun `assertContainsExactly should fail with custom message`() {
        val list: List<Int> = listOf(1, 2, 3)
        val elements: List<Int> = listOf(1, 2, 3, 4)
        val message = "Custom error"
        val exception: AssertionError = assertFailsWith {
            list.assertContainsExactly(elements, message)
        }
        val expectedMessage: String =
            if (shouldChangeMessage) "Custom error. Expected <[1, 2, 3]>, actual <[1, 2, 3, 4]>."
            else "Custom error expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>"
        assertTrue(exception.message == expectedMessage)
    }

    @Test
    fun `assertContainsExactly should fail`() {
        val list: List<Int> = listOf(1, 2, 3)
        val elements: List<Int> = listOf(1, 2, 3, 4)
        val exception: AssertionError = assertFailsWith { list.assertContainsExactly(elements) }
        val expectedMessage: String =
            if (shouldChangeMessage) "Expected <[1, 2, 3]>, actual <[1, 2, 3, 4]>."
            else "expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>"
        assertTrue(exception.message!! == expectedMessage)
    }

    @Test
    fun `assertContainsExactly should fail with more items`() {
        val list: List<Int> = listOf(1, 2, 3, 4, 5)
        val elements: List<Int> = listOf(1, 2, 3, 4)
        val exception: AssertionError = assertFailsWith { list.assertContainsExactly(elements) }
        val expectedMessage: String =
            if (shouldChangeMessage) "Expected <[1, 2, 3, 4, 5]>, actual <[1, 2, 3, 4]>."
            else "expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>"
        assertTrue(exception.message!! == expectedMessage)
    }

    @Test
    fun `assertContainsExactly should work with different types`() {
        val list: List<Double> = listOf(1.0, 2.0, 3.0)
        val elements: List<Double> = listOf(1.0, 2.0, 3.0)
        val result: List<Double> = list.assertContainsExactly(elements)
        assertTrue(result === list)
    }

    @Test
    fun `assertContainsExactly should work`() {
        val list: List<String> = listOf("AA", "BB", "CC")
        val elements: List<String> = listOf("AA", "BB", "CC")
        val result: List<String> = list.assertContainsExactly(elements)
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
