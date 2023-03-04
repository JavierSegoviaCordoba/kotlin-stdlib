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
                    iosArm32()
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
                    watchosX86()
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
                linuxArm32Hfp()
                linuxArm64()
                linuxMips32()
                linuxMipsel32()
                linuxX64()
            }
            mingw {
                mingwX86()
                mingwX64()
            }
            native()

            wasm {
                wasm32()
            }
        }
    }
}
