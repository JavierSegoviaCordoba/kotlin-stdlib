import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    `kotlin-multiplatform`
    `javiersc-kotlin-library`
}

kotlin {
    explicitApi()

    jvm()
}

tasks.withType<DokkaTask> {
    dokkaSourceSets {
        configureEach {
            val paths: List<String> =
                file("${rootProject.projectDir}/samples/commonMain/kotlin")
                    .walkTopDown()
                    .filter(File::isFile)
                    .map(File::getPath).toList()
            println("HELLO")
            println(paths)
            samples.from(paths)
        }
    }
}
