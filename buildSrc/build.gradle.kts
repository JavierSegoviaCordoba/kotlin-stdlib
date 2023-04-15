plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(hubdle.javiersc.kotlin.kotlinStdlib)
    implementation(hubdle.jetbrains.kotlin.kotlinGradlePluginApi)
}
