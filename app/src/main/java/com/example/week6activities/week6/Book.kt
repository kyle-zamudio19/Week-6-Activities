package com.example.week6activities.week6

data class Book(
    val title: String,
    val author: String,
    val publicationDate: Int?,
    var status: BookStatus? = BookStatus.AVAILABLE
)