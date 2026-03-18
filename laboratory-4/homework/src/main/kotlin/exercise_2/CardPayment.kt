package exercise_2

class CardPayment(
    private val cardNumber: String,
    private val balance: Double
) : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        return balance >= amount
    }

    override fun getName(): String {
        return "Card"
    }
}