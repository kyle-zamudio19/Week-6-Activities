package com.example.week6activities.week6

data class Borrower(
    val libraryCardNumber: String,
    override val name: String,
    override val phone: String
) : Person