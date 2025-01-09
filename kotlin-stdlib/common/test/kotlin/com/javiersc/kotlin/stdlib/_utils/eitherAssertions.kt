package com.javiersc.kotlin.stdlib._utils

import com.javiersc.kotlin.stdlib.Either
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal fun Either<*, *>.assertRight() {
    assertTrue { this is Either.Right }
}

internal fun <E : Any> Either<List<E>, *>.assertLeft(vararg errors: E) {
    assertTrue(this is Either.Left)
    val expectedErrors: List<E> = errors.toList()
    val actualErrors: List<E> = this.value
    assertEquals(expectedErrors, actualErrors)
}
