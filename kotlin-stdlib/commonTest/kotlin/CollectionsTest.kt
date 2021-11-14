@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertTrue

class CollectionsTest {

    private val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test
    fun collection_second() {
        assertTrue { numbers.second() == 2 }
    }

    @Test
    fun collection_third() {
        assertTrue { numbers.third() == 3 }
    }

    @Test
    fun collection_forth() {
        assertTrue { numbers.forth() == 4 }
    }

    @Test
    fun collection_fifth() {
        assertTrue { numbers.forth() == 5 }
    }

    @Test
    fun collection_penultimate() {
        assertTrue { numbers.penultimate() == 9 }
    }
}
