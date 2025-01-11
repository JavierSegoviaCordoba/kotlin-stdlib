package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.Book.Author
import com.javiersc.kotlin.stdlib._fixtures.BookError
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._fixtures.LordOfTheRingsBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorNestedValidatablesTest {

    @Test
    fun given__a_validator_with_nested_validators_using_valid_api_and_a_book__when__validates__then__is_valid() {
        val authorValidator: Validator<BookError.Author, Author> by Validator { author ->
            valid(
                predicate = { author.name == "Tolkien" },
                otherwise = { BookError.Author.Name.Wrong },
            )
        }

        val bookValidator: Validator<BookError, Book> by Validator { book ->
            valid(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { BookError.Title.Wrong },
            )
            validator(authorValidator, book.author)
        }

        LordOfTheRingsBook.validateWith(bookValidator).assertRight()
    }

    @Test
    fun given__a_validator_with_nested_validators_via_validatorFor_using_valid_api_and_a_book__when__validates__then__is_valid() {
        val authorValidator: Validator<BookError.Author, Author> by Validator { author ->
            valid(
                predicate = { author.name == "Tolkien" },
                otherwise = { BookError.Author.Name.Wrong },
            )
        }

        val bookValidator: Validator<BookError, Book> by Validator { book ->
            valid(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { BookError.Title.Wrong },
            )
            authorValidator.validatorFor(book.author)
        }

        LordOfTheRingsBook.validateWith(bookValidator).assertRight()
    }

    @Test
    fun given__a_validator_with_nested_validators_via_validatedBy_using_valid_api_and_a_book__when__validates__then__is_valid() {
        val authorValidator: Validator<BookError.Author, Author> by Validator { author ->
            valid(
                predicate = { author.name == "Tolkien" },
                otherwise = { BookError.Author.Name.Wrong },
            )
        }

        val bookValidator: Validator<BookError, Book> by Validator { book ->
            valid(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { BookError.Title.Wrong },
            )
            book.author validatedBy authorValidator
        }

        LordOfTheRingsBook.validateWith(bookValidator).assertRight()
    }

    @Test
    fun given__a_validator_with_nested_validators_using_valid_api_and_a_book__when__validates__then__is_invalid() {
        val authorValidator: Validator<BookError.Author, Author> by Validator { author ->
            valid(
                predicate = { author.name == "Tolkien" },
                otherwise = { BookError.Author.Name.Wrong },
            )
        }

        val bookValidator: Validator<BookError, Book> by Validator { book ->
            valid(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { BookError.Title.Wrong },
            )
            validator(authorValidator, book.author)
        }

        HarryPotterBook.validateWith(bookValidator)
            .assertLeft(BookError.Title.Wrong, BookError.Author.Name.Wrong)
    }

    @Test
    fun given__a_validator_with_nested_validators_via_validatorFor_using_valid_api_and_a_book__when__validates__then__is_invalid() {
        val authorValidator: Validator<BookError.Author, Author> by Validator { author ->
            valid(
                predicate = { author.name == "Tolkien" },
                otherwise = { BookError.Author.Name.Wrong },
            )
        }

        val bookValidator: Validator<BookError, Book> by Validator { book ->
            valid(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { BookError.Title.Wrong },
            )
            authorValidator validatorFor book.author
        }

        HarryPotterBook.validateWith(bookValidator)
            .assertLeft(BookError.Title.Wrong, BookError.Author.Name.Wrong)
    }

    @Test
    fun given__a_validator_with_nested_validators_via_validatedBy_using_valid_api_and_a_book__when__validates__then__is_invalid() {
        val authorValidator: Validator<BookError.Author, Author> by Validator { author ->
            valid(
                predicate = { author.name == "Tolkien" },
                otherwise = { BookError.Author.Name.Wrong },
            )
        }

        val bookValidator: Validator<BookError, Book> by Validator { book ->
            valid(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { BookError.Title.Wrong },
            )
            book.author validatedBy authorValidator
        }

        HarryPotterBook.validateWith(bookValidator)
            .assertLeft(BookError.Title.Wrong, BookError.Author.Name.Wrong)
    }
}
