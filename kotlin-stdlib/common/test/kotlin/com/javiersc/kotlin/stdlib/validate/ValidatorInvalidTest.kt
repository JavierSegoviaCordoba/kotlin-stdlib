package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._fixtures.LordOfTheRingsBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorInvalidTest {

    @Test
    fun given__a_validator_using_invalid_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<String, Book> by Validator { book ->
            invalid(
                predicate = { book.title != "Lord of the Rings" },
                otherwise = { "Title must be Lord of the Rings" },
            )
            invalid(
                predicate = { book.author.name != "Tolkien" },
                otherwise = { "Author must be Tolkien" },
            )
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalid_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<String, Book> by Validator { book ->
            invalid(
                predicate = { book.title != "Lord of the Rings" },
                otherwise = { "Title must be Lord of the Rings" },
            )
            invalid(
                predicate = { book.author.name != "Tolkien" },
                otherwise = { "Author must be Tolkien" },
            )
        }
        HarryPotterBook.validateWith(validator)
            .assertLeft("Title must be Lord of the Rings", "Author must be Tolkien")
    }

    @Test
    fun given__a_validator_using_invalid_api_with_invoke_lambda_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<String, Book> by Validator { book ->
            book {
                invalid(
                    predicate = { title != "Lord of the Rings" },
                    otherwise = { "Title must be Lord of the Rings" },
                )
                author {
                    invalid(
                        predicate = { name != "Tolkien" },
                        otherwise = { "Author must be Tolkien" },
                    )
                }
            }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_invalid_api_with_invoke_lambda_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<String, Book> by Validator { book ->
            book {
                invalid(
                    predicate = { title != "Lord of the Rings" },
                    otherwise = { "Title must be Lord of the Rings" },
                )
                author {
                    invalid(
                        predicate = { name != "Tolkien" },
                        otherwise = { "Author must be Tolkien" },
                    )
                }
            }
        }
        HarryPotterBook.validateWith(validator)
            .assertLeft("Title must be Lord of the Rings", "Author must be Tolkien")
    }
}
