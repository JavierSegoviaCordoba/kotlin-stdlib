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

/** Remove all consecutive line breaks in a `CharSequence` */
public fun CharSequence.removeDuplicateEmptyLines(): CharSequence =
    lines().removeDuplicateEmptyLines()

/** Add an empty line as last item if it is not empty */
public fun CharSequence.endWithNewLine(): CharSequence =
    if (lines().lastOrNull().isNullOrBlank()) this else "$this\n"
