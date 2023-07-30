package com.javiersc.kotlin.stdlib.graph

public interface Graph<T> : Map<Graph.Vertex<T>, List<Graph.Edge<T>>> {

    public var renderer: (Any?.() -> String)

    public val circularVertexes: Map<T, List<T>>
        get() {
            val circularDependencies: MutableMap<T, MutableList<T>> = mutableMapOf()
            val visited: MutableSet<Vertex<T>> = mutableSetOf()

            for (vertex: Vertex<T> in keys) {
                if (vertex !in visited) {
                    val path: MutableList<Vertex<T>> = mutableListOf()
                    vertex.deepFirstSearchCircularDependencies(visited, path, circularDependencies)
                }
            }

            return circularDependencies.mapValues { it.value.toList() }
        }

    public val hasCircularVertexes: Boolean
        get() = circularVertexes.isNotEmpty()

    public val duplicatedVertexes: Map<T, Int>
        get() = keys.groupingBy(Vertex<T>::value).eachCount().filterValues { it > 1 }

    public val hasDuplicatedVertexes: Boolean
        get() = duplicatedVertexes.isNotEmpty()

    public val missingVertexes: Set<T>

    public val hasMissingVertexes: Boolean
        get() = missingVertexes.isNotEmpty()

    public fun asString(): String = buildString {
        this@Graph.forEach { (vertex: Vertex<T>, edges: List<Edge<T>>) ->
            val value: String = renderer(vertex.value)
            val edgeString: String = edges.joinToString { renderer(it.destination.value) }
            appendLine("$value -> [$edgeString]")
        }
    }

    public fun contains(value: T): Boolean = keys.any { it.value == value }

    public fun contains(value: T, predicate: (T) -> Boolean): Boolean =
        keys.any { predicate(it.value) }

    public fun toGraph(): Graph<T> = this

    public fun containsCircularVertexes(value: T): Boolean =
        circularVertexes[value]?.isNotEmpty() == true

    public fun doesNotContainsCircularVertexes(value: T): Boolean = !containsCircularVertexes(value)

    public fun vertexesFor(value: T, predicate: (T) -> Boolean = { it == value }): List<T> {
        if (containsCircularVertexes(value)) return emptyList()
        val vertex: Vertex<T> = keys.find { predicate(it.value) } ?: return emptyList()
        val edges: List<Edge<T>> = this[vertex] ?: return emptyList()
        val destinationVertexes: Sequence<Vertex<T>> = edges.asSequence().map(Edge<T>::destination)
        val destinations: Sequence<T> = destinationVertexes.map(Vertex<T>::value)
        return (destinations + destinationVertexes.flatMap { vertexesFor(it.value) }).toList()
    }

    public fun vertexesFor(vararg values: T): List<T> = values.flatMap(::vertexesFor)

    public fun toGraphSortedByEdges(): Graph<T> = buildGraph {
        val sortedGraph: MutableGraph<T> = this
        val graph: Graph<T> = this@Graph
        val remainingMap: MutableMap<Vertex<T>, List<Edge<T>>> = graph.toMutableMap()
        while (remainingMap.isNotEmpty()) {
            val vertexesToBeRemoved: MutableList<Vertex<T>> = mutableListOf()
            for ((vertex: Vertex<T>, edges: List<Edge<T>>) in remainingMap) {
                if (edges.isEmpty()) {
                    sortedGraph.addVertex(vertex.value)
                    vertexesToBeRemoved.add(vertex)
                    println()
                }
                for (edge: Edge<T> in edges) {
                    if (edge.destination.value in sortedGraph.keys.map(Vertex<T>::value)) {
                        sortedGraph.addVertex(edge.source.value)
                        sortedGraph.addEdge(edge.source.value, edge.destination.value)
                        vertexesToBeRemoved.add(edge.source)
                        println()
                    }
                }
            }
            for (vertexToBeRemoved: Vertex<T> in vertexesToBeRemoved) {
                remainingMap.remove(vertexToBeRemoved)
            }
            vertexesToBeRemoved.clear()
        }
    }

    public fun renderer(block: Any?.() -> String) {
        this.renderer = block
    }

    public data class Vertex<T>(
        val index: Int,
        val value: T,
    )

    public data class Edge<T>(
        val source: Vertex<T>,
        val destination: Vertex<T>,
    )

    private fun Vertex<T>.deepFirstSearchCircularDependencies(
        visited: MutableSet<Vertex<T>>,
        path: MutableList<Vertex<T>>,
        circularDependencies: MutableMap<T, MutableList<T>>
    ) {
        val map: Graph<T> = this@Graph
        val vertex: Vertex<T> = this
        visited.add(vertex)
        path.add(vertex)

        val edges: List<Edge<T>> = map[vertex] ?: return

        for (edge: Edge<T> in edges) {
            val destination: Vertex<T> = edge.destination

            if (destination in path) {
                val circularDependency =
                    path.subList(path.indexOf(destination), path.size).map { it.value }
                circularDependencies
                    .getOrPut(circularDependency.first()) { mutableListOf() }
                    .addAll(circularDependency)
            } else if (destination !in visited) {
                destination.deepFirstSearchCircularDependencies(visited, path, circularDependencies)
            }
        }

        if (path.last() == vertex) {
            path.remove(vertex)
        }
    }
}

public class MutableGraph<T> internal constructor() : Graph<T> {

    override var renderer: (Any?.() -> String) = { this.toString() }

    private val _missingVertexes: MutableSet<T> = mutableSetOf()
    override val missingVertexes: Set<T> = _missingVertexes

    private val map: MutableMap<Graph.Vertex<T>, MutableList<Graph.Edge<T>>> = mutableMapOf()

    override val entries: Set<Map.Entry<Graph.Vertex<T>, List<Graph.Edge<T>>>>
        get() = map.entries

    override val keys: Set<Graph.Vertex<T>>
        get() = map.keys

    override val size: Int
        get() = map.size

    override val values: Collection<List<Graph.Edge<T>>>
        get() = map.values

    public fun addVertex(data: T): T {
        val vertex: Graph.Vertex<T> = Graph.Vertex(this.count(), data)
        map[vertex] = mutableListOf()
        return data
    }

    public fun addEdge(source: T, destination: T) {
        val sourceVertex: Graph.Vertex<T>? = keys.find { it.value == source }
        val destinationVertex: Graph.Vertex<T>? = keys.find { it.value == destination }
        if (sourceVertex == null) _missingVertexes.add(source)
        if (destinationVertex == null) _missingVertexes.add(destination)
        if (sourceVertex != null && destinationVertex != null) {
            val edge: Graph.Edge<T> = Graph.Edge(sourceVertex, destinationVertex)
            map[sourceVertex]?.add(edge)
        }
    }

    override fun isEmpty(): Boolean = map.isEmpty()

    override fun get(key: Graph.Vertex<T>): List<Graph.Edge<T>>? = map[key]

    override fun containsValue(value: List<Graph.Edge<T>>): Boolean = map.containsValue(value)

    override fun containsKey(key: Graph.Vertex<T>): Boolean = map.containsKey(key)

    override fun toString(): String = asString()
}

public fun <T> buildGraph(builderAction: MutableGraph<T>.() -> Unit = {}): Graph<T> =
    MutableGraph<T>().apply(builderAction)

public fun <T> mutableGraphOf(builderAction: MutableGraph<T>.() -> Unit = {}): MutableGraph<T> =
    MutableGraph<T>().apply(builderAction)
