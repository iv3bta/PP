package second.prototype

data class GenericRequest(
    var url: String,
    var params: MutableMap<String, String> = mutableMapOf()
) : CloneableRequest {

    override fun clone(): GenericRequest {
        return GenericRequest(url, params.toMutableMap())
    }
}