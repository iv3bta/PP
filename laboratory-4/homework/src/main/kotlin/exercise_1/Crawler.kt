package exercise_1

class Crawler(
    private val webClient: WebClient,
    private val parsers: List<Parser>
) {
    fun parseContent(content: String, contentType: String): Any {
        val parser = parsers.find { it.supports(contentType) }
            ?: throw Exception("No parser found for type: $contentType")

        return parser.parse(content)
    }

    fun crawl(url: String, contentType: String): Map<String, Any> {
        val content = webClient.get(url)
        val parser = parsers.find { it.supports(contentType) }
            ?: throw IllegalArgumentException("There is no parser for this type: $contentType")

        return parser.parse(content)
    }
}