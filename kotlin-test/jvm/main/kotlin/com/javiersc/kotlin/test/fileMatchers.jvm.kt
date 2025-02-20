package com.javiersc.kotlin.test

import java.io.File

public inline fun File.assertDirectory(message: String? = null): File {
    if (this.isDirectory) return this

    fail(message ?: "Expected ${this.path} to be a directory but was a file")
}

public inline fun File.assertFile(message: String? = null): File {
    if (this.isFile) return this

    fail(message ?: "Expected ${this.path} to be a file but was a directory")
}
