package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Suppress("RedundantNullableReturnType")
class TTest {

    private val a: String? = "a"
    private val b: String? = null
    private val one: Int? = 1
    private val two: Int? = null

    @Test
    fun ifNotNull() {
        var isA = false
        var isB = false
        var isOne = false
        var isTwo = false

        a.ifNotNull { isA = true }
        b.ifNotNull { isB = true }
        one.ifNotNull { isOne = true }
        two.ifNotNull { isTwo = true }

        assertTrue { isA }
        assertFalse { isB }
        assertTrue { isOne }
        assertFalse { isTwo }
    }

    @Test
    fun ifNull() {
        var isA = false
        var isB = false
        var isOne = false
        var isTwo = false

        a.ifNull { isA = true }
        b.ifNull { isB = true }
        one.ifNull { isOne = true }
        two.ifNull { isTwo = true }

        assertFalse { isA }
        assertTrue { isB }
        assertFalse { isOne }
        assertTrue { isTwo }
    }
}
