@file:Suppress("NOTHING_TO_INLINE")

package com.javiersc.kotlin.stdlib

import kotlin.contracts.contract

public inline fun CharSequence?.isNotNullNorBlank(): Boolean {
    contract { returns(true) implies (this@isNotNullNorBlank != null) }
    return !isNullOrBlank()
}

public inline fun CharSequence?.isNotNullNorEmpty(): Boolean {
    contract { returns(true) implies (this@isNotNullNorEmpty != null) }
    return !isNullOrEmpty()
}

public inline fun CharSequence.notContain(
    other: CharSequence,
    ignoreCase: Boolean = false,
): Boolean = !contains(other, ignoreCase)

public inline fun CharSequence.notContain(regex: Regex): Boolean = !contains(regex)
