package com.javiersc.kotlin.stdlib

import com.javiersc.kotlin.stdlib.tree.TreeNode
import com.javiersc.kotlin.stdlib.tree.TreeNodeException
import com.javiersc.kotlin.stdlib.tree.TreeNodeIterators
import com.javiersc.kotlin.stdlib.tree.tree
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertTrue

internal class TreeNodeTest {

    @Test
    fun removeNodeTest() {
        val root = TreeNode("Root")
        val beveragesNode = TreeNode("Beverages")
        val curdNode = TreeNode("Curd")
        root.addChild(beveragesNode)
        root.addChild(curdNode)

        val teaNode = TreeNode("tea")
        val coffeeNode = TreeNode("coffee")
        val milkShakeNode = TreeNode("Milk Shake")
        beveragesNode.addChild(teaNode)
        beveragesNode.addChild(coffeeNode)
        beveragesNode.addChild(milkShakeNode)

        val gingerTeaNode = TreeNode("ginger tea")
        val normalTeaNode = TreeNode("normal tea")
        teaNode.addChild(gingerTeaNode)
        teaNode.addChild(normalTeaNode)

        val yogurtNode = TreeNode("yogurt")
        val lassiNode = TreeNode("lassi")
        curdNode.addChild(yogurtNode)
        curdNode.addChild(lassiNode)

        assertEquals(
            message = "Pretty print test",
            expected =
                "Root\n" +
                    "├── Beverages\n" +
                    "│   ├── tea\n" +
                    "│   │   ├── ginger tea\n" +
                    "│   │   └── normal tea\n" +
                    "│   ├── coffee\n" +
                    "│   └── Milk Shake\n" +
                    "└── Curd\n" +
                    "    ├── yogurt\n" +
                    "    └── lassi\n",
            actual = root.prettyString(),
        )

        root.removeChild(curdNode)
        root.removeChild(gingerTeaNode)
        assertEquals(
            message = "Remove node test",
            expected =
                "Root\n" +
                    "└── Beverages\n" +
                    "    ├── tea\n" +
                    "    │   └── normal tea\n" +
                    "    ├── coffee\n" +
                    "    └── Milk Shake\n",
            actual = root.prettyString(),
        )

        assertTrue { root.isRoot }
        assertEquals(5, root.nodeCount)
        assertEquals(3, root.height)
        assertEquals(0, root.depth)
        assertEquals(3, normalTeaNode.depth)
        assertEquals(listOf(teaNode, beveragesNode, root), root.path(teaNode))
        assertFailsWith<TreeNodeException> { beveragesNode.path(root) }
    }

    @Test
    fun clearTest() {
        val root = TreeNode("Root")
        val beveragesNode = TreeNode("Beverages")
        val curdNode = TreeNode("Curd")
        root.addChild(beveragesNode)
        root.addChild(curdNode)

        val teaNode = TreeNode("tea")
        val coffeeNode = TreeNode("coffee")
        val milkShakeNode = TreeNode("Milk Shake")
        beveragesNode.addChild(teaNode)
        beveragesNode.addChild(coffeeNode)
        beveragesNode.addChild(milkShakeNode)

        val gingerTeaNode = TreeNode("ginger tea")
        val normalTeaNode = TreeNode("normal tea")
        teaNode.addChild(gingerTeaNode)
        teaNode.addChild(normalTeaNode)

        val yogurtNode = TreeNode("yogurt")
        val lassiNode = TreeNode("lassi")
        curdNode.addChild(yogurtNode)
        curdNode.addChild(lassiNode)

        root.clear()
        assertEquals(root.children, emptyList())
        assertEquals(beveragesNode.children, emptyList())
        assertEquals(curdNode.children, emptyList())
        assertEquals(teaNode.children, emptyList())
        assertEquals(coffeeNode.children, emptyList())
        assertEquals(milkShakeNode.children, emptyList())
        assertEquals(gingerTeaNode.children, emptyList())
        assertEquals(normalTeaNode.children, emptyList())
        assertEquals(yogurtNode.children, emptyList())
        assertEquals(lassiNode.children, emptyList())

        assertNull(root.parent)
        assertNull(beveragesNode.parent)
        assertNull(curdNode.parent)
        assertNull(teaNode.parent)
        assertNull(coffeeNode.parent)
        assertNull(milkShakeNode.parent)
        assertNull(gingerTeaNode.parent)
        assertNull(normalTeaNode.parent)
        assertNull(yogurtNode.parent)
        assertNull(lassiNode.parent)
    }

    @Test
    fun kotlinExtTest() {
        val root = TreeNode("World")
        val northA = TreeNode("North America")
        val europe = TreeNode("Europe")
        root.addChild(northA)
        root.addChild(europe)

        val usa = TreeNode("USA")
        northA.addChild(usa)

        val poland = TreeNode("Poland")
        val france = TreeNode("France")
        europe.addChild(poland)
        europe.addChild(france)

        val rootExt =
            tree("World") {
                child("North America") { child("USA") }
                child("Europe") {
                    child("Poland")
                    child("France")
                }
            }
        assertEquals(root.prettyString(), rootExt.prettyString())
    }

    @Test
    fun preOrderIteratorTest() {
        val tree =
            tree("F") {
                child("B") {
                    child("A")
                    child("D") {
                        child("C")
                        child("E")
                    }
                }
                child("G") { child("I") { child("H") } }
            }
        val expectedPreOrder = listOf("F", "B", "A", "D", "C", "E", "G", "I", "H")
        assertContentEquals(expectedPreOrder, tree.toList().map { it.toString() })
    }

    @Test
    fun postOrderIteratorTest() {
        val tree =
            tree("A", TreeNodeIterators.PostOrder) {
                child("B") { child("E") }
                child("C")
                child("D") {
                    child("F")
                    child("G")
                    child("H")
                    child("I")
                    child("J")
                }
            }

        val expectedPreOrder = listOf("E", "B", "C", "F", "G", "H", "I", "J", "D", "A")
        assertContentEquals(expectedPreOrder, tree.toList().map { it.toString() })
    }

    @Test
    fun secondPostOrderIteratorTest() {
        val tree =
            tree(1, TreeNodeIterators.PostOrder) {
                child(2) {
                    child(5) { child(10) }
                    child(6) {
                        child(11)
                        child(12)
                        child(13)
                    }
                }
                child(3)
                child(4) {
                    child(7)
                    child(8)
                    child(9)
                }
            }
        val expectedOrder = listOf(10, 5, 11, 12, 13, 6, 2, 3, 7, 8, 9, 4, 1)
        assertContentEquals(expectedOrder, tree.toList().map(TreeNode<Int>::value))
    }

    @Test
    fun levelOrderIteratorTest() {
        val tree =
            tree(1, TreeNodeIterators.LevelOrder) {
                child(2) {
                    child(5) { child(10) }
                    child(6) {
                        child(11)
                        child(12)
                        child(13)
                    }
                }
                child(3)
                child(4) {
                    child(7)
                    child(8)
                    child(9)
                }
            }
        val expectedOrder = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
        assertContentEquals(expectedOrder, tree.toList().map(TreeNode<Int>::value))
    }

    @Test
    fun testRoot() {
        val tree =
            tree(1) {
                child(2) {
                    child(4)
                    child(5)
                }
                child(3)
            }
        assertEquals(1, tree.root.value)
        assertEquals(1, tree.children.first().root.value)
        assertEquals(1, tree.children.first().children.first().root.value)
    }
}
