@file:Suppress("EnumEntryName")

package com.javiersc.kotlin.stdlib

public expect val CurrentPlatform: Platform

public val Platform.isAndroid: Boolean
    get() = this is Platform.Android

public val Platform.isAndroidNative: Boolean
    get() = this.isAndroid && this.isNative

public val Platform.isApple: Boolean
    get() = this is Platform.Apple

public val Platform.isIOS: Boolean
    get() = this is Platform.IOS

public val Platform.isJVM: Boolean
    get() = this is Platform.JVM

public val Platform.isJS: Boolean
    get() = this is Platform.JS

public val Platform.isJvmNotAndroid: Boolean
    get() = this.isJVM && !this.isAndroid

public val Platform.isLinux: Boolean
    get() = this is Platform.Linux

public val Platform.isMacOS: Boolean
    get() = this is Platform.MacOS

public val Platform.isMinGW: Boolean
    get() = this is Platform.MinGW

public val Platform.isNative: Boolean
    get() = this is Platform.Native

public val Platform.isTvOS: Boolean
    get() = this is Platform.TvOS

public val Platform.isWatchOS: Boolean
    get() = this is Platform.WatchOS

public val Platform.isWAsm: Boolean
    get() = this is Platform.WAsm

public sealed interface Platform {

    public val name: String

    public sealed interface Android : Platform {

        public data object Arm32 : Android, Native {
            override val name: String = "androidNativeArm32"
        }

        public data object Arm64 : Android, Native {
            override val name: String = "androidNativeArm64"
        }

        public data object X64 : Android, Native {
            override val name: String = "androidNativeX64"
        }

        public data object X86 : Android, Native {
            override val name: String = "androidNativeX86"
        }

        public companion object : Android, JVM {
            override val name: String = "android"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface Apple : Platform, Native {

        public companion object : Apple {
            override val name: String = "apple"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface IOS : Apple {

        public data object Arm64 : IOS {
            override val name: String = "iosArm64"
        }

        public data object SimulatorArm64 : IOS {
            override val name: String = "iosSimulatorArm64"
        }

        public data object X64 : IOS {
            override val name: String = "iosX64"
        }

        public companion object : IOS {
            override val name: String = "ios"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface JVM : Platform {

        public companion object : JVM {

            override val name: String = "jvm"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface JS : Platform {

        public data object Browser : JS {
            override val name: String = "jsBrowser"
        }

        public data object NodeJS : JS {
            override val name: String = "jsNodeJS"
        }

        public companion object : JS {
            override val name: String = "js"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface Linux : Native {

        public data object Arm64 : Linux {
            override val name: String = "linuxArm64"
        }

        public data object X64 : Linux {
            override val name: String = "linuxX64"
        }

        public companion object : Linux {
            override val name: String = "linux"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface MacOS : Apple {

        public data object Arm64 : MacOS {
            override val name: String = "macosArm64"
        }

        public data object X64 : MacOS {
            override val name: String = "macosX64"
        }

        public companion object : MacOS {
            override val name: String = "macos"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface MinGW : Native {

        public data object X64 : MinGW {
            override val name: String = "mingwX64"
        }

        public companion object : MinGW {
            override val name: String = "mingw"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface Native : Platform {

        public companion object : Native {
            override val name: String = "native"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface TvOS : Apple {

        public data object Arm64 : TvOS {
            override val name: String = "tvosArm64"
        }

        public data object SimulatorArm64 : TvOS {
            override val name: String = "tvosSimulatorArm64"
        }

        public data object X64 : TvOS {
            override val name: String = "tvosX64"
        }

        public companion object : TvOS {
            override val name: String = "tvos"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface WAsm : Platform {

        public sealed interface JS : WAsm {

            public data object Browser : JS {
                override val name: String = "wasmJsBrowser"
            }

            public data object D8 : JS {

                override val name: String = "wasmJsD8"
            }

            public data object NodeJS : JS {
                override val name: String = "wasmJsNodeJS"
            }

            public companion object : JS {
                override val name: String = "wasmJs"

                override fun toString(): String = name.uppercase()
            }
        }

        public sealed interface WAsi : WAsm {

            public data object NodeJS : WAsi {
                override val name: String = "wasmWasiNodeJS"
            }

            public companion object : WAsi {
                override val name: String = "wasmWasi"

                override fun toString(): String = name.uppercase()
            }
        }

        public companion object : WAsm {
            override val name: String = "wasm"

            override fun toString(): String = name.uppercase()
        }
    }

    public sealed interface WatchOS : Apple {

        public data object Arm32 : WatchOS {
            override val name: String = "watchosArm32"
        }

        public data object Arm64 : WatchOS {
            override val name: String = "watchosArm64"
        }

        public data object DeviceArm64 : WatchOS {
            override val name: String = "watchosDeviceArm64"
        }

        public data object SimulatorArm64 : WatchOS {
            override val name: String = "watchosSimulatorArm64"
        }

        public data object X64 : WatchOS {
            override val name: String = "watchosX64"
        }

        public companion object : WatchOS {
            override val name: String = "watchos"

            override fun toString(): String = name.uppercase()
        }
    }
}
