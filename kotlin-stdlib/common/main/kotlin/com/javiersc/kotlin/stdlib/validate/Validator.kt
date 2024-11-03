package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.Either
import com.javiersc.kotlin.stdlib.UseContextParameters

public class Validator<V : Any>
@PublishedApi
internal constructor(
    @PublishedApi internal val name: String,
    @PublishedApi internal val block: ValidatorScope<V>.(V) -> Unit,
) {

    public inline fun <reified A : V> validate(value: A): Either<String, A> {
        val validatorScope = ValidatorScope<V>()
        block(validatorScope, value)

        val otherwises: List<String> =
            validatorScope.validatables.mapNotNull { if (it.predicate()) it.otherwise() else null }

        if (otherwises.isEmpty()) return Either.Right(value)

        val sanitizedOtherwises: List<String> = buildList {
            addAll(otherwises)

            if (otherwises.count { it.contains(InvalidProperty) } > 1) {
                removeAll { it.contains(InvalidProperty) }
                add(MultipleInvalidProperties)
            }

            if (otherwises.count { it.contains(EmptyProperty) } > 1) {
                removeAll { it.contains(EmptyProperty) }
                add(MultipleEmptyProperties)
            }
        }

        val title = "'$name' is invalid due to:\n"
        val otherwisesAsText: String =
            sanitizedOtherwises.joinToString("\n") { message -> "    - $message" }
        val errorMessage: String = title + otherwisesAsText
        return Either.Left(value = errorMessage)
    }

    public companion object {

        public inline operator fun <reified T : Any> invoke(
            name: String = T::class.simpleName ?: "Validator",
            @UseContextParameters noinline block: ValidatorScope<T>.(T) -> Unit,
        ): Lazy<Validator<T>> = lazy { Validator(name = name, block = block) }
    }
}

@PublishedApi internal const val InvalidProperty: String = "Invalid property"
@PublishedApi internal const val MultipleInvalidProperties: String = "Multiple invalid properties"
@PublishedApi internal const val EmptyProperty: String = "Empty property"
@PublishedApi internal const val MultipleEmptyProperties: String = "Multiple empty properties"
