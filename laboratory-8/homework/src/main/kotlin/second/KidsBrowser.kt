package second.facade

import second.proxy.CleanGetRequest

class KidsBrowser(
    private val cleanGet: CleanGetRequest?,
    private val postReq: PostRequest?
) {

    fun openSafePage() {
        if (cleanGet == null) {
            println("Nu exista request GET configurat.")
            return
        }

        val result = cleanGet.getResponse()
        println("Raspuns GET:")
        println(result.take(500))
    }

    fun sendData() {
        if (postReq == null) {
            println("Nu exista request POST configurat.")
            return
        }

        val result = postReq.postData()
        println("Raspuns POST:")
        println(result.take(500))
    }

    fun start() {
        println("KidsBrowser pornit.")
        openSafePage()
        sendData()
    }
}