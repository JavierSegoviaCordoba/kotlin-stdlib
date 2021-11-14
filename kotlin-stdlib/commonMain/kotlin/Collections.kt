@file:Suppress("MagicNumber")

package com.javiersc.kotlin.stdlib

/**
 * Returns second element.
 *
 * Throws: `NoSuchElementException` - if the list size is 1.
 */
public inline fun <T> Iterable<T>.second(): T = getIndex(2)

/**
 * Returns third element.
 *
 * Throws: `NoSuchElementException` - if the list size is 2.
 */
public inline fun <T> Iterable<T>.third(): T = getIndex(3)

/**
 * Returns forth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 3.
 */
public inline fun <T> Iterable<T>.forth(): T = getIndex(4)

/**
 * Returns fifth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 4.
 */
public inline fun <T> Iterable<T>.fifth(): T = getIndex(5)

/**
 * Returns penultimate element.
 *
 * Throws: `NoSuchElementException` - if the list size is 1.
 */
public inline fun <T> Iterable<T>.penultimate(): T {
    return when (this) {
        is List -> this[size - 2]
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

@PublishedApi
internal inline fun <T> Iterable<T>.getIndex(index: Int): T {
    return when (this) {
        is List -> this[index - 1]
        else -> {
            val iterator = iterator()
            if (!iterator.hasNext()) throwNoSuchElementException(index)
            var value: T = iterator.next()

            for (i in 0 until index - 1) {
                if (!iterator.hasNext()) throwNoSuchElementException(index)
                else value = iterator.next()
            }
            value
        }
    }
}

@PublishedApi
internal inline fun throwNoSuchElementException(size: Int): Unit =
    throw NoSuchElementException("Collection size is lower than $size.")
