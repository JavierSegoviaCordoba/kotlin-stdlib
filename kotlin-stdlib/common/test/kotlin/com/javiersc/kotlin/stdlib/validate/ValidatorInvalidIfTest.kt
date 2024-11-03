package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._fixtures.LordOfTheRingsBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorIninvalidIfTest {

    @Test
    fun given__a_validator_using_invalidIf_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            invalidIf { book.title != "Lord of the Rings" }
            invalidIf { book.author.name != "Tolkien" }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalidIf_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book ->
            invalidIf { book.title != "Lord of the Rings" }
            invalidIf { book.author.name == "Tolkien" }
        }
        HarryPotterBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Invalid property
            """
        }
    }

    @Test
    fun given__a_validator_using_invalidIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            book {
                invalidIf { title != "Lord of the Rings" }
                author { //
                    invalidIf { name != "Tolkien" }
                }
            }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalidIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book ->
            book {
                invalidIf { title != "Lord of the Rings" }
                author { //
                    invalidIf { name == "Tolkien" }
                }
            }
        }
        HarryPotterBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Invalid property
            """
        }
    }
}
