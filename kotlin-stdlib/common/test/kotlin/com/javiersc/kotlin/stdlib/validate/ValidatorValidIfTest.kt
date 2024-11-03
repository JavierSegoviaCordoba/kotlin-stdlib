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
        val validator: Validator<Book> by Validator { book ->
            validIf { book.title == "Lord of the Rings" }
            validIf { book.author.name == "Tolkien" }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_validIf_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book ->
            validIf { book.title == "Lord of the Rings" }
            validIf { book.author.name == "Tolkien" }
        }
        HarryPotterBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Multiple invalid properties
            """
        }
    }

    @Test
    fun given__a_validator_using_validIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            book {
                validIf { title == "Lord of the Rings" }
                author { //
                    validIf { name == "Tolkien" }
                }
            }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_validIf_api_with_invoke_lambda_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book ->
            book {
                validIf { title == "Lord of the Rings" }
                author { //
                    validIf { name == "Tolkien" }
                }
            }
        }
        HarryPotterBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Multiple invalid properties
            """
        }
    }
}
