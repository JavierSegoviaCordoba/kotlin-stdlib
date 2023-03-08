package com.javiersc.kotlin.stdlib

// original idea source:
// https://github.com/hsz/transform-string/

public fun String.transformstring(): String = prepare("").lowercase()

public fun String.TRANSFORMSTRING(): String = prepare("").uppercase()

public fun String.transformString(): String {
    val data = prepare(" ")
    return data
        .mapIndexed { index, char ->
            val isAfterWhitespace = data.getOrNull(index - 1)?.isWhitespace() ?: false
            when {
                isAfterWhitespace -> char.uppercaseChar()
                else -> char.lowercaseChar()
            }
        }
        .filterNot(Char::isWhitespace)
        .joinToString("")
        .remove(" ")
}

public fun String.TransformString(): String {
    val data = prepare(" ")
    return data
        .mapIndexed { index, char ->
            val isAfterWhitespace = data.getOrNull(index - 1)?.isWhitespace() ?: false
            when {
                isAfterWhitespace -> char.uppercaseChar()
                else -> char.lowercaseChar()
            }
        }
        .filterNot(Char::isWhitespace)
        .joinToString("")
        .remove(" ")
        .capitalize()
}

public fun String.transform_string(): String = prepare("_").lowercase()

public fun String.TRANSFORM_STRING(): String = prepare("_").uppercase()

public fun String.transform_hyphen_string(): String = prepare("-").lowercase()

public fun String.TRANSFORM_HYPHEN_STRING(): String = prepare("-").uppercase()

public fun String.tRaNsFoRmStRiNg(): String {
    var newStr = ""
    var shouldBeUpperCase = false
    forEach { str ->
        if (str.isLetter()) {
            newStr += if (shouldBeUpperCase) str.uppercase() else str.lowercase()
            shouldBeUpperCase = !shouldBeUpperCase
        } else newStr += str
    }
    return newStr
}

private fun String.prepare(separator: String): String =
    replace("""((?<=\p{Ll})\p{Lu}|\p{Lu}(?=\p{Ll}))""".toRegex(), "$separator$1")
        .replace("""[\W_]""".toRegex(), separator)
        .removePrefix(separator)
