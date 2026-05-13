package first.state

class AndStateMachine {
    private var currentState: AndState = AllTrueState()

    fun process(inputs: List<Boolean>): Boolean {
        currentState = AllTrueState()

        for (value in inputs) {
            currentState = currentState.handle(value)
        }

        return currentState.output()
    }
}