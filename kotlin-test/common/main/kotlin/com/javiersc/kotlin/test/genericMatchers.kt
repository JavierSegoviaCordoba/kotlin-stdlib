package com.javiersc.kotlin.test

import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertIsNot
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

public inline fun <reified T : Any> T?.assertNotNull(message: String? = null): T {
    assertNotNull(this, message)
    return this
}

public inline fun <reified T : Any> T?.assertNull(message: String? = null) {
    assertNull(this, message)
}

public fun <T> T.assertEquals(actual: T, message: String? = null): T {
    assertEquals(this, actual, message)
    return this
}

public fun <T> T.assertNotEquals(actual: T, message: String? = null): T {
    assertNotEquals(this, actual, message)
    return this
}

public inline fun <reified T : Any> Any.assertIs(message: String? = null): T {
    assertIs<T>(this, message)
    return this
}

public inline fun <reified T : Any> Any.assertIsNot(message: String? = null) {
    assertIsNot<T>(this, message)
}

public inline fun <reified I : Any, reified T : Any> I.assertIsNot(message: String? = null): I {
    assertIsNot<I>(this, message)
    return this
}
