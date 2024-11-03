package com.javiersc.kotlin.stdlib.validate

import com.javiersc.kotlin.stdlib._fixtures.Book
import com.javiersc.kotlin.stdlib._fixtures.HarryPotterBook
import com.javiersc.kotlin.stdlib._fixtures.LordOfTheRingsBook
import com.javiersc.kotlin.stdlib._utils.assertLeft
import com.javiersc.kotlin.stdlib._utils.assertRight
import kotlin.test.Test

class ValidatorValidTest {

    @Test
    fun given__a_validator_using_valid_api_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by
            Validator.invoke(name = "Book") { book ->
                valid(
                    predicate = { book.title == "Lord of the Rings" },
                    otherwise = { "Title must be Lord of the Rings" },
                )
                valid(
                    predicate = { book.author.name == "Tolkien" },
                    otherwise = { "Author must be Tolkien" },
                )
            }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_valid_api_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book ->
            valid(
                predicate = { book.title == "Lord of the Rings" },
                otherwise = { "Title must be Lord of the Rings" },
            )
            valid(
                predicate = { book.author.name == "Tolkien" },
                otherwise = { "Author must be Tolkien" },
            )
        }
        HarryPotterBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Title must be Lord of the Rings
                |    - Author must be Tolkien
            """
        }
    }

    @Test
    fun given__a_validator_using_valid_api_with_invoke_lambda_and_a_book__when__validates__then__is_valid() {
        val validator: Validator<Book> by Validator { book ->
            book {
                valid(
                    predicate = { title == "Lord of the Rings" },
                    otherwise = { "Title must be Lord of the Rings" },
                )
                author {
                    valid(
                        predicate = { name == "Tolkien" },
                        otherwise = { "Author must be Tolkien" },
                    )
                }
            }
        }
        LordOfTheRingsBook.validateWith(validator).assertRight()
    }

    @Test
    fun given__a_validator_using_valid_api_with_invoke_lambda_and_a_book__when__validates__then__is_invalid() {
        val validator: Validator<Book> by Validator { book ->
            book {
                valid(
                    predicate = { title == "Lord of the Rings" },
                    otherwise = { "Title must be Lord of the Rings" },
                )
                author {
                    valid(
                        predicate = { name == "Tolkien" },
                        otherwise = { "Author must be Tolkien" },
                    )
                }
            }
        }
        HarryPotterBook.validateWith(validator).assertLeft {
            """
                |'Book' is invalid due to:
                |    - Title must be Lord of the Rings
                |    - Author must be Tolkien
            """
        }
    }
}
