package com.javiersc.kotlin.stdlib

public inline fun Boolean.ifFalse(block: () -> Unit): Boolean {
    if (!this) block()
    return this
}

public inline fun Boolean.ifTrue(block: () -> Unit): Boolean {
    if (this) block()
    return this
}
