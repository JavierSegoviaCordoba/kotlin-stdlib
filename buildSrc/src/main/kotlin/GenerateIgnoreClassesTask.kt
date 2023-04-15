import com.javiersc.kotlin.stdlib.capitalize
import java.io.File
import javax.inject.Inject
import org.gradle.api.DefaultTask
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.plugins.BasePlugin.ASSEMBLE_TASK_NAME
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Provider
import org.gradle.api.provider.ProviderFactory
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFiles
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.listProperty
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.BaseKotlinCompile

abstract class GenerateIgnoreClassesTask
@Inject
constructor(
    objects: ObjectFactory,
    providers: ProviderFactory,
) : DefaultTask() {

    private val testDir: String =
        when (project.name) {
            "kotlin-test-junit" -> "junit"
            "kotlin-test-junit5" -> "junit5"
            "kotlin-test-testng" -> "testng"
            else -> throw IllegalStateException("Unknown project name: ${project.name}")
        }

    private val importPackage: String =
        when (project.name) {
            "kotlin-test-junit" -> "org.junit.Ignore"
            "kotlin-test-junit5" -> "org.junit.jupiter.api.Disabled"
            "kotlin-test-testng" -> "org.testng.annotations.Ignore"
            else -> throw IllegalStateException("Unknown project name: ${project.name}")
        }

    private val importClass: String =
        when (project.name) {
            "kotlin-test-junit" -> "Ignore"
            "kotlin-test-junit5" -> "Disabled"
            "kotlin-test-testng" -> "Ignore"
            else -> throw IllegalStateException("Unknown project name: ${project.name}")
        }

    private val mainKotlin = "main${File.separatorChar}kotlin"
    private val testDirWithSeparator = "$testDir${File.separatorChar}"
    private val mainWithSeparator = "${File.separatorChar}main"
    private val buildGeneratedWithSeparator =
        "build${File.separatorChar}generated${File.separatorChar}"

    @get:Input abstract val sourceSets: MapProperty<String, List<String>>

    @Input
    val names: ListProperty<String> =
        objects
            .listProperty<String>()
            .convention(
                sourceSets.map { sourceSets ->
                    sourceSets
                        .filter { (name, _) -> name.contains("Main") }
                        .filterNot { (name, _) ->
                            listOf(
                                    "androidNativeMain",
                                    "appleMain",
                                    "iosMain",
                                    "linuxMain",
                                    "macosMain",
                                    "mingwMain",
                                    "nativeMain",
                                    "tvosMain",
                                    "watchosMain",
                                )
                                .any { name == it }
                        }
                        .flatMap { (_, dirs) -> dirs }
                        .filter { dir -> dir.endsWith(mainKotlin) }
                        .map { dir ->
                            dir.substringAfterLast(testDirWithSeparator)
                                .substringAfterLast(buildGeneratedWithSeparator)
                                .substringBeforeLast(mainWithSeparator)
                        }
                        .distinct()
                }
            )

    @OutputFiles
    val outputFiles: Provider<List<File>> =
        providers.provider {
            names
                .get()
                .map { name ->
                    project.buildDir.resolve(
                        "generated/$name/main/kotlin/com/javiersc/kotlin/test/"
                    )
                }
                .flatMap { directory ->
                    names.get().map { name ->
                        val className = "Ignore${name.capitalize()}"
                        val ignoreClass =
                            directory.resolve("$className.kt").apply {
                                parentFile.mkdirs()
                                createNewFile()
                            }

                        if (directory.path.contains("common")) {
                            val fileContent = buildString {
                                appendLine("package com.javiersc.kotlin.test")
                                appendLine()
                                appendLine("public expect annotation class $className")
                            }
                            ignoreClass.writeText(fileContent)
                        }
                        if (!directory.path.contains("common")) {
                            val target =
                                directory.path
                                    .substringAfterLast(testDirWithSeparator)
                                    .substringAfterLast(buildGeneratedWithSeparator)
                                    .substringBeforeLast(mainWithSeparator)

                            val import =
                                if (target == "android" || target == "jvm") importPackage
                                else "kotlin.test.Ignore"

                            val importClass =
                                if (target == "android" || target == "jvm") importClass
                                else "Ignore"

                            val fileContent = buildString {
                                appendLine("package com.javiersc.kotlin.test")
                                appendLine()
                                if (name == target) {
                                    appendLine("import $import")
                                    appendLine()
                                    appendLine("public actual typealias $className = $importClass")
                                } else {
                                    appendLine("public actual annotation class $className")
                                }
                            }

                            ignoreClass.writeText(fileContent)
                        }

                        ignoreClass
                    }
                }
        }

    @TaskAction
    fun generate() {
        outputFiles.get()
    }

    companion object {
        const val TASK_NAME = "generateIgnoreClasses"

        fun register(
            project: Project,
            kotlinSourceSets: NamedDomainObjectContainer<KotlinSourceSet>
        ) {
            val kotlinSourceSetsMap: Provider<Map<String, List<String>>> =
                project.provider {
                    kotlinSourceSets.associate {
                        it.name to it.kotlin.srcDirs.map { dir -> dir.path }
                    }
                }

            val generateIgnoreClassesTask: TaskProvider<GenerateIgnoreClassesTask> =
                project.tasks.register<GenerateIgnoreClassesTask>(TASK_NAME)

            generateIgnoreClassesTask.configure { sourceSets.set(kotlinSourceSetsMap) }

            project.tasks.withType<BaseKotlinCompile>().configureEach {
                dependsOn(generateIgnoreClassesTask)
            }

            project.tasks.withType<KotlinCompile<*>>().configureEach {
                dependsOn(generateIgnoreClassesTask)
            }

            project.tasks.withType<Jar>().configureEach { dependsOn(generateIgnoreClassesTask) }

            project.afterEvaluate {
                listOf(
                        "detekt",
                        "spotlessKotlin",
                    )
                    .forEach { tasks.findByName(it)?.dependsOn(generateIgnoreClassesTask) }
            }

            project.tasks.named(ASSEMBLE_TASK_NAME) { dependsOn(generateIgnoreClassesTask) }
        }
    }
}
