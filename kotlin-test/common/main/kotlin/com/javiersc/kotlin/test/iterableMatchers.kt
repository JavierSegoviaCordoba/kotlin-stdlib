package com.javiersc.kotlin.test

import kotlin.test.assertContains

public inline fun <reified I : Iterable<T>, reified T : Any> I.assertContains(
    element: T,
    message: String? = null,
): I {
    assertContains(iterable = this, element = element, message = message)
    return this
}

public inline fun <reified I : Iterable<T>, reified T : Any> I.assertCount(
    expectSize: Int,
    message: String? = null,
): I = assertSize(expectSize = expectSize, message = message)

public inline fun <reified I : Iterable<T>, reified T : Any> I.assertNotContains(
    element: T,
    message: String? = null,
): I {
    if (element !in this) return this
    fail(message ?: "Expected to contain $element but did not")
}

public inline fun <reified I : Iterable<T>, reified T : Any> I.assertSize(
    expectSize: Int,
    message: String? = null,
): I {
    val actualSize: Int = count()
    if (actualSize == expectSize) return this
    fail(message ?: "Expected size $expectSize but was $actualSize")
}
