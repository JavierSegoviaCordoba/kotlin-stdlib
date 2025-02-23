package com.javiersc.kotlin.test

public fun <T : Comparable<T>> T.assertGreaterThan(number: T, message: String? = null): T {
    val message: String = message ?: "$this is not greater than $number"
    if (this <= number) fail(message)
    return this
}

public fun <T : Comparable<T>> T.assertLessThan(number: T, message: String? = null): T {
    val message: String = message ?: "$this is not less than $number"
    if (this >= number) fail(message)
    return this
}
