package com.javiersc.kotlin.test

import com.javiersc.kotlin.stdlib.isNotNullNorBlank
import com.javiersc.kotlin.stdlib.isNotNullNorEmpty
import kotlin.contracts.contract

public inline fun String?.assertNotBlank(message: String? = null): String {
    contract { returns() implies (this@assertNotBlank != null) }

    if (this.isNotNullNorBlank()) return this

    fail(message ?: "Expected not blank but was 'null' or blank")
}

public inline fun String?.assertNotEmpty(message: String? = null): String {
    contract { returns() implies (this@assertNotEmpty != null) }

    if (this.isNotNullNorEmpty()) return this

    fail(message ?: "Expected not blank but was 'null' or empty")
}
