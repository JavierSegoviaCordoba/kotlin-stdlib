@file:Suppress("RedundantExplicitType")

package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertTrue

internal class StringsTest {

    @Test
    fun string_capitalize() {
        assertTrue { "hello".capitalize() == "Hello" }
        assertTrue { "Hello".capitalize() == "Hello" }
        assertTrue { "hElLo".capitalize() == "HElLo" }
        assertTrue { "".capitalize() == "" }
    }

    @Test
    fun string_decapitalize() {
        assertTrue { "hello".decapitalize() == "hello" }
        assertTrue { "Hello".decapitalize() == "hello" }
        assertTrue { "HElLo".decapitalize() == "hElLo" }
        assertTrue { "".decapitalize() == "" }
    }

    @Test
    fun string_remove() {
        assertTrue { "Hello, World".remove("Hello, ") == "World" }
        assertTrue { "Hello, World".remove("hello, ", ignoreCase = true) == "World" }
        assertTrue { "Hello, World".remove("bla") == "Hello, World" }
        assertTrue { "Hello, World".remove("llo", "rld") == "He, Wo" }
        assertTrue { "Hello, World".remove("Hel", "Wor", ignoreCase = false) == "lo, ld" }
        assertTrue { "Hello, World".removeIf("Hello, ") { it.startsWith("Hel") } == "World" }
        assertTrue { "Hello, World".removeIf("H") { it.startsWith("W") } == "Hello, World" }
        assertTrue { "Hello, World".removeIf("hello, ", true) { it.startsWith("Hel") } == "World" }
    }

    @Test
    fun string_replace() {
        assertTrue { "Hello, World".replace("ello" to "ELLO", "orld" to "ORLD") == "HELLO, WORLD" }
    }

    @Test
    fun empty_string() {
        assertTrue { String.Empty == "" }
    }
}
