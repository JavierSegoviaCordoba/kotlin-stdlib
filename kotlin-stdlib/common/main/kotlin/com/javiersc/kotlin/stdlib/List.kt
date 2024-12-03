package com.javiersc.kotlin.stdlib

/** Remove all consecutive line breaks in a list of `String` */
public fun List<String>.removeDuplicateEmptyLines(): String =
    if (isNotEmpty()) {
        reduce { acc: String, b: String ->
            if (acc.lines().lastOrNull().isNullOrBlank() && b.isBlank()) acc else "$acc\n$b"
        }
    } else ""
