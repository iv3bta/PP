package exercise_1

class XmlParser : Parser {
    override fun supports(contentType: String): Boolean {
        return contentType.equals("xml", ignoreCase = true)
    }

    override fun parse(text: String): Map<String, Any> {
        return mapOf("type" to "XML", "content" to text)
    }
}