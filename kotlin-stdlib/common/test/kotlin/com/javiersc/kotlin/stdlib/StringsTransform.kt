package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertEquals

internal class StringsTransform {

    @Test
    fun lowerCase() {
        assertEquals("foobar", "foo bar".transformstring())
        assertEquals("foobar", "foo-bar".transformstring())
        assertEquals("foobar", "foo_bar".transformstring())
        assertEquals("foobar", "FOO_BAR".transformstring())
        assertEquals("foobar", "foo.bar".transformstring())
        assertEquals("foobar", "FOO.BAR".transformstring())
        assertEquals("foobar", "FooBar".transformstring())
    }

    @Test
    fun upperCase() {
        assertEquals("FOOBAR", "foo bar".TRANSFORMSTRING())
        assertEquals("FOOBAR", "foo-bar".TRANSFORMSTRING())
        assertEquals("FOOBAR", "foo_bar".TRANSFORMSTRING())
        assertEquals("FOOBAR", "FOO_BAR".TRANSFORMSTRING())
        assertEquals("FOOBAR", "foo.bar".TRANSFORMSTRING())
        assertEquals("FOOBAR", "FOO.BAR".TRANSFORMSTRING())
        assertEquals("FOOBAR", "FooBar".TRANSFORMSTRING())
    }

    @Test
    fun camelCase() {
        assertEquals("fooBar", "foo bar".transformString())
        assertEquals("fooBar", "foo-bar".transformString())
        assertEquals("fooBar", "foo_bar".transformString())
        assertEquals("fooBar", "FOO_BAR".transformString())
        assertEquals("fooBar", "foo.bar".transformString())
        assertEquals("fooBar", "FOO.BAR".transformString())
        assertEquals("fooBar", "FooBar".transformString())
    }

    @Test
    fun pascalCase() {
        assertEquals("FooBar", "foo bar".TransformString())
        assertEquals("FooBar", "foo-bar".TransformString())
        assertEquals("FooBar", "foo_bar".TransformString())
        assertEquals("FooBar", "FOO_BAR".TransformString())
        assertEquals("FooBar", "foo.bar".TransformString())
        assertEquals("FooBar", "FOO.BAR".TransformString())
        assertEquals("FooBar", "FooBar".TransformString())
    }

    @Test
    fun lowerSnakeCase() {
        assertEquals("foo_bar", "foo bar".transform_string())
        assertEquals("foo_bar", "foo-bar".transform_string())
        assertEquals("foo_bar", "foo_bar".transform_string())
        assertEquals("foo_bar", "FOO_BAR".transform_string())
        assertEquals("foo_bar", "foo.bar".transform_string())
        assertEquals("foo_bar", "FOO.BAR".transform_string())
        assertEquals("foo_bar", "FooBar".transform_string())
    }

    @Test
    fun upperSnakeCase() {
        assertEquals("FOO_BAR", "foo bar".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "foo-bar".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "foo_bar".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "FOO_BAR".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "foo.bar".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "FOO.BAR".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "FooBar".TRANSFORM_STRING())
    }

    @Test
    fun lowerKebabCase() {
        assertEquals("foo-bar", "foo bar".transform_hyphen_string())
        assertEquals("foo-bar", "foo-bar".transform_hyphen_string())
        assertEquals("foo-bar", "foo_bar".transform_hyphen_string())
        assertEquals("foo-bar", "FOO_BAR".transform_hyphen_string())
        assertEquals("foo-bar", "foo.bar".transform_hyphen_string())
        assertEquals("foo-bar", "FOO.BAR".transform_hyphen_string())
        assertEquals("foo-bar", "FooBar".transform_hyphen_string())
    }

    @Test
    fun upperKebabCase() {
        assertEquals("FOO-BAR", "foo bar".TRANSFORM_HYPHEN_STRING())
        assertEquals("FOO-BAR", "foo-bar".TRANSFORM_HYPHEN_STRING())
        assertEquals("FOO-BAR", "foo_bar".TRANSFORM_HYPHEN_STRING())
        assertEquals("FOO-BAR", "FOO_BAR".TRANSFORM_HYPHEN_STRING())
        assertEquals("FOO-BAR", "foo.bar".TRANSFORM_HYPHEN_STRING())
        assertEquals("FOO-BAR", "FOO.BAR".TRANSFORM_HYPHEN_STRING())
        assertEquals("FOO-BAR", "FooBar".TRANSFORM_HYPHEN_STRING())
    }

    @Test
    fun alternativeCase() {
        assertEquals("fOo BaR", "foo bar".tRaNsFoRmStRiNg())
        assertEquals("fOo-BaR", "foo-bar".tRaNsFoRmStRiNg())
        assertEquals("fOo_BaR", "foo_bar".tRaNsFoRmStRiNg())
        assertEquals("fOo_BaR", "FOO_BAR".tRaNsFoRmStRiNg())
        assertEquals("fOo.BaR", "foo.bar".tRaNsFoRmStRiNg())
        assertEquals("fOo.BaR", "FOO.BAR".tRaNsFoRmStRiNg())
        assertEquals("fOoBaR", "FooBar".tRaNsFoRmStRiNg())
        assertEquals("1fOo-BaR", "1foo-bar".tRaNsFoRmStRiNg())
        assertEquals("fOo $ BaR", "foo $ bar".tRaNsFoRmStRiNg())
    }
}
