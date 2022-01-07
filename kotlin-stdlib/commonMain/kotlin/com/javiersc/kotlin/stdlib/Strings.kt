package com.javiersc.kotlin.stdlib

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Returns a new string obtained by removing all occurrences of the [value] substring in this string
 */
public inline fun String.remove(value: String, ignoreCase: Boolean = false): String =
    replace(oldValue = value, newValue = "", ignoreCase = ignoreCase)

@OptIn(ExperimentalContracts::class)
public inline fun CharSequence?.isNotNullNorBlank(): Boolean {
    contract { returns(false) implies (this@isNotNullNorBlank == null) }

    return (this != null) && isNotBlank()
}

@OptIn(ExperimentalContracts::class)
public inline fun CharSequence?.isNotNullNorEmpty(): Boolean {
    contract { returns(false) implies (this@isNotNullNorEmpty == null) }

    return (this != null) && isNotEmpty()
}

@OptIn(ExperimentalContracts::class)
public inline fun String?.isNotNullNorBlank(): Boolean {
    contract { returns(false) implies (this@isNotNullNorBlank == null) }

    return (this != null) && isNotBlank()
}

@OptIn(ExperimentalContracts::class)
public inline fun String?.isNotNullNorEmpty(): Boolean {
    contract { returns(false) implies (this@isNotNullNorEmpty == null) }

    return (this != null) && isNotEmpty()
}

public inline val String.Companion.Empty: String
    get() = ""

/** Remove all consecutive line breaks in a `String` */
public fun String.removeDuplicateEmptyLines(): String = lines().removeDuplicateEmptyLines()

/** Add an empty line as last item if it is not empty */
public fun String.endWithNewLine(): String =
    if (lines().lastOrNull().isNullOrBlank()) this else "$this\n"
