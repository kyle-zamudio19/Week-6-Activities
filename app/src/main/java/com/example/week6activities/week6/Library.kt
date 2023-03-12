package com.example.week6activities.week6

class Library {

    val listOfBook = mutableListOf<Book>()
    val loans = LibraryLoan().loans

    fun addBook(book: Book) {
        listOfBook.add(book)
    }

    fun displayAllBooks() {
        println("  BOOKS:  ")
        listOfBook.forEach {
            println("${it.title} written by: ${it.author} (${it.publicationDate}) - ${it.status}")
        }
    }

    fun createLoan(book: Book, borrower: Borrower, dueDate: String) {
        val libraryBook = listOfBook.find { it == book && it.status == BookStatus.AVAILABLE }
        if (libraryBook != null) {
            libraryBook.status = BookStatus.ON_LOAN
            loans.add(Loan(libraryBook, borrower, dueDate, "7 Days"))
        }
        else {
            println("Sorry! The book is ${BookStatus.ON_LOAN}")
        }
    }

    fun displayAllLoans() {
        println("  Loans:  ")
        loans.forEach {
            println("${it.book.title} written by: ${it.book.author} (${it.book.publicationDate})\n")
            println("borrowed by: ${it.borrower.name}\n")
            println("phone: +63(${it.borrower.phone.substring(1..3)})" + " " + it.borrower.phone.substring(4..6) + "-" + it.borrower.phone.substring(7..10))
            println("due on: ${it.dueDate.substring(0..1) + "-" + it.dueDate.substring(2..3) + "-" + it.dueDate.substring(4..7)}")
            println("return on: ${it.returnDate}")
        }
    }
}