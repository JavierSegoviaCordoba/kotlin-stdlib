package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.EmptyBook
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._fixtures.LordOfTheRingsBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorValidatableListTest {

    @Test
    fun given__a_validator_using_and_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            (book.title and book.author.name) { this.invalidIfIsEmpty() }
        }

        LordOfTheRingsBook.validateWith(validator).assertRight()
        HarryPotterBook.validateWith(validator).assertRight()
        EmptyBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Multiple empty properties
            """
        }
    }

    @Test
    fun given__a_validator_using_and_api_and_andList_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            (book.title and book.author.name and book.edition) { this.invalidIfIsEmpty() }
        }

        LordOfTheRingsBook.validateWith(validator).assertRight()
        HarryPotterBook.validateWith(validator).assertRight()
        EmptyBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Multiple empty properties
            """
        }
    }

    @Test
    fun given__a_validator_using_and_validationOf_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            validationOf(book.title, book.author.name) { this.invalidIfIsEmpty() }
        }

        LordOfTheRingsBook.validateWith(validator).assertRight()
        HarryPotterBook.validateWith(validator).assertRight()
        EmptyBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Multiple empty properties
            """
        }
    }
}
