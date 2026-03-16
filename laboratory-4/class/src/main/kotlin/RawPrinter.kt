class RawPrinter : LibraryPrinter {

    override fun print(books: List<Book>) {

        for (book in books) {
            println("${book.title} - ${book.author} - ${book.price} RON")
        }

    }
}