package com.javiersc.kotlin.test

import java.io.File
import kotlin.io.path.createTempDirectory
import kotlin.io.path.createTempFile
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class FileMatchersTest {

    private val tempDir: File = createTempDirectory().toFile()
    private val tempFile: File = createTempFile().toFile()

    @Test
    fun `assertDirectory should pass for directory`() {
        val result: File = tempDir.assertDirectory()
        assertTrue(result === tempDir)
    }

    @Test
    fun `assertDirectory should fail for file`() {
        val exception: AssertionError = assertFailsWith { tempFile.assertDirectory() }
        assertTrue(
            exception.message == "Expected ${tempFile.path} to be a directory but was a file"
        )
    }

    @Test
    fun `assertDirectory should fail with custom message`() {
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith { tempFile.assertDirectory(message) }
        assertTrue(exception.message == message)
    }

    @Test
    fun `assertFile should pass for file`() {
        val result: File = tempFile.assertFile()
        assertTrue(result === tempFile)
    }

    @Test
    fun `assertFile should fail for directory`() {
        val exception: AssertionError = assertFailsWith { tempDir.assertFile() }
        assertTrue(exception.message == "Expected ${tempDir.path} to be a file but was a directory")
    }

    @Test
    fun `assertFile should fail with custom message`() {
        val message = "Custom error message"
        val exception: AssertionError = assertFailsWith { tempDir.assertFile(message) }
        assertTrue(exception.message == message)
    }

    @AfterTest
    fun tearDown() {
        tempDir.delete()
        tempFile.delete()
    }
}
