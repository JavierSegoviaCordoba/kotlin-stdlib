package com.javiersc.kotlin.test

import kotlin.test.asserter

@PublishedApi internal fun fail(message: String?): Nothing = asserter.fail(message)
