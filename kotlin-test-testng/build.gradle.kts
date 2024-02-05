import com.javiersc.hubdle.project.extensions.config.testing.HubdleConfigTestingExtension.Options.TestNG

plugins { //
    id("convention")
}

hubdle {
    config {
        analysis()
        coverage()
        documentation {
            api()
        }
        explicitApi()
        publishing()
        testing { //
            options.set(TestNG)
            test { //
                useTestNG()
            }
        }
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

            // android {
            //     main {
            //         dependencies {
            //             implementation(jetbrainsKotlinTestTestng())
            //         }
            //     }
            // }

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
                main {
                    dependencies {
                        implementation(hubdle.jetbrains.kotlin.test.testng)
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
            mingw {
                mingwX64()
            }

            wasmJs()
        }
    }
}
