package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class EitherTest {

    @Test
    fun given__a_left__when__isLeft__then__true() {
        assertTrue { LeftFixture.isLeft() }
    }

    @Test
    fun given__a_left__when__isRight__then__false() {
        assertFalse { LeftFixture.isRight() }
    }

    @Test
    fun given__a_right__when__isLeft__then__false() {
        assertFalse { RightFixture.isLeft() }
    }

    @Test
    fun given__a_right__when__isRight__then__true() {
        assertTrue { RightFixture.isRight() }
    }

    @Test
    fun given__eithers__when__isLeftLambda__then__compute() {
        assertTrue { LeftFixture.isLeft { it == "Left" } }
        assertFalse { LeftFixture.isLeft { it == "Right" } }
        assertFalse { RightFixture.isLeft { it == "Left" } }
        assertFalse { RightFixture.isLeft { it == "Right" } }
    }

    @Test
    fun given__eithers__when__isRightLambda__then__compute() {
        assertTrue { RightFixture.isRight { it == 42 } }
        assertFalse { RightFixture.isRight { it == 0 } }
        assertFalse { LeftFixture.isRight { it == 42 } }
        assertFalse { LeftFixture.isRight { it == 0 } }
    }

    @Test
    fun given__eithers__when__fold__then__compute() {
        assertTrue { LeftFixture.fold(ifLeft = { it == "Left" }, ifRight = { false }) }
        assertTrue { RightFixture.fold(ifLeft = { false }, ifRight = { it == 42 }) }
    }

    @Test
    fun given__eithers__when__swaps__then__compute() {
        assertTrue { LeftFixture.swap().isRight() }
        assertTrue { RightFixture.swap().isLeft() }
    }

    @Test
    fun given__a_right__when__map__then__newEither() {
        val result = RightFixture.map { it + 1 }
        assertEquals(Either.Right(43), result)
    }

    @Test
    fun given__a_left__when__map__then__sameEither() {
        val result = LeftFixture.map { it + 1 }
        assertEquals(LeftFixture, result)
    }

    @Test
    fun given__a_left__when__mapLeft__then__newEither() {
        val result = LeftFixture.mapLeft { it.length }
        assertEquals(Either.Left(4), result)
    }

    @Test
    fun given__a_right__when__mapLeft__then__sameEither() {
        val result = RightFixture.mapLeft { it }
        assertEquals(RightFixture, result)
    }

    @Test
    fun given__a_right__when__onRight__then__performAction() {
        var actionPerformed = false
        RightFixture.onRight { actionPerformed = true }
        assertTrue(actionPerformed)
    }

    @Test
    fun given__a_left__when__onRight__then__noAction() {
        var actionPerformed = false
        LeftFixture.onRight { actionPerformed = true }
        assertFalse(actionPerformed)
    }

    @Test
    fun given__a_left__when__onLeft__then__performAction() {
        var actionPerformed = false
        LeftFixture.onLeft { actionPerformed = true }
        assertTrue(actionPerformed)
    }

    @Test
    fun given__a_right__when__onLeft__then__noAction() {
        var actionPerformed = false
        RightFixture.onLeft { actionPerformed = true }
        assertFalse(actionPerformed)
    }

    @Test
    fun given__a_left__when__getOrNull__then__null() {
        assertNull(LeftFixture.getOrNull())
    }

    @Test
    fun given__a_right__when__getOrNull__then__value() {
        assertEquals(42, RightFixture.getOrNull())
    }

    @Test
    fun given__a_left__when__leftOrNull__then__value() {
        assertEquals("Left", LeftFixture.leftOrNull())
    }

    @Test
    fun given__a_right__when__leftOrNull__then__null() {
        assertNull(RightFixture.leftOrNull())
    }

    @Test
    fun given__a_right__when__flatMap__then__newEither() {
        val result = RightFixture.flatMap { Either.Right(it + 1) }
        assertEquals(Either.Right(43), result)
    }

    @Test
    fun given__a_left__when__flatMap__then__sameEither() {
        val result = LeftFixture.flatMap { Either.Right(it + 1) }
        assertEquals(LeftFixture, result)
    }

    @Test
    fun given__a_left__when__handleErrorWith__then__newEither() {
        val result = LeftFixture.handleErrorWith { Either.Left(it.length) }
        assertEquals(Either.Left(4), result)
    }

    @Test
    fun given__a_right__when__handleErrorWith__then__sameEither() {
        val result = RightFixture.handleErrorWith { Either.Left(it) }
        assertEquals(RightFixture, result)
    }

    @Test
    fun given__a_nestedEither__when__flatten__then__flattenedEither() {
        val nestedEither: Either<String, Either<String, Int>> = Either.Right(RightFixture)
        val result = nestedEither.flatten()
        assertEquals(RightFixture, result)
    }

    @Test
    fun given__a_left__when__getOrElse__then__defaultValue() {
        val result = LeftFixture getOrElse { it.length }
        assertEquals(4, result)
    }

    @Test
    fun given__a_right__when__getOrElse__then__value() {
        val result = RightFixture getOrElse { it.length }
        assertEquals(42, result)
    }

    @Test
    fun given__either__when__merge__then__mergedValue() {
        val either: Either<Int, Int> = Either.Right(42)
        assertEquals(42, either.merge())
    }

    @Test
    fun given__value__when__left__then__leftEither() {
        val value = "Error"
        val result = value.left()
        assertEquals(Either.Left(value), result)
    }

    @Test
    fun given__value__when__right__then__rightEither() {
        val value = 42
        val result = value.right()
        assertEquals(Either.Right(value), result)
    }

    @Test
    fun given__either__when__compareTo__then__comparisonResult() {
        val either1: Either<Int, Int> = Either.Right(42)
        val either2: Either<Int, Int> = Either.Right(43)
        assertTrue { either1 < either2 }
    }

    @Test
    fun given__either__when__combine__then__combinedEither() {
        val either1: Either<String, Int> = Either.Right(42)
        val either2: Either<String, Int> = Either.Right(43)
        val result = either1.combine(either2, { a, b -> a + b }, { a, b -> a + b })
        assertEquals(Either.Right(85), result)
    }

    @Test
    fun given__either__when__toEitherNel__then__eitherNel() {
        val either: Either<String, Int> = Either.Left("Error")
        val result = either.toEitherNel()
        assertEquals(Either.Left(listOf("Error")), result)
    }

    @Test
    fun given__value__when__leftNel__then__eitherNel() {
        val value = "Error"
        val result = value.leftNel()
        assertEquals(Either.Left(listOf(value)), result)
    }
}

private val LeftFixture: Either<String, Int> = Either.Left("Left")
private val RightFixture: Either<String, Int> = Either.Right(42)
