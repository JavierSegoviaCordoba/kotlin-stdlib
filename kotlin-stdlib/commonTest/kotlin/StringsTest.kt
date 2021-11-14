package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringsTest {

    @Test
    fun string_remove() {
        assertTrue { "Hello, World".remove("Hello, ") == "World" }
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
}
