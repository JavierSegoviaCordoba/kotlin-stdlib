package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringsTest {

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
        val blank = " "
        val empty = ""
        val notBlank = "Hello, World"

        assertFalse { nullable.isNotNullNorBlank() }
        assertFalse { nullable.isNotNullNorEmpty() }
        assertFalse { blank.isNotNullNorBlank() }
        assertTrue { blank.isNotNullNorEmpty() }
        assertFalse { empty.isNotNullNorBlank() }
        assertFalse { empty.isNotNullNorEmpty() }
        assertTrue { notBlank.isNotNullNorBlank() }
        assertTrue { notBlank.isNotNullNorEmpty() }
    }

    @Test
    fun empty_string() {
        assertTrue { String.Empty == "" }
    }

    @Test
    fun remove_duplicate_empty_lines() {
        assertTrue { "a\nb\n\n\nc\n".removeDuplicateEmptyLines() == "a\nb\n\nc\n" }
        assertTrue { "a\n\nb\n\n\nc\n".removeDuplicateEmptyLines() == "a\n\nb\n\nc\n" }
        assertTrue { "a\n\nb\n\n\nc\n\n".removeDuplicateEmptyLines() == "a\n\nb\n\nc\n" }
        assertTrue { "a\n\n\n\n\nb\n\n".removeDuplicateEmptyLines() == "a\n\nb\n" }
    }

    @Test
    fun end_with_new_line() {
        assertTrue { "a".endWithNewLine() == "a\n" }
        assertTrue { "a\n".endWithNewLine() == "a\n" }
        assertTrue { "".endWithNewLine() == "" }
        assertTrue { "a\nb".endWithNewLine() == "a\nb\n" }
        assertTrue { "".endWithNewLine() == "" }
        assertTrue { "\n".endWithNewLine() == "\n" }
    }
}
