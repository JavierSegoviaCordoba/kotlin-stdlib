package com.javiersc.kotlin.stdlib._fixtures

data class Book(val title: String, val author: Author, val edition: String = "1") {

    data class Author(val name: String)
}

val EmptyBook = Book(title = "", author = Book.Author(""))

val HarryPotterBook = Book(title = "Harry Potter", author = Book.Author("JK Rowling"))

val LordOfTheRingsBook = Book(title = "Lord of the Rings", author = Book.Author("Tolkien"))
