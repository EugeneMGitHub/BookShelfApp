package com.example.bookshelfapp

val items = listOf(
    Book("Идиот", R.drawable.dostoevski, "Федор Достоевский"),
    Book("Зеленый свет", R.drawable.greenlight, "Мэттью Макконахи"),
    Book("Нейрохакинг", R.drawable.neiro, "Толанд Виллемайер"),
    Book("Код да Винчи", R.drawable.kod, "Дэн Браун"),
)

data class Book(
    val title: String,
    val image: Int,
    val author: String
)

val myBookItems = listOf(
//    MyBook(Book("Just My Type", R.drawable.book_just_my_type, "Simon Garfield"), "15.03.2024", 75f),

    MyBook(items[0], "15.03.2024", 17f),
    MyBook(items[1], "21.02.2024", 55f),
    MyBook(items[3], "17.01.2024", 92f),
)

data class MyBook(
    val book: Book,
    val returnDate: String,
    val timeLeftPercentage: Float
)