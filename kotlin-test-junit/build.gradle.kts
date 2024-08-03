import com.javiersc.gradle.properties.extensions.getBooleanProperty

plugins { //
    id("convention")
}

hubdle {
    config {
        analysis()
        coverage()
        documentation { //
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
                        implementation(hubdle.jetbrains.kotlin.test)
                        implementation(hubdle.jetbrains.kotlin.test.annotations.common)
                    }
                }
            }
            if (getBooleanProperty("android.enabled").orElse(true).get()) {
                android {
                    main { //
                        dependencies { //
                            implementation(hubdle.jetbrains.kotlin.test.junit)
                        }
                    }
                }
            }
            androidNative {
                androidNativeArm32()
                androidNativeArm64()
                androidNativeX64()
                androidNativeX86()
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
                main { //
                    dependencies { //
                        implementation(hubdle.jetbrains.kotlin.test.junit)
                    }
                }
            }
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
            wasmJs()
        }
    }
}
