@file:Suppress("NOTHING_TO_INLINE")

package com.javiersc.kotlin.stdlib

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

public fun String.remove(vararg values: String, ignoreCase: Boolean = false): String {
    var result = this
    for (value in values) {
        result = result.remove(value = value, ignoreCase = ignoreCase)
    }
    return result
}

public fun String.removeIf(
    value: String,
    ignoreCase: Boolean = false,
    block: (String) -> Boolean,
): String = if (block(this)) remove(value = value, ignoreCase = ignoreCase) else this

public inline val String.Companion.Empty: String
    get() = ""

public inline val String.Companion.Blank: String
    get() = "   "

/**
 * Returns a copy of this string having its first letter title-cased using the rules of the default
 * locale, or the original string if it's empty or already starts with a title case letter.
 *
 * The title case of a character is usually the same as its upper case with several exceptions. The
 * particular list of characters with the special title case form depends on the underlying
 * platform.
 */
public inline fun String.capitalize(): String = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase() else it.toString()
}

/**
 * Returns a copy of this string having its first letter lowercased using the rules of the default
 * locale, or the original string if it's empty or already starts with a lower case letter.
 */
public inline fun String.decapitalize(): String = replaceFirstChar { it.lowercase() }

/** Remove all consecutive line breaks in a `CharSequence` */
public fun String.removeDuplicateEmptyLines(): String = lines().removeDuplicateEmptyLines()

/** Add an empty line as last item if it is not empty */
public fun String.endWithNewLine(): String =
    if (lines().lastOrNull().isNullOrBlank()) this else "$this\n"
