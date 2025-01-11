package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.Either
import com.javiersc.kotlin.stdlib.left
import com.javiersc.kotlin.stdlib.right

public interface Validator<E, V> {

    public val ruleScopeBlock: RulesScope<E>.(V) -> Unit

    public fun <A : V> validate(value: A): Either<List<E>, A> {
        val ruleScope: RulesScope<E> = RuleScope<E>().also { it.ruleScopeBlock(value) }

        val otherwises: List<E> =
            ruleScope.rules.mapNotNull { if (!it.predicate()) it.otherwise() else null }

        return if (otherwises.isEmpty()) value.right() else otherwises.left()
    }
}

@Suppress("FunctionName")
public inline fun <E : Any, reified V : Any> Validator(
    noinline block: RulesScope<E>.(V) -> Unit
): Lazy<Validator<E, V>> = lazy {
    object : Validator<E, V> {

        override val ruleScopeBlock: RulesScope<E>.(V) -> Unit = block
    }
}

public inline fun <reified E : Any, reified T : Any> T.validateWith(
    validator: Validator<E, T>
): Either<List<E>, T> {
    val validated: Either<List<E>, T> = validator.validate(this)
    return validated
}
