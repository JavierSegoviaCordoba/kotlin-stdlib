package com.javiersc.kotlin.stdlib

public inline fun <T> T?.ifNotNull(block: () -> Unit): T? {
    if (this != null) block()
    return this
}

public inline fun <T> T?.ifNull(block: () -> Unit): T? {
    if (this == null) block()
    return this
}

public inline infix fun <T> T?.or(other: T): T = this ?: other

public inline infix fun <T> T?.or(block: () -> T): T = this ?: block()
