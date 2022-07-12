package com.javiersc.kotlin.stdlib

import kotlin.contracts.contract

public fun String.replace(vararg oldToNewValues: Pair<String, String>): String {
    var result = this
    for ((oldValue, newValue) in oldToNewValues) {
        result = result.replace(oldValue, newValue)
    }
    return result
}

/**
 * Returns a new string obtained by removing all occurrences of the [value] substring in this string
 */
public inline fun String.remove(value: String, ignoreCase: Boolean = false): String =
    replace(oldValue = value, newValue = "", ignoreCase = ignoreCase)

public fun String.remove(vararg values: String): String {
    var result = this
    for (value in values) {
        result = result.replace(value, "")
    }
    return result
}

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

public inline fun String?.isNotNullNorBlank(): Boolean {
    contract { returns(true) implies (this@isNotNullNorBlank != null) }

    return !isNullOrBlank()
}

public inline fun String?.isNotNullNorEmpty(): Boolean {
    contract { returns(true) implies (this@isNotNullNorEmpty != null) }

    return !isNullOrEmpty()
}

public inline val String.Companion.Empty: String
    get() = ""

/** Remove all consecutive line breaks in a `String` */
public fun String.removeDuplicateEmptyLines(): String = lines().removeDuplicateEmptyLines()

/** Add an empty line as last item if it is not empty */
public fun String.endWithNewLine(): String =
    if (lines().lastOrNull().isNullOrBlank()) this else "$this\n"
