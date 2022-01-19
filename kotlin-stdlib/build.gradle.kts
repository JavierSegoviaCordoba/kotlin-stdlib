plugins {
    `kotlin-multiplatform`
    `javiersc-kotlin-config`
    `javiersc-publish`
    id("com.diffplug.spotless")
}

tasks.named("spotlessCheck") {
    notCompatibleWithConfigurationCache("https://github.com/diffplug/spotless/issues/987")
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

    sourceSets {
        commonTest {
            dependencies {
                implementation(libs.jetbrains.kotlin.kotlinTest)
                implementation(libs.kotest.kotestAssertionsCore)
            }
        }
    }
}
