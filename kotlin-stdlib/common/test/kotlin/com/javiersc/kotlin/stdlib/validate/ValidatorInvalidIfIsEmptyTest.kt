package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.BlankBook
import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.EmptyBook
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorInvalidIfIsEmptyTest {

    @Test
    fun given__a_validator_using_invalidIfIsEmpty_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            book.title.invalidIfIsEmpty { Book.Error.EmptyTitle }
            book.author.name.invalidIfIsEmpty { Book.Error.EmptyAuthor }
        }
        HarryPotterBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalidIfIsEmpty_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book.Error, Book> by Validator { book ->
            book.title.invalidIfIsEmpty { Book.Error.EmptyTitle }
            book.author.name.invalidIfIsEmpty { Book.Error.EmptyAuthor }
        }
        EmptyBook.validateWith(validator).assertLeft(Book.Error.EmptyTitle, Book.Error.EmptyAuthor)
        BlankBook.validateWith(validator).assertRight()
    }
}
