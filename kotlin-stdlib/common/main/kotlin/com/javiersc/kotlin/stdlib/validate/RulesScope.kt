package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.UseContextParameters
import com.javiersc.kotlin.stdlib.validate.RulesScope.Rule

public interface RulesScope<E> {

    public val rules: List<Rule<E>>

    public fun invalid(predicate: () -> Boolean, otherwise: () -> E)

    public fun invalidIf(predicate: () -> Boolean, otherwise: () -> E)

    public operator fun <T> T.invoke(block: T.() -> Unit): T {
        block()
        return this
    }

    public fun valid(predicate: () -> Boolean, otherwise: () -> E)

    public fun validIf(predicate: () -> Boolean, otherwise: () -> E)

    public fun <E2 : E, V2> validator(validator: Validator<E2, V2>, value: V2)

    public infix fun <E2 : E, V2> Validator<E2, V2>.validatorFor(value: V2) {
        validator(this, value)
    }

    public infix fun <E2 : E, V2> V2.validatedBy(validator: Validator<E2, V2>) {
        validator(validator, this)
    }

    public class Rule<out E>(public val predicate: () -> Boolean, public val otherwise: () -> E)

    @UseContextParameters
    public fun String.invalidIfIsEmpty(otherwise: () -> E) {
        invalidIf(predicate = ::isEmpty, otherwise = otherwise)
    }

    @UseContextParameters
    public fun String.invalidIfIsBlank(otherwise: () -> E) {
        invalidIf(predicate = ::isBlank, otherwise = otherwise)
    }
}

@Suppress("FunctionName")
internal fun <E> RuleScope(): RulesScope<E> =
    object : RulesScope<E> {
        private val _rules: MutableList<Rule<E>> = mutableListOf()

        override val rules: List<Rule<E>>
            get() = _rules.toList()

        override fun invalidIf(predicate: () -> Boolean, otherwise: () -> E) {
            rule(predicate = { !predicate() }, otherwise = otherwise)
        }

        override fun invalid(predicate: () -> Boolean, otherwise: () -> E) {
            rule(predicate = { !predicate() }, otherwise = otherwise)
        }

        override fun validIf(predicate: () -> Boolean, otherwise: () -> E) {
            rule(predicate = predicate, otherwise = otherwise)
        }

        override fun valid(predicate: () -> Boolean, otherwise: () -> E) {
            rule(predicate = predicate, otherwise = otherwise)
        }

        override fun <E2 : E, V2> validator(validator: Validator<E2, V2>, value: V2) {
            val scope: RulesScope<E2> = RuleScope()
            validator.ruleScopeBlock(scope, value)
            _rules.addAll(scope.rules)
        }

        private fun rule(predicate: () -> Boolean, otherwise: () -> E) {
            _rules.add(Rule(predicate = predicate, otherwise = otherwise))
        }
    }
