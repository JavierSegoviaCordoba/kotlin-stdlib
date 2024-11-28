package com.javiersc.kotlin.stdlib

import com.javiersc.kotlin.stdlib.graph.Graph
import com.javiersc.kotlin.stdlib.graph.buildGraph
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GraphTest {

    @Test
    fun basic() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addVertex(Baz)
            addEdge(Foo, Bar)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Bar]")
                appendLine("Bar -> []")
                appendLine("Baz -> []")
            }
            expect == actual
        }

        assertTrue { graph.contains(Foo) }
        assertTrue { graph.contains(Bar) }
        assertTrue { graph.contains(Baz) }
        assertFalse { graph.contains(Qux) }

        assertFalse { graph.hasCircularVertexes }
        assertFalse { graph.hasDuplicatedVertexes }
    }

    @Test
    fun complex() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addVertex(Baz)
            addVertex(Qux)
            addVertex(Quux)
            addVertex(Corge)
            addEdge(Foo, Bar)
            addEdge(Foo, Baz)
            addEdge(Bar, Qux)
            addEdge(Bar, Quux)
            addEdge(Baz, Corge)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Bar, Baz]")
                appendLine("Bar -> [Qux, Quux]")
                appendLine("Baz -> [Corge]")
                appendLine("Qux -> []")
                appendLine("Quux -> []")
                appendLine("Corge -> []")
            }
            expect == actual
        }
        assertFalse { graph.hasCircularVertexes }
        assertFalse { graph.hasDuplicatedVertexes }
    }

    @Test
    fun duplicate() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Foo)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> []")
                appendLine("Foo -> []")
            }
            expect == actual
        }
        assertTrue { graph.hasDuplicatedVertexes }
        assertTrue { graph.duplicatedVertexes == mapOf(Foo to 2) }
    }

    @Test
    fun duplicate_multiple() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Foo)
            addVertex(Foo)
            addVertex(Bar)
            addVertex(Bar)
            addVertex(Baz)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> []")
                appendLine("Foo -> []")
                appendLine("Foo -> []")
                appendLine("Bar -> []")
                appendLine("Bar -> []")
                appendLine("Baz -> []")
            }
            expect == actual
        }
        assertTrue { graph.hasDuplicatedVertexes }
        assertTrue { graph.duplicatedVertexes == mapOf(Foo to 3, Bar to 2) }
    }

    @Test
    fun circular_itself() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addEdge(Foo, Foo)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString { appendLine("Foo -> [Foo]") }
            expect == actual
        }

        assertTrue { graph.hasCircularVertexes }
        assertTrue {
            val actual: List<A> = graph.circularVertexes[Foo]!!
            val expect: List<A> = listOf(Foo)
            actual == expect
        }
        assertTrue { graph.containsCircularVertexes(Foo) }
    }

    @Test
    fun circular_itself_multiple() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addEdge(Foo, Foo)
            addEdge(Bar, Bar)
        }
        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Foo]")
                appendLine("Bar -> [Bar]")
            }
            expect == actual
        }

        assertTrue { graph.hasCircularVertexes }
        assertTrue {
            val actual: List<A> = graph.circularVertexes[Foo]!!
            val expect: List<A> = listOf(Foo)
            actual == expect
        }
        assertTrue {
            val actual: List<A> = graph.circularVertexes[Bar]!!
            val expect: List<A> = listOf(Bar)
            actual == expect
        }
    }

    @Test
    fun circular_simple() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addEdge(Foo, Bar)
            addEdge(Bar, Foo)
        }
        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Bar]")
                appendLine("Bar -> [Foo]")
            }
            expect == actual
        }

        assertTrue { graph.hasCircularVertexes }
        assertTrue {
            val actual: List<A> = graph.circularVertexes[Foo]!!
            val expect: List<A> = listOf(Foo, Bar)
            actual == expect
        }
    }

    @Test
    fun circular_complex() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addVertex(Baz)
            addVertex(Qux)
            addVertex(Quux)
            addVertex(Corge)
            addEdge(Foo, Bar)
            addEdge(Bar, Baz)
            addEdge(Baz, Qux)
            addEdge(Qux, Quux)
            addEdge(Quux, Foo)
        }
        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Bar]")
                appendLine("Bar -> [Baz]")
                appendLine("Baz -> [Qux]")
                appendLine("Qux -> [Quux]")
                appendLine("Quux -> [Foo]")
                appendLine("Corge -> []")
            }
            expect == actual
        }

        assertTrue { graph.hasCircularVertexes }
        assertTrue {
            val actual: List<A> = graph.circularVertexes[Foo]!!
            val expect: List<A> = listOf(Foo, Bar, Baz, Qux, Quux)
            actual == expect
        }
        assertTrue { graph.containsCircularVertexes(Foo) }
        assertFalse { graph.containsCircularVertexes(Bar) }
        assertFalse { graph.containsCircularVertexes(Corge) }
    }

    @Test
    fun missing_vertexes_simple() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addEdge(Foo, Bar)
            addEdge(Bar, Baz)
            addEdge(Baz, Qux)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Bar]")
                appendLine("Bar -> []")
            }
            expect == actual
        }

        assertTrue { graph.hasMissingVertexes }
        assertTrue {
            val actual: Set<A> = graph.missingVertexes
            val expect: Set<A> = setOf(Baz, Qux)
            actual == expect
        }
    }

    @Test
    fun vertexes_for_simple() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addEdge(Foo, Bar)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Bar]")
                appendLine("Bar -> []")
            }
            expect == actual
        }

        assertTrue { graph.vertexesFor(Foo) == listOf(Bar) }
        assertTrue { graph.vertexesFor(Bar) == emptyList<A>() }
    }

    @Test
    fun vertexes_for_complex() {
        val graph: Graph<A> = buildGraph {
            addVertex(Foo)
            addVertex(Bar)
            addVertex(Baz)
            addVertex(Qux)
            addVertex(Quux)
            addEdge(Foo, Bar)
            addEdge(Bar, Baz)
            addEdge(Baz, Qux)
            addEdge(Qux, Quux)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Foo -> [Bar]")
                appendLine("Bar -> [Baz]")
                appendLine("Baz -> [Qux]")
                appendLine("Qux -> [Quux]")
                appendLine("Quux -> []")
            }
            expect == actual
        }

        assertTrue { graph.vertexesFor(Foo) == listOf(Bar, Baz, Qux, Quux) }
        assertTrue { graph.vertexesFor(Bar) == listOf(Baz, Qux, Quux) }
        assertTrue { graph.vertexesFor(Baz) == listOf(Qux, Quux) }
        assertTrue { graph.vertexesFor(Qux) == listOf(Quux) }
        assertTrue { graph.vertexesFor(Quux) == emptyList<A>() }
    }

    @Test
    fun vertexes_sorted_by_edges() {
        val graph: Graph<A> = buildGraph {
            addVertex(Bar)
            addVertex(Foo)
            addVertex(Baz)
            addEdge(Bar, Baz)
            addEdge(Foo, Bar)
        }

        assertTrue {
            val actual: String = graph.toString()
            val expect: String = buildString {
                appendLine("Bar -> [Baz]")
                appendLine("Foo -> [Bar]")
                appendLine("Baz -> []")
            }
            expect == actual
        }

        assertTrue {
            val actual: String = graph.toGraphSortedByEdges().toString()
            val expect: String = buildString {
                appendLine("Baz -> []")
                appendLine("Bar -> [Baz]")
                appendLine("Foo -> [Bar]")
            }
            expect == actual
        }
    }
}

private sealed class A

private data object Foo : A()

private data object Bar : A()

private data object Baz : A()

private data object Qux : A()

private data object Quux : A()

private data object Corge : A()
