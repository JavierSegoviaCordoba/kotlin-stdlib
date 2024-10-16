import com.javiersc.gradle.properties.extensions.getBooleanProperty

hubdle {
    config {
        analysis()
        coverage()
        documentation { //
            api()
        }
        explicitApi()
        publishing()
        languageSettings { //
            experimentalContracts()
        }
    }
    kotlin {
        multiplatform {
            features {
                extendedStdlib.isEnabled.set(false)
                kotest.isEnabled.set(false)
            }

            common()
            if (getBooleanProperty("android.enabled").orElse(true).get()) android()
            androidNative {
                androidNativeArm32()
                androidNativeArm64()
                androidNativeX86()
                androidNativeX64()
            }
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
                    watchosDeviceArm64()
                    watchosSimulatorArm64()
                    watchosX64()
                }
            }
            jvm {
                test {
                    dependencies { //
                        implementation(hubdle.junit.jupiter.junit.jupiter)
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
            mingw { //
                mingwX64()
            }
            native()

            wasmJs()

            // TODO: Check if it can be removed with Kotlin 2.0.0+
            kotlin {
                sourceSets {
                    wasmJs {
                        browser { testTask { enabled = false } }
                        nodejs { testTask { enabled = false } }
                    }
                }
            }
        }
    }
}
