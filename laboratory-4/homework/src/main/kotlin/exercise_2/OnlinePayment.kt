package exercise_2

class OnlinePayment(
    private val email: String,
    private val balance: Double
) : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        return balance >= amount
    }

    override fun getName(): String {
        return "Online"
    }
}