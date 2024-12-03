package com.javiersc.kotlin.stdlib

import java.io.File

@DslMarker public annotation class FileScopeMarker

@FileScopeMarker
public open class FileScope(file: File) : File(file.toURI()) {

    public fun file(name: String, block: FileScope.() -> Unit = {}): FileScope {
        val file = resolve(name).apply(File::createNewFile)
        val scope = FileScope(file)
        block(scope)
        return scope
    }
}

@FileScopeMarker
public open class DirScope(file: File) : FileScope(file) {

    public fun dir(name: String, block: DirScope.() -> Unit = {}): DirScope {
        val dir = resolve(name).apply(File::mkdir)
        val scope = DirScope(dir)
        block(scope)
        return scope
    }
}

public fun File.root(name: String, block: DirScope.() -> Unit = {}): DirScope {
    val dir: File = resolve(name).apply(File::mkdir)
    val scope: DirScope = object : DirScope(dir) {}
    block(scope)
    return scope
}

public fun resource(name: String): File = resourceOrNull(name) ?: error("File not found")

public fun resourceOrNull(name: String): File? =
    Thread.currentThread().contextClassLoader?.getResource(name)?.file?.let(::File)

public val File.children: Sequence<File>
    get() = walkTopDown().maxDepth(1) - this
