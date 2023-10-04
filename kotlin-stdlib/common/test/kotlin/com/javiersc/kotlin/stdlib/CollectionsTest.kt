@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

internal class CollectionsTest {

    private val numbers: List<Int> = (1..10).toList()
    private val numbersIterable: Iterable<Int> = IntRange(1, 10)
    private val chars: List<Char> = ('A'..'Z').toList()
    private val charsIterable: Iterable<Char> = CharRange('A', 'Z')
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
    fun collection_sixth() {
        assertTrue { numbers.sixth() == 6 }
        assertTrue { numbersIterable.sixth() == 6 }
        assertTrue { numbers.sixthOrNull() == 6 }
        assertTrue { numbersIterable.sixthOrNull() == 6 }

        assertTrue { chars.sixth() == 'F' }
        assertTrue { charsIterable.sixth() == 'F' }
        assertTrue { chars.sixthOrNull() == 'F' }
        assertTrue { charsIterable.sixthOrNull() == 'F' }

        assertFailsWith<NoSuchElementException> { empty.sixth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.sixth() }

        assertTrue { empty.sixthOrNull() == null }
        assertTrue { emptyIterable.sixthOrNull() == null }
    }

    @Test
    fun collection_seventh() {
        assertTrue { numbers.seventh() == 7 }
        assertTrue { numbersIterable.seventh() == 7 }
        assertTrue { numbers.seventhOrNull() == 7 }
        assertTrue { numbersIterable.seventhOrNull() == 7 }

        assertTrue { chars.seventh() == 'G' }
        assertTrue { charsIterable.seventh() == 'G' }
        assertTrue { chars.seventhOrNull() == 'G' }
        assertTrue { charsIterable.seventhOrNull() == 'G' }

        assertFailsWith<NoSuchElementException> { empty.seventh() }
        assertFailsWith<NoSuchElementException> { emptyIterable.seventh() }

        assertTrue { empty.seventhOrNull() == null }
        assertTrue { emptyIterable.seventhOrNull() == null }
    }

    @Test
    fun collection_eighth() {
        assertTrue { numbers.eighth() == 8 }
        assertTrue { numbersIterable.eighth() == 8 }
        assertTrue { numbers.eighthOrNull() == 8 }
        assertTrue { numbersIterable.eighthOrNull() == 8 }

        assertTrue { chars.eighth() == 'H' }
        assertTrue { charsIterable.eighth() == 'H' }
        assertTrue { chars.eighthOrNull() == 'H' }
        assertTrue { charsIterable.eighthOrNull() == 'H' }

        assertFailsWith<NoSuchElementException> { empty.eighth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.eighth() }

        assertTrue { empty.eighthOrNull() == null }
        assertTrue { emptyIterable.eighthOrNull() == null }
    }

    @Test
    fun collection_ninth() {
        assertTrue { numbers.ninth() == 9 }
        assertTrue { numbersIterable.ninth() == 9 }
        assertTrue { numbers.ninthOrNull() == 9 }
        assertTrue { numbersIterable.ninthOrNull() == 9 }

        assertTrue { chars.ninth() == 'I' }
        assertTrue { charsIterable.ninth() == 'I' }
        assertTrue { chars.ninthOrNull() == 'I' }
        assertTrue { charsIterable.ninthOrNull() == 'I' }

        assertFailsWith<NoSuchElementException> { empty.ninth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.ninth() }

        assertTrue { empty.ninthOrNull() == null }
        assertTrue { emptyIterable.ninthOrNull() == null }
    }

    @Test
    fun collection_tenth() {
        assertTrue { numbers.tenth() == 10 }
        assertTrue { numbersIterable.tenth() == 10 }
        assertTrue { numbers.tenthOrNull() == 10 }
        assertTrue { numbersIterable.tenthOrNull() == 10 }

        assertTrue { chars.tenth() == 'J' }
        assertTrue { charsIterable.tenth() == 'J' }
        assertTrue { chars.tenthOrNull() == 'J' }
        assertTrue { charsIterable.tenthOrNull() == 'J' }

        assertFailsWith<NoSuchElementException> { empty.tenth() }
        assertFailsWith<NoSuchElementException> { emptyIterable.tenth() }

        assertTrue { empty.tenthOrNull() == null }
        assertTrue { emptyIterable.tenthOrNull() == null }
    }

    @Test
    fun collection_penultimate() {
        assertTrue { numbers.penultimate() == 9 }
        assertTrue { numbersIterable.penultimate() == 9 }
        assertTrue { numbers.penultimateOrNull() == 9 }
        assertTrue { numbersIterable.penultimateOrNull() == 9 }

        assertTrue { chars.penultimate() == 'Y' }
        assertTrue { charsIterable.penultimate() == 'Y' }
        assertTrue { chars.penultimateOrNull() == 'Y' }
        assertTrue { charsIterable.penultimateOrNull() == 'Y' }

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
