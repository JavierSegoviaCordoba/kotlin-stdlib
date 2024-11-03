package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiColorsTest {

    @Test
    fun given__a_empty_string__when__ansiColor_is_called__then__the_string_is_not_colored() {
        val color: AnsiColor.Foreground.Black = AnsiColor.Foreground.Black

        val expected = ""
        val actual: String = "".ansiColor(color)
        assertEquals(expected, actual)
    }

    @Test
    fun given__a_blank_string__when__ansiColor_is_called__then__the_string_is_not_colored() {
        val color: AnsiColor.Foreground.Black = AnsiColor.Foreground.Black

        val expected = "  "
        val actual: String = "  ".ansiColor(color)
        assertEquals(expected, actual)
    }

    @Test
    fun given__a_multiline_empty_string__when__ansiColor_is_called__then__the_string_is_not_colored() {
        val color: AnsiColor.Foreground.Black = AnsiColor.Foreground.Black

        val expected = "\n"
        val actual: String = "\n".ansiColor(color)
        assertEquals(expected, actual)
    }

    @Test
    fun given__a_multiline_blank_string__when__ansiColor_is_called__then__the_string_is_not_colored() {
        val color: AnsiColor.Foreground.Black = AnsiColor.Foreground.Black

        val expected = " \n     "
        val actual: String = " " + "\n" + " " + "    ".ansiColor(color)
        assertEquals(expected, actual)
    }

    @Test
    fun given__a_string_and_the_black_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.Black = AnsiColor.Foreground.Black

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_red_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.Red = AnsiColor.Foreground.Red

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_green_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.Green = AnsiColor.Foreground.Green

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_yellow_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.Yellow = AnsiColor.Foreground.Yellow

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_blue_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.Blue = AnsiColor.Foreground.Blue

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_purple_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.Purple = AnsiColor.Foreground.Purple

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_cyan_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.Cyan = AnsiColor.Foreground.Cyan

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_white_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.White = AnsiColor.Foreground.White

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightBlack_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightBlack = AnsiColor.Foreground.BrightBlack

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightRed_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightRed = AnsiColor.Foreground.BrightRed

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightGreen_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightGreen = AnsiColor.Foreground.BrightGreen

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightYellow_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightYellow = AnsiColor.Foreground.BrightYellow

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightBlue_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightBlue = AnsiColor.Foreground.BrightBlue

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightPurple_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightPurple = AnsiColor.Foreground.BrightPurple

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightCyan_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightCyan = AnsiColor.Foreground.BrightCyan

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_brightWhite_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Foreground.BrightWhite = AnsiColor.Foreground.BrightWhite

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_blackBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Black = AnsiColor.Background.Black

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_redBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Red = AnsiColor.Background.Red

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_greenBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Green = AnsiColor.Background.Green

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_yellowBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Yellow = AnsiColor.Background.Yellow

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_blueBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Blue = AnsiColor.Background.Blue

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_purpleBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Purple = AnsiColor.Background.Purple

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_cyanBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Cyan = AnsiColor.Background.Cyan

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }

    @Test
    fun given__a_string_and_the_grayBackground_color__when__ansiColor_is_called__then__the_string_is_colored() {
        val color: AnsiColor.Background.Gray = AnsiColor.Background.Gray

        val expected = "${color}Hello, World!$reset"
        val actual: String = string.ansiColor(color)
        assertEquals(expected, actual)

        val multilineExpected = "${color}Hello$reset\n${color}World!$reset"
        val multilineActual: String = multilineString.ansiColor(color)
        assertEquals(multilineExpected, multilineActual)
    }
}

private val reset = "${AnsiColor.Reset}"
private const val string = "Hello, World!"
private const val multilineString = "Hello\nWorld!"
