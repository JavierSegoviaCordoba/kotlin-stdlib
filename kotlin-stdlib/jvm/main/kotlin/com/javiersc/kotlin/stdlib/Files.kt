package com.javiersc.kotlin.stdlib

import java.io.File

public fun resource(name: String): File = resourceOrNull(name) ?: error("File not found")

public fun resourceOrNull(name: String): File? =
    Thread.currentThread().contextClassLoader?.getResource(name)?.file?.let(::File)

public val File.children: Sequence<File>
    get() = walkTopDown().maxDepth(1) - this
