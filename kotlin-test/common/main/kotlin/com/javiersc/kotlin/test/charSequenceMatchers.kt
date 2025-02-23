package com.javiersc.kotlin.test

public fun <T : CharSequence?> T.assertStartWith(prefix: CharSequence, message: String? = null): T {
    if (this?.startsWith(prefix) == false) fail(message ?: "$this does not start with $prefix")
    return this
}

public fun <T : CharSequence?> T.assertNotStartWith(
    prefix: CharSequence,
    message: String? = null,
): T {
    if (this?.startsWith(prefix) == true) fail(message ?: "$this does start with $prefix")
    return this
}
