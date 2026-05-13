package second.proxy

import second.prototype.GenericRequest
import khttp.get

class GetRequest(
    val genericReq: GenericRequest,
    private val timeout: Double = 5.0
) : HTTPGet {

    override fun getResponse(): String {
        return try {
            val response = get(
                url = genericReq.url,
                params = genericReq.params,
                timeout = timeout
            )
            response.text
        } catch (e: Exception) {
            "Eroare la GET: ${e.message}"
        }
    }
}