package exercise_1

interface Parser {
    fun supports(contentType: String): Boolean
    fun parse(text: String): Map<String, Any>
}