package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.Either

public inline fun <reified E : Any, reified T : Any> T.validateWith(
    validator: Validator<E, T>
): Either<List<E>, T> {
    val validated: Either<List<E>, T> = validator.validate(this)
    return validated
}
