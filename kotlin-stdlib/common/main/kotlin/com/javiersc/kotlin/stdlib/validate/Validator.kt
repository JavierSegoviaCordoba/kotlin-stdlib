package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.Either
import com.javiersc.kotlin.stdlib.UseContextParameters
import com.javiersc.kotlin.stdlib.left
import com.javiersc.kotlin.stdlib.right

public class Validator<E, V>
@PublishedApi
internal constructor(
    @PublishedApi internal val name: String,
    @PublishedApi internal val block: ValidatorScope<E, V>.(V) -> Unit,
    private val _unit0: Unit,
) {

    public fun <A : V> validate(value: A): Either<List<E>, A> {
        val validatorScope = ValidatorScope<E, V>()
        block(validatorScope, value)

        val otherwises: List<E> =
            validatorScope.validatables.mapNotNull { if (it.predicate()) it.otherwise() else null }

        if (otherwises.isEmpty()) return value.right()

        val either: Either<List<E>, A> = otherwises.left()
        return either
    }
}

@Suppress("FunctionName")
public inline fun <E : Any, reified T : Any> Validator(
    name: String = T::class.simpleName ?: "Validator",
    @UseContextParameters noinline block: ValidatorScope<E, T>.(T) -> Unit,
): Lazy<Validator<E, T>> = lazy { Validator(name = name, block = block, _unit0 = Unit) }
