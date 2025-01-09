package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.UseContextParameters

public class ValidatorScope<E, V>
@PublishedApi
internal constructor(private val _validatables: MutableList<Validatable<E>> = mutableListOf()) {

    @PublishedApi
    internal val validatables: List<Validatable<E>>
        get() = _validatables.toList()

    public fun invalid(predicate: () -> Boolean, otherwise: () -> E) {
        _validatables.add(Validatable(predicate = predicate, otherwise = otherwise))
    }

    public fun invalidIf(predicate: () -> Boolean, otherwise: () -> E) {
        invalid(predicate = predicate, otherwise = otherwise)
    }

    public fun valid(predicate: () -> Boolean, otherwise: () -> E) {
        _validatables.add(Validatable(predicate = { !predicate() }, otherwise = otherwise))
    }

    public fun validIf(predicate: () -> Boolean, otherwise: () -> E) {
        valid(predicate = predicate, otherwise = otherwise)
    }

    public operator fun <T> T.invoke(block: T.() -> Unit): T {
        block()
        return this
    }

    @UseContextParameters
    public fun String.invalidIfIsEmpty(otherwise: () -> E) {
        invalid(predicate = ::isEmpty, otherwise = otherwise)
    }

    @UseContextParameters
    public fun String.invalidIfIsBlank(otherwise: () -> E) {
        invalid(predicate = ::isBlank, otherwise = otherwise)
    }

    public fun <E2 : E, V2> validator(validator: Validator<E2, V2>, value: V2) {
        val scope = ValidatorScope<E2, V2>()
        validator.block(scope, value)
        val validatables: List<Validatable<E2>> = scope.validatables
        val mappedValidatables: List<Validatable<E>> =
            validatables.map { Validatable(predicate = it.predicate, otherwise = it.otherwise) }
        _validatables.addAll(mappedValidatables)
    }

    public infix fun <E2 : E, V2> Validator<E2, V2>.validatorFor(value: V2) {
        validator(this, value)
    }

    public infix fun <E2 : E, V2> V2.validatedBy(validator: Validator<E2, V2>) {
        validator(validator, this)
    }

    @PublishedApi
    internal data class Validatable<E>(val predicate: () -> Boolean, val otherwise: () -> E)

    public class NestedScope<E2, V2>(internal val validator: Validator<E2, V2>)
}
