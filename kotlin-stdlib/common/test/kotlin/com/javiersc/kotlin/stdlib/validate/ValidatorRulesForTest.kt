package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorRulesForTest {

    @Test
    fun given__a_validator_using_rulesFor_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<String, Book> by Validator { book ->
            rulesFor(book::title, book.author::name) { property, value ->
                invalidIf(
                    predicate = { value.any(Char::isDigit) },
                    otherwise = { "The $property must not contain numbers" },
                )
            }
        }
        val validator2: Validator<String, Book> by Validator { book ->
            rulesFor(book.title, book.author.name) { value ->
                invalidIf(
                    predicate = { value.any(Char::isDigit) },
                    otherwise = { "The property must not contain numbers" },
                )
            }
        }
        HarryPotterBook.validateWith(validator).assertRight()
        HarryPotterBook.validateWith(validator2).assertRight()
    }

    @Test
    fun given__a_validator_using_rulesFor_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<String, Book> by Validator { book ->
            rulesFor(book::title, book.author::name) { property, value ->
                invalidIf(
                    predicate = { value.any(Char::isDigit) },
                    otherwise = { "The $property must not contain numbers" },
                )
            }
        }
        val validator2: Validator<String, Book> by Validator { book ->
            rulesFor(book.title, book.author.name) { value ->
                invalidIf(
                    predicate = { value.any(Char::isDigit) },
                    otherwise = { "The property must not contain numbers" },
                )
            }
        }

        val harryPotterBook1: Book =
            HarryPotterBook.copy(
                title = "${HarryPotterBook.title} 1",
                author = HarryPotterBook.author.copy(name = "${HarryPotterBook.author} 1"),
            )

        harryPotterBook1
            .validateWith(validator)
            .assertLeft("The title must not contain numbers", "The name must not contain numbers")
        harryPotterBook1
            .validateWith(validator2)
            .assertLeft(
                "The property must not contain numbers",
                "The property must not contain numbers",
            )
    }
}
