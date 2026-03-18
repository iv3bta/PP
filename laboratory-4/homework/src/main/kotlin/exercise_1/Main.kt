package exercise_1

fun main() {
    val webClient = WebClient()
    val parsers = listOf(
        JsonParser(),
        XmlParser(),
        YamlParser()
    )

    val crawler = Crawler(webClient, parsers)

    val fakeJson = """
        {
          "userId": 17,
          "id": 1520,
          "title": "Random",
          "completed": true
        }
    """.trimIndent()

    try {
        val result = crawler.parseContent(
            content = fakeJson,
            contentType = "json"
        )
        println(result)
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}