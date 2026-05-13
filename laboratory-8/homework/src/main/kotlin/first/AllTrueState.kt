package first.state

class AllTrueState : AndState {
    override fun handle(input: Boolean): AndState {
        return if (input) this else HasFalseState()
    }

    override fun output(): Boolean = true
}