package com.javiersc.kotlin.stdlib

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

actual class PlatformTest {

    @Test
    actual fun check_CurrentPlatform_is_correct() {
        assertFalse(CurrentPlatform.isAndroid)
        assertFalse(CurrentPlatform.isAndroidNative)
        assertFalse(CurrentPlatform.isApple)
        assertFalse(CurrentPlatform.isIOS)
        assertFalse(CurrentPlatform.isJVM)
        assertFalse(CurrentPlatform.isJvmNotAndroid)
        assertFalse(CurrentPlatform.isJS)
        assertTrue(CurrentPlatform.isLinux)
        assertFalse(CurrentPlatform.isMacOS)
        assertFalse(CurrentPlatform.isMinGW)
        assertTrue(CurrentPlatform.isNative)
        assertFalse(CurrentPlatform.isTvOS)
        assertFalse(CurrentPlatform.isWAsm)
        assertFalse(CurrentPlatform.isWatchOS)

        assertNotEquals(Platform.Android.Arm32, CurrentPlatform)
        assertNotEquals(Platform.Android.Arm32.name, CurrentPlatform.name)
        assertNotEquals(Platform.Android.Arm64, CurrentPlatform)
        assertNotEquals(Platform.Android.Arm64.name, CurrentPlatform.name)
        assertNotEquals(Platform.Android.X64, CurrentPlatform)
        assertNotEquals(Platform.Android.X64.name, CurrentPlatform.name)
        assertNotEquals(Platform.Android.X86, CurrentPlatform)
        assertNotEquals(Platform.Android.X86.name, CurrentPlatform.name)
        assertNotEquals(Platform.Android, CurrentPlatform)
        assertNotEquals(Platform.Android.name, CurrentPlatform.name)

        assertNotEquals(Platform.Apple, CurrentPlatform)
        assertNotEquals(Platform.Apple.name, CurrentPlatform.name)

        assertNotEquals(Platform.IOS.Arm64, CurrentPlatform)
        assertNotEquals(Platform.IOS.Arm64.name, CurrentPlatform.name)
        assertNotEquals(Platform.IOS.SimulatorArm64, CurrentPlatform)
        assertNotEquals(Platform.IOS.SimulatorArm64.name, CurrentPlatform.name)
        assertNotEquals(Platform.IOS.X64, CurrentPlatform)
        assertNotEquals(Platform.IOS.X64.name, CurrentPlatform.name)
        assertNotEquals(Platform.IOS, CurrentPlatform)
        assertNotEquals(Platform.IOS.name, CurrentPlatform.name)

        assertNotEquals(Platform.JVM, CurrentPlatform)
        assertNotEquals(Platform.JVM.name, CurrentPlatform.name)

        assertNotEquals(Platform.JS.Browser, CurrentPlatform)
        assertNotEquals(Platform.JS.Browser.name, CurrentPlatform.name)
        assertNotEquals(Platform.JS.NodeJS, CurrentPlatform)
        assertNotEquals(Platform.JS.NodeJS.name, CurrentPlatform.name)
        assertNotEquals(Platform.JS, CurrentPlatform)
        assertNotEquals(Platform.JS.name, CurrentPlatform.name)

        assertNotEquals(Platform.Linux.Arm64, CurrentPlatform)
        assertNotEquals(Platform.Linux.Arm64.name, CurrentPlatform.name)
        assertEquals(Platform.Linux.X64, CurrentPlatform)
        assertEquals(Platform.Linux.X64.name, CurrentPlatform.name)
        assertNotEquals(Platform.Linux, CurrentPlatform)
        assertNotEquals(Platform.Linux.name, CurrentPlatform.name)

        assertNotEquals(Platform.MacOS.Arm64, CurrentPlatform)
        assertNotEquals(Platform.MacOS.Arm64.name, CurrentPlatform.name)
        assertNotEquals(Platform.MacOS.X64, CurrentPlatform)
        assertNotEquals(Platform.MacOS.X64.name, CurrentPlatform.name)
        assertNotEquals(Platform.MacOS, CurrentPlatform)
        assertNotEquals(Platform.MacOS.name, CurrentPlatform.name)

        assertNotEquals(Platform.MinGW.X64, CurrentPlatform)
        assertNotEquals(Platform.MinGW.X64.name, CurrentPlatform.name)
        assertNotEquals(Platform.MinGW, CurrentPlatform)
        assertNotEquals(Platform.MinGW.name, CurrentPlatform.name)

        assertNotEquals(Platform.Native, CurrentPlatform)
        assertNotEquals(Platform.Native.name, CurrentPlatform.name)

        assertNotEquals(Platform.TvOS.Arm64, CurrentPlatform)
        assertNotEquals(Platform.TvOS.Arm64.name, CurrentPlatform.name)
        assertNotEquals(Platform.TvOS.X64, CurrentPlatform)
        assertNotEquals(Platform.TvOS.X64.name, CurrentPlatform.name)
        assertNotEquals(Platform.TvOS, CurrentPlatform)
        assertNotEquals(Platform.TvOS.name, CurrentPlatform.name)

        assertNotEquals(Platform.WAsm.JS.Browser, CurrentPlatform)
        assertNotEquals(Platform.WAsm.JS.Browser.name, CurrentPlatform.name)
        assertNotEquals(Platform.WAsm.JS.D8, CurrentPlatform)
        assertNotEquals(Platform.WAsm.JS.D8.name, CurrentPlatform.name)
        assertNotEquals(Platform.WAsm.JS.NodeJS, CurrentPlatform)
        assertNotEquals(Platform.WAsm.JS.NodeJS.name, CurrentPlatform.name)
        assertNotEquals(Platform.WAsm.JS, CurrentPlatform)
        assertNotEquals(Platform.WAsm.JS.name, CurrentPlatform.name)

        assertNotEquals(Platform.WAsm.WAsi.NodeJS, CurrentPlatform)
        assertNotEquals(Platform.WAsm.WAsi.NodeJS.name, CurrentPlatform.name)
        assertNotEquals(Platform.WAsm.WAsi, CurrentPlatform)
        assertNotEquals(Platform.WAsm.WAsi.name, CurrentPlatform.name)

        assertNotEquals(Platform.WAsm, CurrentPlatform)
        assertNotEquals(Platform.WAsm.name, CurrentPlatform.name)

        assertNotEquals(Platform.WatchOS.Arm32, CurrentPlatform)
        assertNotEquals(Platform.WatchOS.Arm32.name, CurrentPlatform.name)
        assertNotEquals(Platform.WatchOS.Arm64, CurrentPlatform)
        assertNotEquals(Platform.WatchOS.Arm64.name, CurrentPlatform.name)
        assertNotEquals(Platform.WatchOS.SimulatorArm64, CurrentPlatform)
        assertNotEquals(Platform.WatchOS.SimulatorArm64.name, CurrentPlatform.name)
        assertNotEquals(Platform.WatchOS.X64, CurrentPlatform)
        assertNotEquals(Platform.WatchOS.X64.name, CurrentPlatform.name)
        assertNotEquals(Platform.WatchOS, CurrentPlatform)
        assertNotEquals(Platform.WatchOS.name, CurrentPlatform.name)
    }
}
