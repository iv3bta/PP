package exercise_2

interface PaymentMethod {
    fun pay(amount: Double): Boolean
    fun getName(): String
}