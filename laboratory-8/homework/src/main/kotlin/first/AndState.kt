package first.state

interface AndState {
    fun handle(input: Boolean): AndState
    fun output(): Boolean
}