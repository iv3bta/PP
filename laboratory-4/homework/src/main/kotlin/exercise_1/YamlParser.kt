package exercise_1

class YamlParser : Parser {
    override fun supports(contentType: String): Boolean {
        return contentType.equals("yaml", ignoreCase = true)
    }

    override fun parse(text: String): Map<String, Any> {
        return mapOf("type" to "YAML", "content" to text)
    }
}