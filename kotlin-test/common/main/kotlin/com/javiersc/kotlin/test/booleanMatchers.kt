package com.javiersc.kotlin.test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

public fun Boolean.assertFalse(message: String? = null) {
    assertFalse(this, message)
}

public fun Boolean.assertTrue(message: String? = null) {
    assertTrue(this, message)
}
