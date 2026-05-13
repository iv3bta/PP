package second.proxy

class CleanGetRequest(
    private val getRequest: GetRequest
) : HTTPGet {

    private val parentalControlDisallowList = listOf(
        "facebook.com",
        "instagram.com",
        "tiktok.com",
        "youtube.com",
        "pornhub.com",
        "xvideos.com"
    )

    override fun getResponse(): String {
        val url = getRequest.genericReq.url.lowercase()

        for (blocked in parentalControlDisallowList) {
            if (url.contains(blocked)) {
                return "Acces blocat de controlul parental pentru site-ul: $blocked"
            }
        }

        return getRequest.getResponse()
    }
}