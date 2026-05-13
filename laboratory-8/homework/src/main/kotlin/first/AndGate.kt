package first.bridge

class AndGate(
    implementor: LogicImplementor,
    inputs: List<Boolean>
) : LogicGate(implementor, inputs) {

    override fun evaluate(): Boolean {
        return implementor.compute(inputs)
    }
}