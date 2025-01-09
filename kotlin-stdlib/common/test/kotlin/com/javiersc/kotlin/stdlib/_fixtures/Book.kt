package com.javiersc.kotlin.stdlib._fixtures

data class Book(val title: String, val author: Author, val edition: String = "1") {

    enum class Error {
        EmptyTitle,
        EmptyAuthor,
        BlankTitle,
        BlankAuthor,
        WrongTitle,
        WrongAuthor,
    }

    data class Author(val name: String) {

        enum class Error {
            EmptyName,
            BlankName,
            WrongName,
        }
    }
}

sealed interface BookError {

    enum class Title : BookError {
        Empty,
        Blank,
        Wrong,
    }

    sealed interface Author : BookError {
        enum class Name : Author {
            Empty,
            Blank,
            Wrong,
        }
    }
}

val EmptyBook = Book(title = "", author = Book.Author(""))

val BlankBook = Book(title = "   ", author = Book.Author("   "))

val HarryPotterBook = Book(title = "Harry Potter", author = Book.Author("JK Rowling"))

val LordOfTheRingsBook = Book(title = "Lord of the Rings", author = Book.Author("Tolkien"))
