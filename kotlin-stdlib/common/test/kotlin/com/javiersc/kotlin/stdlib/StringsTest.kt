@file:Suppress("RedundantExplicitType")

package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class StringsTest {

    @Test
    fun string_capitalize() {
        assertTrue { "hello".capitalize() == "Hello" }
        assertTrue { "Hello".capitalize() == "Hello" }
        assertTrue { "hElLo".capitalize() == "HElLo" }
    }

    @Test
    fun string_decapitalize() {
        assertTrue { "hello".decapitalize() == "hello" }
        assertTrue { "Hello".decapitalize() == "hello" }
        assertTrue { "HElLo".decapitalize() == "hElLo" }
    }

    @Test
    fun string_not_contain() {
        assertFalse { "Hello, World".notContain("Hello") }
        assertFalse { "HELLO, World".notContain("hello", ignoreCase = true) }
        assertTrue { "Hello, World".notContain("hello") }
        assertTrue { "Hello, World".notContain("hello", ignoreCase = false) }

        val regex = Regex("[0-9]+")
        assertFalse { "Hello, World 1".notContain(regex) }
        assertTrue { "Hello, World".notContain(regex) }
    }

    @Test
    fun string_remove() {
        assertTrue { "Hello, World".remove("Hello, ") == "World" }
        assertTrue { "Hello, World".remove("bla") == "Hello, World" }
        assertTrue { "Hello, World".remove("llo", "rld") == "He, Wo" }
    }

    @Test
    fun string_replace() {
        assertTrue { "Hello, World".replace("ello" to "ELLO", "orld" to "ORLD") == "HELLO, WORLD" }
    }

    @Test
    fun string_isNotNullNorEmpty_and_string_isNotNullNorBlank() {
        val nullable: String? = null
        val nullableCharSequence: CharSequence? = null
        val blank: String = " "
        val blankCharSequence: CharSequence = " "
        val empty: String = ""
        val emptyCharSequence: CharSequence = ""
        val notBlank: String = "Hello, World"
        val notBlankCharSequence: CharSequence = "Hello, World"

        assertFalse { nullable.isNotNullNorEmpty() }
        assertFalse { nullableCharSequence.isNotNullNorEmpty() }
        assertTrue { blank.isNotNullNorEmpty() }
        assertTrue { blankCharSequence.isNotNullNorEmpty() }
        assertFalse { empty.isNotNullNorEmpty() }
        assertFalse { emptyCharSequence.isNotNullNorEmpty() }
        assertTrue { notBlank.isNotNullNorEmpty() }
        assertTrue { notBlankCharSequence.isNotNullNorEmpty() }

        assertFalse { nullable.isNotNullNorBlank() }
        assertFalse { nullableCharSequence.isNotNullNorBlank() }
        assertFalse { blank.isNotNullNorBlank() }
        assertFalse { blankCharSequence.isNotNullNorBlank() }
        assertFalse { empty.isNotNullNorBlank() }
        assertFalse { emptyCharSequence.isNotNullNorBlank() }
        assertTrue { notBlank.isNotNullNorBlank() }
        assertTrue { notBlankCharSequence.isNotNullNorBlank() }
    }

    @Test
    fun empty_string() {
        assertTrue { String.Empty == "" }
    }

    @Test
    fun string_remove_duplicate_empty_lines() {
        assertTrue { "a\nb\n\n\nc\n".removeDuplicateEmptyLines() == "a\nb\n\nc\n" }
        assertTrue { "a\n\nb\n\n\nc\n".removeDuplicateEmptyLines() == "a\n\nb\n\nc\n" }
        assertTrue { "a\n\nb\n\n\nc\n\n".removeDuplicateEmptyLines() == "a\n\nb\n\nc\n" }
        assertTrue { "a\n\n\n\n\nb\n\n".removeDuplicateEmptyLines() == "a\n\nb\n" }
    }

    @Test
    fun string_end_with_new_line() {
        assertTrue { "a".endWithNewLine() == "a\n" }
        assertTrue { "a\n".endWithNewLine() == "a\n" }
        assertTrue { "".endWithNewLine() == "" }
        assertTrue { "a\nb".endWithNewLine() == "a\nb\n" }
        assertTrue { "".endWithNewLine() == "" }
        assertTrue { "\n".endWithNewLine() == "\n" }
        assertTrue {
            """
                |Hello, World
                |
            """
                .trimMargin()
                .endWithNewLine() ==
                """
                    |Hello, World
                    |
                """.trimMargin()
        }
    }
}
