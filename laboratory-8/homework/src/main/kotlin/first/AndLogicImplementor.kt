package first.bridge

import first.state.AndStateMachine

class AndLogicImplementor : LogicImplementor {
    private val machine = AndStateMachine()

    override fun compute(inputs: List<Boolean>): Boolean {
        return machine.process(inputs)
    }
}