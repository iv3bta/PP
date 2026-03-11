fun main() {

    val library = Library()

    library.addBook(Book("Ion", "Liviu Rebreanu", 50.0))
    library.addBook(Book("Morometii", "Marin Preda", 40.0))

    val printer: LibraryPrinter = RawPrinter()

    printer.print(library.getBooks())
}