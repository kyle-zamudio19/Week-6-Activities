package com.example.week6activities.week6

data class Loan(
    val book: Book,
    val borrower: Borrower,
    val dueDate: String,
    val returnDate: String
)