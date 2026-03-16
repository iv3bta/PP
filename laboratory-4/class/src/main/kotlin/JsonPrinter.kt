class JsonPrinter : LibraryPrinter {

    override fun print(books: List<Book>) {

        println("[")

        for (book in books) {
            println("""{"title":"${book.title}","author":"${book.author}","price":${book.price}}""")
        }

        println("]")
    }
}