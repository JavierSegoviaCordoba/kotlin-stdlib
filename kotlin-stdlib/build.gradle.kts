import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    `kotlin-multiplatform`
    `javiersc-kotlin-library`
    `javiersc-publish`
}

kotlin {
    explicitApi()

    iosArm64()
    iosSimulatorArm64()
    iosX64()

    jvm()

    js(BOTH) {
        browser()
        nodejs()
    }

    linuxX64()

    macosArm64()
    macosX64()

    mingwX64()

    tvosArm64()
    tvosSimulatorArm64()
    tvosX64()

    watchosArm64()
    watchosSimulatorArm64()
    watchosX64()
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
