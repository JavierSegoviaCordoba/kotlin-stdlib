@file:Suppress("MagicNumber", "TooManyFunctions", "NOTHING_TO_INLINE")

package com.javiersc.kotlin.stdlib

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
 * Returns sixth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 5.
 */
public inline fun <T> Iterable<T>.sixth(): T = getIndex(6)

public inline fun <T> Iterable<T>.sixthOrNull(): T? = getIndexOrNull(6)

/**
 * Returns seventh element.
 *
 * Throws: `NoSuchElementException` - if the list size is 6.
 */
public inline fun <T> Iterable<T>.seventh(): T = getIndex(7)

public inline fun <T> Iterable<T>.seventhOrNull(): T? = getIndexOrNull(7)

/**
 * Returns eighth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 7.
 */
public inline fun <T> Iterable<T>.eighth(): T = getIndex(8)

public inline fun <T> Iterable<T>.eighthOrNull(): T? = getIndexOrNull(8)

/**
 * Returns ninth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 8.
 */
public inline fun <T> Iterable<T>.ninth(): T = getIndex(9)

public inline fun <T> Iterable<T>.ninthOrNull(): T? = getIndexOrNull(9)

/**
 * Returns tenth element.
 *
 * Throws: `NoSuchElementException` - if the list size is 9.
 */
public inline fun <T> Iterable<T>.tenth(): T = getIndex(10)

public inline fun <T> Iterable<T>.tenthOrNull(): T? = getIndexOrNull(10)

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
