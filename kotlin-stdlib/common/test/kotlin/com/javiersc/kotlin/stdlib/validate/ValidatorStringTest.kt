package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.EmptyBook
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorStringTest {

    @Test
    fun given__a_validator_using_invalidIfIsEmpty_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            book.title.invalidIfIsEmpty { "Title is empty" }
        }
        HarryPotterBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalidIfIsEmpty_withoutOtherwise_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book -> book.title.invalidIfIsEmpty() }
        EmptyBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Empty property
            """
        }
    }

    @Test
    fun given__a_validator_using_invalidIfIsEmpty_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book ->
            book.title.invalidIfIsEmpty { "Title is empty" }
        }
        EmptyBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Title is empty
            """
        }
    }
}
