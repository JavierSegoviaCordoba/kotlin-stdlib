package com.javiersc.kotlin.stdlib.tree

import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmSynthetic

/** Original library: https://github.com/AdrianKuta/Tree-Data-Structure */
public open class TreeNode<T>(
    public val value: T,
) : Iterable<TreeNode<T>>, ChildDeclarationInterface<T> {

    private var _parent: TreeNode<T>? = null

    /** The converse notion of a child, an immediate ancestor. */
    public val parent: TreeNode<T>?
        get() = _parent

    private val _children = mutableListOf<TreeNode<T>>()

    /** A group of nodes with the same parent. */
    public val children: List<TreeNode<T>>
        get() = _children

    /** The root of the tree. */
    public val root: TreeNode<T>
        get() = parent?.root ?: this

    /**
     * Checks whether the current tree node is the root of the tree
     *
     * @return `true` if the current tree node is root of the tree, `false` otherwise.
     */
    public val isRoot: Boolean
        get() = _parent == null

    /** Choose one of available iterators from [TreeNodeIterators] */
    public var defaultIterator: TreeNodeIterators = TreeNodeIterators.PreOrder

    /**
     * Add new child to current node or root.
     *
     * @param child A node which will be directly connected to current node.
     */
    public fun addChild(child: TreeNode<T>) {
        child._parent = this
        _children.add(child)
    }

    @JvmSynthetic
    override fun child(value: T, childDeclaration: ChildDeclaration<T>?): TreeNode<T> {
        val newChild = TreeNode(value)
        newChild._parent = this
        if (childDeclaration != null) newChild.childDeclaration()
        _children.add(newChild)
        return newChild
    }

    /**
     * Removes a single instance of the specified node from this tree, if it is present.
     *
     * @return `true` if the node has been successfully removed; `false` if it was not present in
     *   the tree.
     */
    public fun removeChild(child: TreeNode<T>): Boolean {
        println(child.value)
        val removed = child._parent?._children?.remove(child)
        child._parent = null
        return removed ?: false
    }

    /**
     * This function go through tree and counts children. Root element is not counted.
     *
     * @return All child and nested child count.
     */
    public val nodeCount: Int
        get() {
            if (_children.isEmpty()) return 0
            return _children.size + _children.sumOf(TreeNode<T>::nodeCount)
        }

    /**
     * @return The number of edges on the longest path between current node and a descendant leaf.
     */
    public val height: Int
        get() {
            val childrenMaxDepth =
                _children.maxOfOrNull(TreeNode<T>::height)
                    ?: -1 // -1 because this method counts nodes, and edges are always one less then
            // nodes.
            return childrenMaxDepth + 1
        }

    /**
     * Distance is the number of edges along the shortest path between two nodes.
     *
     * @return The distance between current node and the root.
     */
    public val depth: Int
        get() {
            var depth = 0
            var tempParent = parent

            while (tempParent != null) {
                depth++
                tempParent = tempParent.parent
            }
            return depth
        }

    /**
     * Returns the collection of nodes, which connect the current node with its descendants
     *
     * @param descendant the bottom child node for which the path is calculated
     * @return collection of nodes, which connect the current node with its descendants
     * @throws TreeNodeException exception that may be thrown in case if the current node does not
     *   have such descendant or if the specified tree node is root
     */
    @Throws(TreeNodeException::class)
    public fun path(descendant: TreeNode<T>): List<TreeNode<T>> {

        val path = mutableListOf<TreeNode<T>>()
        var node = descendant
        path.add(node)
        while (!node.isRoot) {
            node = node.parent!!
            path.add(node)
            if (node == this) return path
        }
        throw TreeNodeException(
            "The specified tree node $descendant is not the descendant of tree node $this"
        )
    }

    /** Remove all children from root and every node in tree. */
    public fun clear() {
        _parent = null
        _children.forEach { it.clear() }
        _children.clear()
    }

    override fun toString(): String {
        return value.toString()
    }

    public fun prettyString(): String {
        val stringBuilder = StringBuilder()
        print(stringBuilder, "", "")
        return stringBuilder.toString()
    }

    private fun print(stringBuilder: StringBuilder, prefix: String, childrenPrefix: String) {
        stringBuilder.append(prefix)
        stringBuilder.append(value)
        stringBuilder.append('\n')
        val childIterator = _children.iterator()
        while (childIterator.hasNext()) {
            val node = childIterator.next()
            if (childIterator.hasNext()) {
                node.print(stringBuilder, "$childrenPrefix├── ", "$childrenPrefix│   ")
            } else {
                node.print(stringBuilder, "$childrenPrefix└── ", "$childrenPrefix    ")
            }
        }
    }

    /** You can change default iterator by changing [defaultIterator] property. */
    override fun iterator(): Iterator<TreeNode<T>> =
        when (defaultIterator) {
            TreeNodeIterators.PreOrder -> PreOrderTreeIterator(this)
            TreeNodeIterators.PostOrder -> PostOrderTreeIterator(this)
            TreeNodeIterators.LevelOrder -> LevelOrderTreeIterator(this)
        }
}

public interface ChildDeclarationInterface<T> {

    /**
     * This method is used to easily create child in node.
     *
     * ```
     * val root = tree("World") {
     *     child("North America") {
     *         child("USA")
     *     }
     *     child("Europe") {
     *         child("Poland")
     *         child("Germany")
     *     }
     * }
     * ```
     *
     * @return New created TreeNode.
     */
    @JvmSynthetic
    public fun child(value: T, childDeclaration: ChildDeclaration<T>? = null): TreeNode<T>
}

public typealias ChildDeclaration<T> = ChildDeclarationInterface<T>.() -> Unit

/**
 * This method can be used to initialize new tree.
 *
 * ```
 * val root = tree("World") { ... }
 * ```
 *
 * @param root Root element of new tree.
 * @see [ChildDeclarationInterface.child]
 */
@JvmSynthetic
public inline fun <reified T> tree(
    root: T,
    defaultIterator: TreeNodeIterators = TreeNodeIterators.PreOrder,
    childDeclaration: ChildDeclaration<T>
): TreeNode<T> {
    val treeNode = TreeNode(root)
    treeNode.defaultIterator = defaultIterator
    treeNode.childDeclaration()
    return treeNode
}

public class TreeNodeException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
