package com.javiersc.kotlin.stdlib

import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class StringsTest {

    @Test
    fun string_remove() {
        "Hello, World".remove("Hello, ").shouldBe("World")
    }

    @Test
    fun string_isNotNullNorEmpty_and_string_isNotNullNorBlank() {
        val nullable: String? = null
        val blank = " "
        val empty = ""
        val notBlank = "Hello, World"

        nullable.isNotNullNorBlank().shouldBeFalse()
        nullable.isNotNullNorEmpty().shouldBeFalse()
        blank.isNotNullNorBlank().shouldBeFalse()
        blank.isNotNullNorEmpty().shouldBeTrue()
        empty.isNotNullNorBlank().shouldBeFalse()
        empty.isNotNullNorEmpty().shouldBeFalse()
        notBlank.isNotNullNorBlank().shouldBeTrue()
        notBlank.isNotNullNorEmpty().shouldBeTrue()
    }

    @Test
    fun empty_string() {
        emptyString().shouldBe("")
    }
}
