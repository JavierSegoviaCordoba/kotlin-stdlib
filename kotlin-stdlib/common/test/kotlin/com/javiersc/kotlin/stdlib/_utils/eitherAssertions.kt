package com.javiersc.kotlin.stdlib._utils

import com.javiersc.kotlin.stdlib.Either
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal inline fun Either<*, *>.assertRight() {
    assertTrue { this is Either.Right }
}

internal inline fun Either<*, *>.assertLeft(block: () -> String) {
    assertTrue { this is Either.Left }
    assertEquals(block().trimMargin(), (this as Either.Left).value)
}
