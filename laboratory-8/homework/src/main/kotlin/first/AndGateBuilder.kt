package first.builder

import first.bridge.AndGate
import first.bridge.AndLogicImplementor

class AndGateBuilder(private val expectedInputs: Int) {
    private val inputs = mutableListOf<Boolean>()

    fun addInput(value: Boolean): AndGateBuilder {
        if (inputs.size >= expectedInputs) {
            throw IllegalStateException("Ai adăugat prea multe intrări. Poarta acceptă doar $expectedInputs intrări.")
        }
        inputs.add(value)
        return this
    }

    fun build(): AndGate {
        if (inputs.size != expectedInputs) {
            throw IllegalStateException("Poarta AND trebuie să aibă exact $expectedInputs intrări.")
        }
        return AndGate(AndLogicImplementor(), inputs.toList())
    }
}