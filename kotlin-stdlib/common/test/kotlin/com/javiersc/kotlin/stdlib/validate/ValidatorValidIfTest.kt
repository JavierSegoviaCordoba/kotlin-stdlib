package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._fixtures.LordOfTheRingsBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorValidIfTest {

    @Test
    fun given__a_validator_using_validIf_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            validIf(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { Book.Error.WrongTitle },
            )
            validIf(
                predicate = { book.author.name == "Tolkien" },
                otherwise = { Book.Error.WrongAuthor },
            )
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_validIf_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            validIf(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { Book.Error.WrongTitle },
            )
            validIf(
                predicate = { book.author.name == "Tolkien" },
                otherwise = { Book.Error.WrongAuthor },
            )
        }
        HarryPotterBook.validateWith(validator)
            .assertLeft(Book.Error.WrongTitle, Book.Error.WrongAuthor)
    }

    @Test
    fun given__a_validator_using_validIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            book {
                validIf(
                    predicate = { title == "Lord of the Rings" },
                    otherwise = { Book.Error.WrongTitle },
                )
                author {
                    validIf(
                        predicate = { name == "Tolkien" },
                        otherwise = { Book.Error.WrongAuthor },
                    )
                }
            }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_validIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            book {
                validIf(
                    predicate = { title == "Lord of the Rings" },
                    otherwise = { Book.Error.WrongTitle },
                )
                author {
                    validIf(
                        predicate = { name == "Tolkien" },
                        otherwise = { Book.Error.WrongAuthor },
                    )
                }
            }
        }
        HarryPotterBook.validateWith(validator)
            .assertLeft(Book.Error.WrongTitle, Book.Error.WrongAuthor)
    }
}
