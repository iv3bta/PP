class HtmlPrinter : LibraryPrinter {

    override fun print(books: List<Book>) {

        println("<html>")

        for (book in books) {
            println("<p>${book.title} - ${book.author} - ${book.price} RON</p>")
        }

        println("</html>")
    }
}