package second

import second.prototype.GenericRequest
import second.proxy.GetRequest
import second.proxy.CleanGetRequest
import second.facade.PostRequest
import second.facade.KidsBrowser

fun main() {
    val prototype = GenericRequest(
        url = "https://httpbin.org/get",
        params = mutableMapOf("q" to "kotlin", "safe" to "true")
    )

    val getClone = prototype.clone()
    val getRequest = GetRequest(getClone)
    val cleanGetRequest = CleanGetRequest(getRequest)

    val postClone = prototype.clone()
    postClone.url = "https://httpbin.org/post"
    postClone.params["childMode"] = "enabled"

    val postRequest = PostRequest(postClone)

    val browser = KidsBrowser(cleanGetRequest, postRequest)
    browser.start()

    println("\n--- Test site blocat ---")
    val blockedPrototype = GenericRequest(
        url = "https://www.youtube.com",
        params = mutableMapOf()
    )

    val blockedGet = GetRequest(blockedPrototype.clone())
    val blockedClean = CleanGetRequest(blockedGet)

    println(blockedClean.getResponse())
}