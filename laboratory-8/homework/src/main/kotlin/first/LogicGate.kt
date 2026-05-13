package first.bridge

abstract class LogicGate(
    protected val implementor: LogicImplementor,
    protected val inputs: List<Boolean>
) {
    abstract fun evaluate(): Boolean
}