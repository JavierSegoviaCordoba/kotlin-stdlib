plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
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
                        implementation(jetbrainsKotlinTest())
                        implementation(jetbrainsKotlinTestAnnotationsCommon())
                    }
                }
            }

            // android {
            //     main {
            //         dependencies {
            //             implementation(jetbrainsKotlinTestTestng())
            //         }
            //     }
            // }

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
            jvm {
                main {
                    dependencies {
                        implementation(jetbrainsKotlinTestTestng())
                    }
                }
            }
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
