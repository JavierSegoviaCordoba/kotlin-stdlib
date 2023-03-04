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
        languageSettings {
            experimentalContracts()
        }
    }
    kotlin {
        multiplatform {
            features {
                extendedStdlib.isEnabled.set(false)
            }

            common()
            android()
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
            jvm()
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
