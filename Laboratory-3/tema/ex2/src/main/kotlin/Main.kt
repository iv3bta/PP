import java.io.File

fun removeMultipleSpaces(text: String): String {
    return text.replace(Regex("[ ]{2,}"), " ")
}

fun removeMultipleEmptyLines(text: String): String {
    return text.replace(Regex("(\\n\\s*){2,}"), "\n\n")
}

fun removePageNumbers(text: String): String {

    val lines = text.lines()

    val cleanedLines = lines.filterNot { line ->
        val trimmed = line.trim()
        trimmed.matches(Regex("\\d+"))
    }

    return cleanedLines.joinToString("\n")
}

fun replaceOldDiacritics(text: String): String {

    return text
        .replace("ş", "ș")
        .replace("ţ", "ț")
        .replace("Ş", "Ș")
        .replace("Ţ", "Ț")
}

fun processEbook(text: String): String {

    var result = text

    result = removePageNumbers(result)
    result = removeMultipleSpaces(result)
    result = removeMultipleEmptyLines(result)
    result = replaceOldDiacritics(result)

    return result
}

fun main() {

    val inputFile = File("ebook.txt")

    if (!inputFile.exists()) {
        println("Fisierul ebook.txt nu exista.")
        return
    }

    val text = inputFile.readText()

    val processed = processEbook(text)

    File("ebook_curatat.txt").writeText(processed)

    println("Procesare terminata.")
}