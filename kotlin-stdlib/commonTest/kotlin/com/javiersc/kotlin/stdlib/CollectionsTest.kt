@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class CollectionsTest {

    private val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test
    fun collection_second() {
        numbers.second().shouldBe(2)
    }

    @Test
    fun collection_third() {
        numbers.third().shouldBe(3)
    }

    @Test
    fun collection_forth() {
        numbers.forth().shouldBe(4)
    }

    @Test
    fun collection_fifth() {
        numbers.fifth().shouldBe(5)
    }

    @Test
    fun collection_penultimate() {
        numbers.penultimate().shouldBe(9)
    }
}
