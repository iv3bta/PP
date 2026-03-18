package exercise_2

class CashPayment(private val availableAmount: Double) : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        return availableAmount >= amount
    }

    override fun getName(): String {
        return "Cash"
    }
}