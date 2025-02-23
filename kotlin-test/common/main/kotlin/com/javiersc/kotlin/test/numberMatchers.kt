package com.javiersc.kotlin.test

import kotlin.time.Duration

public inline fun <reified T : Number> T.assertGreaterThan(number: T, message: String? = null): T {
    val message: String = message ?: "$this is not greater than $number"
    when (this) {
        is Byte -> if (this <= number.toByte()) fail(message)
        is Short -> if (this <= number.toShort()) fail(message)
        is Int -> if (this <= number.toInt()) fail(message)
        is Long -> if (this <= number.toLong()) fail(message)
        is Float -> if (this <= number.toFloat()) fail(message)
        is Double -> if (this <= number.toDouble()) fail(message)
    }
    return this
}

public fun Duration.assertGreaterThan(number: Duration, message: String? = null): Duration {
    val message: String = message ?: "$this is not greater than $number"
    if (this <= number) fail(message)
    return this
}

public inline fun <reified T : Number> T.assertLessThan(number: T, message: String? = null): T {
    val message: String = message ?: "$this is not less than $number"
    when (this) {
        is Byte -> if (this >= number.toByte()) fail(message)
        is Short -> if (this >= number.toShort()) fail(message)
        is Int -> if (this >= number.toInt()) fail(message)
        is Long -> if (this >= number.toLong()) fail(message)
        is Float -> if (this >= number.toFloat()) fail(message)
        is Double -> if (this >= number.toDouble()) fail(message)
    }
    return this
}

public fun Duration.assertLessThan(number: Duration, message: String? = null): Duration {
    val message: String = message ?: "$this is not less than $number"
    if (this >= number) fail(message)
    return this
}
