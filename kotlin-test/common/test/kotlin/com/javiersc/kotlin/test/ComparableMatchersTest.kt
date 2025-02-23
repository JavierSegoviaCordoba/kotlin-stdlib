package com.javiersc.kotlin.test

import com.javiersc.kotlin.stdlib.CurrentPlatform
import com.javiersc.kotlin.stdlib.Platform
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class ComparableMatchersTest {

    private val oneDouble =
        when (CurrentPlatform) {
            is Platform.JS -> "1"
            else -> "1.0"
        }

    private val twoDouble =
        when (CurrentPlatform) {
            is Platform.JS -> "2"
            else -> "2.0"
        }

    @Test
    fun `assertGreaterThan passes when Byte is greater`() {
        val result: Byte = 2.toByte().assertGreaterThan(1.toByte())
        assertTrue(result == 2.toByte())
    }

    @Test
    fun `assertGreaterThan fails when Byte is less`() {
        val exception: AssertionError = assertFailsWith { 1.toByte().assertGreaterThan(2.toByte()) }
        assertTrue(exception.message == "1 is not greater than 2")
    }

    @Test
    fun `assertGreaterThan fails when Byte is the same`() {
        val exception: AssertionError = assertFailsWith { 1.toByte().assertGreaterThan(1.toByte()) }
        assertTrue(exception.message == "1 is not greater than 1")
    }

    @Test
    fun `assertGreaterThan fails when Byte is less with custom message`() {
        val exception: AssertionError = assertFailsWith {
            1.toByte().assertGreaterThan(2.toByte(), "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan passes when Short is greater`() {
        val result: Short = 2.toShort().assertGreaterThan(1.toShort())
        assertTrue(result == 2.toShort())
    }

    @Test
    fun `assertGreaterThan fails when Short is less with custom message`() {
        val exception: AssertionError = assertFailsWith {
            1.toShort().assertGreaterThan(2.toShort(), "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan fails when Short is less`() {
        val exception: AssertionError = assertFailsWith {
            1.toShort().assertGreaterThan(2.toShort())
        }
        assertTrue(exception.message == "1 is not greater than 2")
    }

    @Test
    fun `assertGreaterThan passes when Int is greater`() {
        val result: Int = 2.assertGreaterThan(1)
        assertTrue(result == 2)
    }

    @Test
    fun `assertGreaterThan fails when Int is less`() {
        val exception: AssertionError = assertFailsWith { 1.assertGreaterThan(2) }
        assertTrue(exception.message == "1 is not greater than 2")
    }

    @Test
    fun `assertGreaterThan fails when Int is less custom error`() {
        val exception: AssertionError = assertFailsWith { 1.assertGreaterThan(2, "Custom error") }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan passes when Long is greater`() {
        val result: Long = 2L.assertGreaterThan(1L)
        assertTrue(result == 2L)
    }

    @Test
    fun `assertGreaterThan fails when Long is less`() {
        val exception: AssertionError = assertFailsWith { 1L.assertGreaterThan(2L) }
        assertTrue(exception.message == "1 is not greater than 2")
    }

    @Test
    fun `assertGreaterThan fails when Long is less custom error`() {
        val exception: AssertionError = assertFailsWith { 1L.assertGreaterThan(2L, "Custom error") }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan passes when Float is greater`() {
        val result: Float = 2.0f.assertGreaterThan(1.0f)
        assertTrue(result == 2.0f)
    }

    @Test
    fun `assertGreaterThan fails when Float is less custom error`() {
        val exception: AssertionError = assertFailsWith {
            1.0f.assertGreaterThan(2.0f, "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan fails when Float is less`() {
        val exception: AssertionError = assertFailsWith { 1.0f.assertGreaterThan(2.0f) }
        assertTrue(exception.message == "$oneDouble is not greater than $twoDouble")
    }

    @Test
    fun `assertGreaterThan passes when Double is greater`() {
        val result: Double = 2.0.assertGreaterThan(1.0)
        assertTrue(result == 2.0)
    }

    @Test
    fun `assertGreaterThan fails when Double is less custom error`() {
        val exception: AssertionError = assertFailsWith {
            1.0.assertGreaterThan(2.0, "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan fails when Double is less`() {
        val exception: AssertionError = assertFailsWith { 1.0.assertGreaterThan(2.0) }
        assertTrue(exception.message == "$oneDouble is not greater than $twoDouble")
    }

    @Test
    fun `assertGreaterThan passes when Duration is greater`() {
        val result: Duration = 2.seconds.assertGreaterThan(1.seconds)
        assertTrue(result == 2.seconds)
    }

    @Test
    fun `assertGreaterThan fails when Duration is less custom error`() {
        val exception: AssertionError = assertFailsWith {
            1.seconds.assertGreaterThan(2.seconds, "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan fails when Duration is less`() {
        val exception: AssertionError = assertFailsWith {
            1.seconds.assertGreaterThan(2.seconds, "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertGreaterThan fails with custom message`() {
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith { 1.assertGreaterThan(2, message) }
        assertTrue(exception.message == message)
    }

    @Test
    fun `assertLessThan passes when Byte is less`() {
        val result: Byte = 1.toByte().assertLessThan(2.toByte())
        assertTrue(result == 1.toByte())
    }

    @Test
    fun `assertLessThan fails when Byte is greater custom error`() {
        val exception: AssertionError = assertFailsWith {
            2.toByte().assertLessThan(1.toByte(), "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertLessThan fails when Byte is greater`() {
        val exception: AssertionError = assertFailsWith { 2.toByte().assertLessThan(1.toByte()) }
        assertTrue(exception.message == "2 is not less than 1")
    }

    @Test
    fun `assertLessThan fails when Byte is the same`() {
        val exception: AssertionError = assertFailsWith { 1.toByte().assertLessThan(1.toByte()) }
        assertTrue(exception.message == "1 is not less than 1")
    }

    @Test
    fun `assertLessThan passes when Short is less`() {
        val result: Short = 1.toShort().assertLessThan(2.toShort())
        assertTrue(result == 1.toShort())
    }

    @Test
    fun `assertLessThan fails when Short is greater with custom error`() {
        val exception: AssertionError = assertFailsWith {
            2.toShort().assertLessThan(1.toShort(), "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertLessThan fails when Short is greater`() {
        val exception: AssertionError = assertFailsWith { 2.toShort().assertLessThan(1.toShort()) }
        assertTrue(exception.message == "2 is not less than 1")
    }

    @Test
    fun `assertLessThan passes when Int is less`() {
        val result: Int = 1.assertLessThan(2)
        assertTrue(result == 1)
    }

    @Test
    fun `assertLessThan fails when Int is greater with custom error`() {
        val exception: AssertionError = assertFailsWith { 2.assertLessThan(1, "Custom error") }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertLessThan fails when Int is greater`() {
        val exception: AssertionError = assertFailsWith { 2.assertLessThan(1) }
        assertTrue(exception.message == "2 is not less than 1")
    }

    @Test
    fun `assertLessThan passes when Long is less`() {
        val result: Long = 1L.assertLessThan(2L)
        assertTrue(result == 1L)
    }

    @Test
    fun `assertLessThan fails when Long is greater with custom error`() {
        val exception: AssertionError = assertFailsWith { 2L.assertLessThan(1L, "Custom error") }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertLessThan fails when Long is greater`() {
        val exception: AssertionError = assertFailsWith { 2L.assertLessThan(1L) }
        assertTrue(exception.message == "2 is not less than 1")
    }

    @Test
    fun `assertLessThan passes when Float is less`() {
        val result: Float = 1.0f.assertLessThan(2.0f)
        assertTrue(result == 1.0f)
    }

    @Test
    fun `assertLessThan fails when Float is greater with custom error`() {
        val exception: AssertionError = assertFailsWith { 2.0f.assertLessThan(1.0f) }
        assertTrue(exception.message == "$twoDouble is not less than $oneDouble")
    }

    @Test
    fun `assertLessThan fails when Float is greater`() {
        val exception: AssertionError = assertFailsWith { 2.0f.assertLessThan(1.0f) }
        assertTrue(exception.message == "$twoDouble is not less than $oneDouble")
    }

    @Test
    fun `assertLessThan passes when Double is less`() {
        val result: Double = 1.0.assertLessThan(2.0)
        assertTrue(result == 1.0)
    }

    @Test
    fun `assertLessThan fails when Double is greater with custom error`() {
        val exception: AssertionError = assertFailsWith { 2.0.assertLessThan(1.0, "Custom error") }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertLessThan fails when Double is greater`() {
        val exception: AssertionError = assertFailsWith { 2.0.assertLessThan(1.0) }
        assertTrue(exception.message == "$twoDouble is not less than $oneDouble")
    }

    @Test
    fun `assertLessThan passes when Duration is less`() {
        val result: Duration = 1.seconds.assertLessThan(2.seconds)
        assertTrue(result == 1.seconds)
    }

    @Test
    fun `assertLessThan fails when Duration is greater with custom error`() {
        val exception: AssertionError = assertFailsWith {
            2.seconds.assertLessThan(1.seconds, "Custom error")
        }
        assertTrue(exception.message == "Custom error")
    }

    @Test
    fun `assertLessThan fails when Duration is greater`() {
        val exception: AssertionError = assertFailsWith { 2.seconds.assertLessThan(1.seconds) }
        assertTrue(exception.message == "2s is not less than 1s")
    }

    @Test
    fun `assertLessThan fails with custom message`() {
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith { 2.assertLessThan(1, message) }
        assertTrue(exception.message == message)
    }
}
