package exercise_1

import java.net.URL

class WebClient {
    fun get(url: String): String {
        return URL(url).readText()
    }
}