plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(hubdle.javiersc.kotlin.kotlinStdlib)
    implementation(hubdle.jetbrains.kotlin.kotlinGradlePlugin)
}

gradlePlugin {
    plugins {
        register("convention") {
            id = "convention"
            implementationClass = "ConventionPlugin"
        }
    }
}
