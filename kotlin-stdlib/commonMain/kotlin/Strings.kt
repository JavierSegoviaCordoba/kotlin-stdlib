package com.javiersc.kotlin.stdlib

/**
 * Returns a new string obtained by removing all occurrences of the [value] substring in this string
 */
public fun String.remove(value: String, ignoreCase: Boolean = false): String =
    replace(oldValue = value, newValue = "", ignoreCase = ignoreCase)
