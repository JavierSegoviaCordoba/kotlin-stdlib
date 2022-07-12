plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        publishing()
    }
    kotlin {
        multiplatform {
            features {
                extendedStdlib(enabled = false)
            }

            common {
                main {
                    dependencies {
                        implementation(jetbrainsKotlinTest())
                        implementation(jetbrainsKotlinTestJunit())
                    }
                }
            }

            android()

            darwin()

            ios()
            iosArm32()
            iosArm64()
            iosSimulatorArm64()
            iosX64()

            jvm()

            js {
                browser()
                nodejs()
            }

            linux()
            linuxArm32Hfp()
            linuxArm64()
            linuxMips32()
            linuxMipsel32()
            linuxX64()

            macos()
            macosArm64()
            macosX64()

            mingw()
            mingwX86()
            mingwX64()

            native()

            tvos()
            tvosArm64()
            tvosSimulatorArm64()
            tvosX64()

            watchos()
            watchosArm32()
            watchosArm64()
            watchosSimulatorArm64()
            watchosX64()
            watchosX86()

            wasm()
            wasm32()
        }
    }
}
