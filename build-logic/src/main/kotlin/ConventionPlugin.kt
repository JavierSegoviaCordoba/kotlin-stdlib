import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

open class ConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.pluginManager.withPlugin("org.jetbrains.kotlin.multiplatform") {
            val kotlin: KotlinProjectExtension = project.the()
            GenerateIgnoreClassesTask.register(project, kotlin.sourceSets)
        }
    }
}
