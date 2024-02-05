plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(hubdle.javiersc.kotlin.stdlib)
    implementation(hubdle.jetbrains.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("convention") {
            id = "convention"
            implementationClass = "ConventionPlugin"
        }
    }
}
