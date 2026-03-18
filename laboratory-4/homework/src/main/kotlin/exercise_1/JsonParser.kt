package exercise_1

class JsonParser : Parser {
    override fun supports(contentType: String): Boolean {
        return contentType.equals("json", ignoreCase = true)
    }

    override fun parse(text: String): Map<String, Any> {
        return mapOf("type" to "JSON", "content" to text)
    }
}