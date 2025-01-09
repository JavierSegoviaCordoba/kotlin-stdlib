package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib.Either
import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._fixtures.LordOfTheRingsBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorInvalidIfTest {

    @Test
    fun given__a_validator_using_invalidIf_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            invalidIf(
                predicate = { book.title != "Lord of the Rings" },
                otherwise = { Book.Error.WrongTitle },
            )
            invalidIf(
                predicate = { book.author.name != "Tolkien" },
                otherwise = { Book.Error.WrongAuthor },
            )
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalidIf_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            invalidIf(
                predicate = { book.title != "Lord of the Rings" },
                otherwise = { Book.Error.WrongTitle },
            )
            invalidIf(
                predicate = { book.author.name == "Tolkien" },
                otherwise = { Book.Error.WrongAuthor },
            )
        }
        val either: Either<List<Book.Error>, Book> = HarryPotterBook.validateWith(validator)
        either.assertLeft(Book.Error.WrongTitle)
    }

    @Test
    fun given__a_validator_using_invalidIf_api_and_a_book_with_multiple_errors__when__validates__then__is_invalid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            invalidIf(
                predicate = { book.title != "Lord of the Rings" },
                otherwise = { Book.Error.WrongTitle },
            )
            invalidIf(
                predicate = { book.author.name != "Tolkien" },
                otherwise = { Book.Error.WrongAuthor },
            )
        }
        val either: Either<List<Book.Error>, Book> = HarryPotterBook.validateWith(validator)
        either.assertLeft(Book.Error.WrongTitle, Book.Error.WrongAuthor)
    }

    @Test
    fun given__a_validator_using_invalidIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            book {
                invalidIf(
                    predicate = { title != "Lord of the Rings" },
                    otherwise = { Book.Error.WrongTitle },
                )
                invalidIf(
                    predicate = { author.name != "Tolkien" },
                    otherwise = { Book.Error.WrongAuthor },
                )
            }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalidIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            book {
                invalidIf(
                    predicate = { title != "Lord of the Rings" },
                    otherwise = { Book.Error.WrongTitle },
                )
                author {
                    invalidIf(
                        predicate = { name == "Tolkien" },
                        otherwise = { Book.Error.WrongAuthor },
                    )
                }
            }
        }
        val either: Either<List<Book.Error>, Book> = HarryPotterBook.validateWith(validator)
        either.assertLeft(Book.Error.WrongTitle)
    }
}
