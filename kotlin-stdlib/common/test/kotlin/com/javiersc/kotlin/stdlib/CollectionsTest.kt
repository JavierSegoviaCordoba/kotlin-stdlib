@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class CollectionsTest {

    private val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private val chars: Iterable<Char> = listOf('A', 'B', 'C', 'D', 'E', 'F').asIterable()
    private val empty: List<String> = emptyList()
    private val emptyIterable: Iterable<String> = emptyList<String>().asIterable()

    @Test
    fun collection_second() {
        numbers.second().shouldBe(2)
        numbers.secondOrNull().shouldBe(2)

        chars.second().shouldBe('B')
        chars.secondOrNull().shouldBe('B')

        shouldThrow<NoSuchElementException> { empty.second() }
        shouldThrow<NoSuchElementException> { emptyIterable.second() }
        empty.secondOrNull().shouldBe(null)
        emptyIterable.secondOrNull().shouldBe(null)
    }

    @Test
    fun collection_third() {
        numbers.third().shouldBe(3)
        numbers.thirdOrNull().shouldBe(3)

        chars.third().shouldBe('C')
        chars.thirdOrNull().shouldBe('C')

        shouldThrow<NoSuchElementException> { empty.third() }
        shouldThrow<NoSuchElementException> { emptyIterable.third() }
        empty.thirdOrNull().shouldBe(null)
        emptyIterable.thirdOrNull().shouldBe(null)
    }

    @Test
    fun collection_forth() {
        numbers.forth().shouldBe(4)
        numbers.forthOrNull().shouldBe(4)

        chars.forth().shouldBe('D')
        chars.forthOrNull().shouldBe('D')

        shouldThrow<NoSuchElementException> { empty.forth() }
        shouldThrow<NoSuchElementException> { emptyIterable.forth() }
        empty.forthOrNull().shouldBe(null)
        emptyIterable.forthOrNull().shouldBe(null)
    }

    @Test
    fun collection_fifth() {
        numbers.fifth().shouldBe(5)
        numbers.fifthOrNull().shouldBe(5)

        chars.fifth().shouldBe('E')
        chars.fifthOrNull().shouldBe('E')

        shouldThrow<NoSuchElementException> { empty.fifth() }
        shouldThrow<NoSuchElementException> { emptyIterable.fifth() }
        empty.fifthOrNull().shouldBe(null)
        emptyIterable.fifthOrNull().shouldBe(null)
    }

    @Test
    fun collection_penultimate() {
        numbers.penultimate().shouldBe(9)
        numbers.penultimateOrNull().shouldBe(9)

        chars.penultimate().shouldBe('E')
        chars.penultimateOrNull().shouldBe('E')

        shouldThrow<NoSuchElementException> { empty.penultimate() }
        shouldThrow<NoSuchElementException> { emptyIterable.penultimate() }
        empty.penultimateOrNull().shouldBe(null)
        emptyIterable.penultimateOrNull().shouldBe(null)

        shouldThrow<NoSuchElementException> { listOf(1).penultimate() }
        shouldThrow<NoSuchElementException> { listOf(1).asIterable().penultimate() }
    }

    @Test
    fun remove_duplicate_empty_lines() {
        listOf("a", "b", "", "", "c", "").removeDuplicateEmptyLines().shouldBe("a\nb\n\nc\n")
        listOf("a", "b", "", "", "", "c", "").removeDuplicateEmptyLines().shouldBe("a\nb\n\nc\n")
        listOf("a", "b", "", "", "c", "", "").removeDuplicateEmptyLines().shouldBe("a\nb\n\nc\n")
        listOf("a", "", "", "", "b", "", "").removeDuplicateEmptyLines().shouldBe("a\n\nb\n")
        emptyList<String>().removeDuplicateEmptyLines().shouldBe("")
        listOf("").removeDuplicateEmptyLines().shouldBe("")
    }
}
