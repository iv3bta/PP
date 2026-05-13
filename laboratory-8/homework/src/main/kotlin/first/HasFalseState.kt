package first.state

class HasFalseState : AndState {
    override fun handle(input: Boolean): AndState = this
    override fun output(): Boolean = false
}