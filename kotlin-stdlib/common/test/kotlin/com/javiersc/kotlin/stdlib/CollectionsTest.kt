@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class CollectionsTest {

    private val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private val chars: Iterable<Char> = listOf('A', 'B', 'C', 'D', 'E', 'F').asIterable()
    private val empty: List<String> = emptyList()
    private val emptyIterable: Iterable<String> = emptyList<String>().asIterable()

    @Test
    fun collection_second() {
        assertTrue { numbers.second() == 2 }
        assertTrue { numbers.secondOrNull() == 2 }

        assertTrue { chars.second() == 'B' }
        assertTrue { chars.secondOrNull() == 'B' }

        assertFailsWith<NoSuchElementException> { empty.second() }
        assertFailsWith<NoSuchElementException> { emptyIterable.second() }

        assertTrue { empty.secondOrNull() == null }
        assertTrue { emptyIterable.secondOrNull() == null }
    }

    @Test
    fun collection_third() {
        assertTrue { numbers.third() == 3 }
        assertTrue { numbers.thirdOrNull() == 3 }

        assertTrue { chars.third() == 'C' }
        assertTrue { chars.thirdOrNull() == 'C' }

        assertFailsWith<NoSuchElementException> { empty.third() }
        assertFailsWith<NoSuchElementException> { emptyIterable.third() }

        assertTrue { empty.thirdOrNull() == null }
        assertTrue { emptyIterable.thirdOrNull() == null }
    }

    @Test
    fun collection_forth() {
        assertTrue { numbers.forth() == 4 }
        assertTrue { numbers.forthOrNull() == 4 }

        assertTrue { chars.forth() == 'D' }
        assertTrue { chars.forthOrNull() == 'D' }

        assertFailsWith<NoSuchElementException> { empty.forth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.forth() }

        assertTrue { empty.forthOrNull() == null }
        assertTrue { emptyIterable.forthOrNull() == null }
    }

    @Test
    fun collection_fifth() {
        assertTrue { numbers.fifth() == 5 }
        assertTrue { numbers.fifthOrNull() == 5 }

        assertTrue { chars.fifth() == 'E' }
        assertTrue { chars.fifthOrNull() == 'E' }

        assertFailsWith<NoSuchElementException> { empty.fifth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.fifth() }

        assertTrue { empty.fifthOrNull() == null }
        assertTrue { emptyIterable.fifthOrNull() == null }
    }

    @Test
    fun collection_penultimate() {
        assertTrue { numbers.penultimate() == 9 }
        assertTrue { numbers.penultimateOrNull() == 9 }

        assertTrue { chars.penultimate() == 'E' }
        assertTrue { chars.penultimateOrNull() == 'E' }

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
