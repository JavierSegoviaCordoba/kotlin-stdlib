package com.javiersc.kotlin.stdlib

import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import kotlin.test.Test

class StringsTest {

    @Test
    fun string_remove() {
        "Hello, World".remove("Hello, ").shouldBe("World")
        "Hello, World".remove("bla").shouldBe("Hello, World")
        "Hello, World".remove("llo", "rld").shouldBe("He, Wo")
    }

    @Test
    fun string_replace() {
        "Hello, World".replace("ello" to "ELLO", "orld" to "ORLD").shouldBe("HELLO, WORLD")
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
        String.Empty.shouldBeEmpty()
    }

    @Test
    fun remove_duplicate_empty_lines() {
        "a\nb\n\n\nc\n".removeDuplicateEmptyLines().shouldBe("a\nb\n\nc\n")
        "a\n\nb\n\n\nc\n".removeDuplicateEmptyLines().shouldBe("a\n\nb\n\nc\n")
        "a\n\nb\n\n\nc\n\n".removeDuplicateEmptyLines().shouldBe("a\n\nb\n\nc\n")
        "a\n\n\n\n\nb\n\n".removeDuplicateEmptyLines().shouldBe("a\n\nb\n")
    }

    @Test
    fun end_with_new_line() {
        "a".endWithNewLine().shouldBe("a\n")
        "a\n".endWithNewLine().shouldBe("a\n")
        "".endWithNewLine().shouldBe("")
        "a\nb".endWithNewLine().shouldBe("a\nb\n")
        "".endWithNewLine().shouldBe("")
        "\n".endWithNewLine().shouldBe("\n")
    }
}
