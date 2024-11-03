package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.Either

public inline fun <reified T : Any> T.validateWith(validator: Validator<T>): Either<String, T> {
    val validated: Either<String, T> = validator.validate(this)
    return validated
}
