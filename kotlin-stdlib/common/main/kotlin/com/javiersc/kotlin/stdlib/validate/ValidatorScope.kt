package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.UseContextParameters

public class ValidatorScope<V : Any>
@PublishedApi
internal constructor(private val _validatables: MutableList<Validatable> = mutableListOf()) {

    @PublishedApi
    internal val validatables: List<Validatable>
        get() = _validatables.toList()

    public fun invalid(predicate: () -> Boolean, otherwise: () -> String) {
        _validatables.add(Validatable(predicate = predicate, otherwise = otherwise))
    }

    public fun invalidIf(predicate: () -> Boolean) {
        invalid(predicate = predicate, otherwise = { InvalidProperty })
    }

    public fun valid(predicate: () -> Boolean, otherwise: () -> String) {
        _validatables.add(Validatable(predicate = { !predicate() }, otherwise = otherwise))
    }

    public fun validIf(predicate: () -> Boolean) {
        valid(predicate = predicate, otherwise = { InvalidProperty })
    }

    public operator fun <T> T.invoke(block: T.() -> Unit): T {
        block()
        return this
    }

    public fun <T> validationOf(vararg values: T, block: T.() -> Unit) {
        val validatableList: ValidatableList<T> = ValidatableList(values.toList())
        validatableList.invoke(block)
    }

    public infix fun <T> T.and(value: T): ValidatableList<T> = ValidatableList(listOf(this, value))

    public infix fun <T> ValidatableList<T>.and(value: T): ValidatableList<T> =
        ValidatableList(values + value)

    @UseContextParameters
    public fun String.invalidIfIsEmpty(otherwise: () -> String = { EmptyProperty }) {
        invalid(predicate = ::isEmpty, otherwise = otherwise)
    }

    @PublishedApi
    internal data class Validatable(val predicate: () -> Boolean, val otherwise: () -> String)

    public class ValidatableList<T>(public val values: List<T>) : List<T> by values {

        public operator fun invoke(block: T.() -> Unit) {
            for (value: T in values) block(value)
        }
    }
}
