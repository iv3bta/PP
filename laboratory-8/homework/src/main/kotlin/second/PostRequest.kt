package second.facade

import second.prototype.GenericRequest
import khttp.post

class PostRequest(
    private val genericReq: GenericRequest
) {
    fun postData(): String {
        return try {
            val response = post(
                url = genericReq.url,
                data = genericReq.params
            )
            response.text
        } catch (e: Exception) {
            "Eroare la POST: ${e.message}"
        }
    }
}