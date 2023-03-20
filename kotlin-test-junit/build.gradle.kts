hubdle {
    config {
        analysis()
        documentation {
            api()
        }
        explicitApi()
        publishing()
    }
    kotlin {
        multiplatform {
            features {
                extendedStdlib.isEnabled.set(false)
                kotest.isEnabled.set(false)
            }

            common {
                main {
                    dependencies {
                        implementation(hubdle.jetbrains.kotlin.kotlinTestAnnotationsCommon)
                        implementation(hubdle.jetbrains.kotlin.kotlinTestJUnit)
                    }
                }
            }
            android()
            apple {
                ios {
                    iosArm64()
                    iosSimulatorArm64()
                    iosX64()
                }
                macos {
                    macosArm64()
                    macosX64()
                }
                tvos {
                    tvosArm64()
                    tvosSimulatorArm64()
                    tvosX64()
                }
                watchos {
                    watchosArm32()
                    watchosArm64()
                    watchosSimulatorArm64()
                    watchosX64()
                }
            }
            jvm()
            jvmAndAndroid()
            js {
                browser()
                nodejs()
            }
            linux {
                linuxArm64()
                linuxX64()
            }
            mingw {
                mingwX64()
            }
            native()

            wasm {
                wasm32()
            }
        }
    }
}
