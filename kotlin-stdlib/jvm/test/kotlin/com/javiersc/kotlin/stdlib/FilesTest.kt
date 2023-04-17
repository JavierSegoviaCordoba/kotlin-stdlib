package com.javiersc.kotlin.stdlib

import java.io.File
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

internal class FilesTest {

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
