package com.example.week6activities.week6

fun main() {
    val library = Library()
    val libraryLoan = LibraryLoan()
    while (true) {
        displayMainMenu()

        when (readMainMenuOption()) {
            MainMenuOption.ADDBOOK -> {
                val book = readBookInfo()
                library.addBook(book)
                println("Book added successfully. :)")
            }

            MainMenuOption.REMOVEBOOK -> {
                println("Enter book title you want to remove:")
                val title = readln()
                val removeBook = library.listOfBook.find { it.title.contains(title,ignoreCase = true) }
                if (removeBook != null) {
                    library.listOfBook.remove(removeBook)
                    println("book removed successfully!")
                }
                else {
                    println("there's no such book!")
                }
            }

            MainMenuOption.DISPLAYBOOKS -> {
                library.displayAllBooks()
            }

            MainMenuOption.CREATELOAN -> {
                while (true) {
                    if (library.listOfBook.isEmpty()) {
                        println("please add a book first!")
                        break
                    }
                    else {
                        val book: Book = readBookInfo()
                        val borrower = readBorrowerInfo()
                        print("Enter the due date (MM-DD-YYYY): ")
                        val dueDate = readLine().toString()
                        if (dueDate.length != 8){
                            println("Please enter a valid date!")
                            break
                        }
                        library.createLoan(book, borrower, dueDate)
                        println("Loan created successfully. :)")
                        break
                    }
                }
            }

            MainMenuOption.DISPLAYLOANS -> {
                if (library.loans.isEmpty() && libraryLoan.loans.isEmpty()) {
                    println("NO LOANS!")
                } else {
                    library.displayAllLoans()
                }
            }

            MainMenuOption.EXIT -> {
                println("PROGRAM TERMINATED")
                return
            }
        }
    }
}

fun displayMainMenu() {
    println("\nMAIN MENU")
    println("1. Add a book")
    println("2. Remove a book")
    println("3. Display all books")
    println("4. Create a loan")
    println("5. Display all loans")
    println("6. Exit program")
}

fun readMainMenuOption(): MainMenuOption {
    print("Enter option: ")
    return when (readlnOrNull()?.toIntOrNull()) {
        1 -> MainMenuOption.ADDBOOK
        2 -> MainMenuOption.REMOVEBOOK
        3 -> MainMenuOption.DISPLAYBOOKS
        4 -> MainMenuOption.CREATELOAN
        5 -> MainMenuOption.DISPLAYLOANS
        6 -> MainMenuOption.EXIT
        else -> {
            println("Invalid option!, please try again.")
            readMainMenuOption()
        }
    }
}

fun readBookInfo(): Book {
    while (true) {
        print("Enter the book title: ")
        val title = readln()
        print("Enter the book author: ")
        val author = readln()
        print("Enter the book publication year: ")
        val publicationDate = readLine()!!.toIntOrNull()
        if (publicationDate == null || publicationDate.toString().length != 4) {
            println("please enter a valid date!")
            continue
        }
        return (Book(title, author, publicationDate, BookStatus.AVAILABLE))
    }
}

fun readBorrowerInfo(): Borrower {
    print("Enter the borrower name: ")
    val name = readln()
    while (true) {
        print("Enter the borrower phone number: ")
        val phone: String? = readLine()
        if (phone != null) {
            if (phone.length != 11) {
                println("Invalid phone number!")
                continue
            }
            else {
                print("Enter the borrower library card number: ")
                val libraryCardNumber = readln()
                return Borrower(libraryCardNumber, name, phone)
            }
        }
    }
}