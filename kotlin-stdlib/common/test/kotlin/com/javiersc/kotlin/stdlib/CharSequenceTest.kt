@file:Suppress("RedundantExplicitType")

package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CharSequenceTest {

    @Test
    fun given_a_null_CharSequence_when_isNotNullNorEmpty_is_invoked_then_it_returns_false() {
        assertFalse(null.isNotNullNorEmpty())
    }

    @Test
    fun given_a_empty_CharSequence_when_isNotNullNorEmpty_is_invoked_then_it_returns_false() {
        assertFalse("".isNotNullNorEmpty())
    }

    @Test
    fun given_a_blank_CharSequence_when_isNotNullNorEmpty_is_invoked_then_it_returns_true() {
        assertTrue(" ".isNotNullNorEmpty())
        assertTrue("    ".isNotNullNorEmpty())
    }

    @Test
    fun given_a_not_blank_CharSequence_when_isNotNullNorEmpty_is_invoked_then_it_returns_true() {
        assertTrue("foo".isNotNullNorEmpty())
        assertTrue(" f".isNotNullNorEmpty())
        assertTrue("f ".isNotNullNorEmpty())
        assertTrue(" foo ".isNotNullNorEmpty())
        assertTrue(" f o ".isNotNullNorEmpty())
    }

    @Test
    fun given_a_null_CharSequence_when_isNotNullNorBlank_is_invoked_then_it_returns_false() {
        assertFalse(null.isNotNullNorBlank())
    }

    @Test
    fun given_a_empty_CharSequence_when_isNotNullOrBlank_is_invoked_then_it_returns_false() {
        assertFalse("".isNotNullNorBlank())
    }

    @Test
    fun given_a_blank_CharSequence_when_isNotNullNorBlank_is_invoked_then_it_returns_false() {
        assertFalse(" ".isNotNullNorBlank())
        assertFalse("    ".isNotNullNorBlank())
    }

    @Test
    fun given_a_not_blank_CharSequence_when_isNotNullOrBlank_is_invoked_then_it_returns_true() {
        assertTrue("foo".isNotNullNorBlank())
        assertTrue(" f".isNotNullNorBlank())
        assertTrue("f ".isNotNullNorBlank())
        assertTrue(" foo ".isNotNullNorBlank())
        assertTrue(" f o ".isNotNullNorBlank())
    }

    @Test
    fun string_not_contain() {
        assertFalse { "Hello World".notContain("Hello") }
        assertFalse { "HELLO World".notContain("hello", ignoreCase = true) }
        assertTrue { "Hello World".notContain("hello") }
        assertTrue { "Hello World".notContain("hello", ignoreCase = false) }

        val regex = Regex("[0-9]+")
        assertFalse { "Hello World 1".notContain(regex) }
        assertTrue { "Hello World".notContain(regex) }
    }
}
