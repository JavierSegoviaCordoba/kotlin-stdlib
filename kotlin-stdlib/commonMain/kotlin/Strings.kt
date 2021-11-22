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

    return this != null && isNotBlank()
}

@OptIn(ExperimentalContracts::class)
public inline fun CharSequence?.isNotNullNorEmpty(): Boolean {
    contract { returns(false) implies (this@isNotNullNorEmpty == null) }

    return this != null && isNotEmpty()
}

@OptIn(ExperimentalContracts::class)
public inline fun String?.isNotNullNorBlank(): Boolean {
    contract { returns(false) implies (this@isNotNullNorBlank == null) }

    return this != null && isNotBlank()
}

@OptIn(ExperimentalContracts::class)
public inline fun String?.isNotNullNorEmpty(): Boolean {
    contract { returns(false) implies (this@isNotNullNorEmpty == null) }

    return this != null && isNotEmpty()
}

public inline fun emptyString(): String = ""
