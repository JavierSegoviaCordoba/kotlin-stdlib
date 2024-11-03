package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertTrue

class IdentityTest {

    @Test
    fun identity_should_return_the_same_value() {
        val value1 = 1
        val result1: Int = identity(value1)
        assertTrue { value1 == result1 }

        val valueA = 'A'
        val resultA: Char = identity(valueA)
        assertTrue { valueA == resultA }
    }
}
