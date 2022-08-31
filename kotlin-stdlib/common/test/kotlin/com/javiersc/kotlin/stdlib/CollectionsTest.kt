@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

internal class CollectionsTest {

    private val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private val numbersIterable: Iterable<Int> = IntRange(1, 10)
    private val chars: List<Char> = listOf('A', 'B', 'C', 'D', 'E', 'F')
    private val charsIterable: Iterable<Char> = CharRange('A', 'F')
    private val empty: List<Char> = emptyList()
    private val emptyIterable: Iterable<Char> = CharRange.EMPTY

    @Test
    fun collection_second() {
        assertTrue { numbers.second() == 2 }
        assertTrue { numbersIterable.second() == 2 }
        assertTrue { numbers.secondOrNull() == 2 }
        assertTrue { numbersIterable.secondOrNull() == 2 }

        assertTrue { chars.second() == 'B' }
        assertTrue { charsIterable.second() == 'B' }
        assertTrue { charsIterable.secondOrNull() == 'B' }

        assertFailsWith<NoSuchElementException> { empty.second() }
        assertFailsWith<NoSuchElementException> { emptyIterable.second() }

        assertTrue { empty.secondOrNull() == null }
        assertTrue { emptyIterable.secondOrNull() == null }
    }

    @Test
    fun collection_third() {
        assertTrue { numbers.third() == 3 }
        assertTrue { numbersIterable.third() == 3 }
        assertTrue { numbers.thirdOrNull() == 3 }
        assertTrue { numbersIterable.thirdOrNull() == 3 }

        assertTrue { chars.third() == 'C' }
        assertTrue { charsIterable.third() == 'C' }
        assertTrue { chars.thirdOrNull() == 'C' }
        assertTrue { charsIterable.thirdOrNull() == 'C' }

        assertFailsWith<NoSuchElementException> { empty.third() }
        assertFailsWith<NoSuchElementException> { emptyIterable.third() }

        assertTrue { empty.thirdOrNull() == null }
        assertTrue { emptyIterable.thirdOrNull() == null }
    }

    @Test
    fun collection_forth() {
        assertTrue { numbers.forth() == 4 }
        assertTrue { numbersIterable.forth() == 4 }
        assertTrue { numbers.forthOrNull() == 4 }
        assertTrue { numbersIterable.forthOrNull() == 4 }

        assertTrue { chars.forth() == 'D' }
        assertTrue { charsIterable.forth() == 'D' }
        assertTrue { charsIterable.forthOrNull() == 'D' }

        assertFailsWith<NoSuchElementException> { empty.forth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.forth() }

        assertTrue { empty.forthOrNull() == null }
        assertTrue { emptyIterable.forthOrNull() == null }
    }

    @Test
    fun collection_fifth() {
        assertTrue { numbers.fifth() == 5 }
        assertTrue { numbersIterable.fifth() == 5 }
        assertTrue { numbers.fifthOrNull() == 5 }
        assertTrue { numbersIterable.fifthOrNull() == 5 }

        assertTrue { chars.fifth() == 'E' }
        assertTrue { charsIterable.fifth() == 'E' }
        assertTrue { chars.fifthOrNull() == 'E' }
        assertTrue { charsIterable.fifthOrNull() == 'E' }

        assertFailsWith<NoSuchElementException> { empty.fifth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.fifth() }

        assertTrue { empty.fifthOrNull() == null }
        assertTrue { emptyIterable.fifthOrNull() == null }
    }

    @Test
    fun collection_penultimate() {
        assertTrue { numbers.penultimate() == 9 }
        assertTrue { numbersIterable.penultimate() == 9 }
        assertTrue { numbers.penultimateOrNull() == 9 }
        assertTrue { numbersIterable.penultimateOrNull() == 9 }

        assertTrue { chars.penultimate() == 'E' }
        assertTrue { charsIterable.penultimate() == 'E' }
        assertTrue { chars.penultimateOrNull() == 'E' }
        assertTrue { charsIterable.penultimateOrNull() == 'E' }

        assertFailsWith<NoSuchElementException> { empty.penultimate() }
        assertFailsWith<NoSuchElementException> { emptyIterable.penultimate() }

        assertTrue { empty.penultimateOrNull() == null }
        assertTrue { emptyIterable.penultimateOrNull() == null }

        assertFailsWith<NoSuchElementException> { listOf(1).penultimate() }
        assertFailsWith<NoSuchElementException> { listOf(1).asIterable().penultimate() }
    }

    @Test
    fun remove_duplicate_empty_lines() {
        assertTrue {
            listOf("a", "b", "", "", "c", "").removeDuplicateEmptyLines() == "a\nb\n\nc\n"
        }
        assertTrue {
            listOf("a", "b", "", "", "", "c", "").removeDuplicateEmptyLines() == "a\nb\n\nc\n"
        }
        assertTrue {
            listOf("a", "b", "", "", "c", "", "").removeDuplicateEmptyLines() == "a\nb\n\nc\n"
        }
        assertTrue {
            listOf("a", "", "", "", "b", "", "").removeDuplicateEmptyLines() == "a\n\nb\n"
        }
        assertTrue { emptyList<String>().removeDuplicateEmptyLines() == "" }
        assertTrue { listOf("").removeDuplicateEmptyLines() == "" }
    }
}
