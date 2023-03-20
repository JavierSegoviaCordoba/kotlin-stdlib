@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

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

/**
 * Returns second element.
 *
 * Throws: `NoSuchElementException` - if the list size is 1.
 */
public inline fun <T> Iterable<T>.second(): T = getIndex(2)

public inline fun <T> Iterable<T>.secondOrNull(): T? = getIndexOrNull(2)

/**
 * Returns third element.
 *
 * Throws: `NoSuchElementException` - if the list size is 2.
 */
public inline fun <T> Iterable<T>.third(): T = getIndex(3)

public inline fun <T> Iterable<T>.thirdOrNull(): T? = getIndexOrNull(3)

/**
 * Returns forth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 3.
 */
public inline fun <T> Iterable<T>.forth(): T = getIndex(4)

public inline fun <T> Iterable<T>.forthOrNull(): T? = getIndexOrNull(4)

/**
 * Returns fifth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 4.
 */
public inline fun <T> Iterable<T>.fifth(): T = getIndex(5)

public inline fun <T> Iterable<T>.fifthOrNull(): T? = getIndexOrNull(5)

/**
 * Returns penultimate element.
 *
 * Throws: `NoSuchElementException` - if the list size is 1.
 */
public inline fun <T> Iterable<T>.penultimate(): T {
    return when (this) {
        is List ->
            when (size) {
                0 -> throw NoSuchElementException("Collection is empty.")
                1 -> throw NoSuchElementException("Collection size is lower than 2.")
                else -> this[size - 2]
            }
        else -> {
            val iterator = iterator()
            if (!iterator.hasNext()) throw NoSuchElementException("Collection is empty.")
            iterator.next()
            if (!iterator.hasNext()) {
                throw NoSuchElementException("Collection size is lower than 2.")
            }
            var penultimate: T = iterator.next()
            while (iterator.hasNext()) {
                val next: T = iterator.next()
                if (iterator.hasNext()) penultimate = next
            }
            return penultimate
        }
    }
}

public inline fun <T> Iterable<T>.penultimateOrNull(): T? {
    return when (this) {
        is List -> getOrNull(size - 2)
        else -> {
            val iterator = iterator()

            if (!iterator.hasNext()) return null
            iterator.next()
            if (!iterator.hasNext()) return null

            var penultimate: T = iterator.next()
            while (iterator.hasNext()) {
                val next: T = iterator.next()
                if (iterator.hasNext()) penultimate = next
            }
            return penultimate
        }
    }
}

@PublishedApi
internal inline fun <T> Iterable<T>.getIndex(index: Int): T {
    return when (this) {
        is List ->
            if (size >= index - 1) this[index - 1]
            else throw NoSuchElementException("Collection size is lower than $index.")
        else -> {
            val iterator = iterator()
            if (!iterator.hasNext())
                throw NoSuchElementException("Collection size is lower than $index.")
            var value: T = iterator.next()

            for (i in 0 until index - 1) {
                if (!iterator.hasNext())
                    throw NoSuchElementException("Collection size is lower than $index.")
                else value = iterator.next()
            }
            value
        }
    }
}

@PublishedApi
internal inline fun <T> Iterable<T>.getIndexOrNull(index: Int): T? {
    return when (this) {
        is List -> getOrNull(index - 1)
        else -> {
            val iterator = iterator()
            if (!iterator.hasNext()) return null
            var value: T = iterator.next()

            for (i in 0 until index - 1) {
                if (!iterator.hasNext()) return null else value = iterator.next()
            }
            value
        }
    }
}

/** Remove all consecutive line breaks in a list of `String` */
public fun List<String>.removeDuplicateEmptyLines(): String =
    if (isNotEmpty()) {
        reduce { acc: String, b: String ->
            if (acc.lines().lastOrNull().isNullOrBlank() && b.isBlank()) acc else "$acc\n$b"
        }
    } else ""
