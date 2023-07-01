package com.javiersc.kotlin.stdlib.graph

public interface Graph<T> : Map<Graph.Vertex<T>, MutableList<Graph.Edge<T>>> {

    public val renderer: (Any?.() -> String)
        get() = { this.toString() }

    public val circularVertexes: Map<T, List<T>>
        get() {
            val circularDependencies = mutableMapOf<T, MutableList<T>>()
            val visited = mutableSetOf<Vertex<T>>()

            for (vertex in keys) {
                if (vertex !in visited) {
                    val path = mutableListOf<Vertex<T>>()
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

    public fun toGraph(): Graph<T> = this

    public fun containsCircularVertexes(value: T): Boolean =
        circularVertexes[value]?.isNotEmpty() == true

    public fun doesNotContainsCircularVertexes(value: T): Boolean = !containsCircularVertexes(value)

    public fun vertexesFor(value: T): List<T> {
        if (containsCircularVertexes(value)) return emptyList()
        val vertex: Vertex<T> = keys.find { it.value == value } ?: return emptyList()
        val edges: List<Edge<T>> = this[vertex] ?: return emptyList()
        val destinationVertexes: Sequence<Vertex<T>> = edges.asSequence().map(Edge<T>::destination)
        val destinations: Sequence<T> = destinationVertexes.map(Vertex<T>::value)
        return (destinations + destinationVertexes.flatMap { vertexesFor(it.value) }).toList()
    }

    public fun vertexesFor(vararg values: T): List<T> = values.flatMap(::vertexesFor)

    public fun renderer(block: Any?.() -> String)

    public data class Edge<T>(
        val source: Vertex<T>,
        val destination: Vertex<T>,
    )

    public data class Vertex<T>(
        val index: Int,
        val value: T,
    )

    private fun Vertex<T>.deepFirstSearchCircularDependencies(
        visited: MutableSet<Vertex<T>>,
        path: MutableList<Vertex<T>>,
        circularDependencies: MutableMap<T, MutableList<T>>
    ) {
        val map = this@Graph
        val vertex = this
        visited.add(vertex)
        path.add(vertex)

        val edges = map[vertex] ?: return

        for (edge in edges) {
            val destination = edge.destination

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

public class MutableGraph<T>(
    mutableMap: MutableMap<Graph.Vertex<T>, MutableList<Graph.Edge<T>>> = mutableMapOf()
) : Graph<T>, MutableMap<Graph.Vertex<T>, MutableList<Graph.Edge<T>>> by mutableMap {

    override var renderer: (Any?.() -> String) = { this.toString() }

    private val _missingVertexes: MutableSet<T> = mutableSetOf()
    override val missingVertexes: Set<T> = _missingVertexes

    public fun addVertex(data: T): T {
        val vertex: Graph.Vertex<T> = Graph.Vertex(this.count(), data)
        this[vertex] = mutableListOf()
        return data
    }

    public fun addEdge(source: T, destination: T) {
        val sourceVertex: Graph.Vertex<T>? = keys.find { it.value == source }
        val destinationVertex: Graph.Vertex<T>? = keys.find { it.value == destination }
        if (sourceVertex == null) _missingVertexes.add(source)
        if (destinationVertex == null) _missingVertexes.add(destination)
        if (sourceVertex != null && destinationVertex != null) {
            val edge: Graph.Edge<T> = Graph.Edge(sourceVertex, destinationVertex)
            this[sourceVertex]?.add(edge)
        }
    }

    override fun renderer(block: Any?.() -> String) {
        this.renderer = block
    }

    override fun toString(): String = asString()
}

public fun <T> buildGraph(builderAction: MutableGraph<T>.() -> Unit = {}): Graph<T> =
    MutableGraph<T>().apply(builderAction)

public fun <T> mutableGraphOf(builderAction: MutableGraph<T>.() -> Unit = {}): MutableGraph<T> =
    MutableGraph<T>().apply(builderAction)
