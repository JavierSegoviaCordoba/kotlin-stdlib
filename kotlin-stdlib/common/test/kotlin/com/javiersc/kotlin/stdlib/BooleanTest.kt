package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BooleanTest {

    private val fail: Boolean = false
    private val success: Boolean = true

    @Test
    fun ifFalse() {
        var isFalse = false
        var isTrue = false

        fail.ifFalse { isFalse = true }
        success.ifFalse { isTrue = true }

        assertFalse { isTrue }
        assertTrue { isFalse }
    }

    @Test
    fun ifTrue() {
        var isFalse = false
        var isTrue = false

        fail.ifTrue { isFalse = true }
        success.ifTrue { isTrue = true }

        assertFalse { isFalse }
        assertTrue { isTrue }
    }
}
