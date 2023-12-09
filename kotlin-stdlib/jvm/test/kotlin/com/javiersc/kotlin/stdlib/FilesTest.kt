package com.javiersc.kotlin.stdlib

import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.createTempDirectory
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

internal class FilesTest {

    @Test
    fun `given a directory when FileScope DSL is used then file tree is created`() {
        val path = Path("build/tmp/test/files-test").apply { toFile().mkdirs() }
        val projectDir = createTempDirectory(directory = path).toFile()
        projectDir.root("root") {
            dir("dir")
            file("file.txt") { //
                writeText("1")
            }
            dir("dir2") {
                file("file2.txt") { //
                    writeText("2")
                }
                dir("dir3") {
                    file("file3.txt") { //
                        writeText("3")
                    }
                }
            }
        }
        assertTrue { projectDir.root("root").isDirectory }
        assertTrue { projectDir.walkTopDown().count() == 8 }
        projectDir.resolve("root").apply {
            assertTrue { exists() }
            assertTrue { isDirectory }
            resolve("dir").apply {
                assertTrue { exists() }
                assertTrue { isDirectory }
            }
            resolve("file.txt").apply {
                assertTrue { exists() }
                assertTrue { isFile }
                assertTrue { readText() == "1" }
            }
            resolve("dir2").apply {
                assertTrue { exists() }
                assertTrue { isDirectory }
                resolve("file2.txt").apply {
                    assertTrue { exists() }
                    assertTrue { isFile }
                    assertTrue { readText() == "2" }
                }
                resolve("dir3").apply {
                    assertTrue { exists() }
                    assertTrue { isDirectory }
                    resolve("file3.txt").apply {
                        assertTrue { exists() }
                        assertTrue { isFile }
                        assertTrue { readText() == "3" }
                    }
                }
            }
        }
        projectDir.deleteRecursively()
    }

    @Test
    fun `given a directory when it exists then resource is not null`() {
        val childrenTestDir = resourceOrNull("children-test")
        assertNotNull(childrenTestDir)
        assertTrue { childrenTestDir.exists() }
        assertTrue { resource("children-test").exists() }
    }

    @Test
    fun `given a directory when it does not exist then resource is null`() {
        assertFailsWith<IllegalStateException> { resource("children-test-foo") }
        assertNull(resourceOrNull("children-test-foo"))
    }

    @Test
    fun `given a directory when it has children a sub-children then children does not use sub children`() {
        val childrenTestDir = resource("children-test")

        val children: Sequence<File> = childrenTestDir.children
        val actualChildren: List<String> = children.toList().map { it.name }.sorted()
        val expectChildren: List<String> = listOf("A.txt", "B.txt", "sub-children").sorted()
        assertTrue { actualChildren == expectChildren }

        val subChildren = children.first { it.isDirectory }.children
        val actualSubChildren: List<String> = subChildren.toList().map { it.name }.sorted()
        val expectSubChildren: List<String> = listOf("C.txt", "D.txt").sorted()
        assertTrue { actualSubChildren == expectSubChildren }
    }
}
