package exercise_2

class ReservationService {
    fun buyTicket(
        screening: Screening,
        seatNumber: Int,
        price: Double,
        paymentMethod: PaymentMethod
    ): Ticket? {
        val seat = screening.seats.find { it.number == seatNumber }
            ?: throw IllegalArgumentException("The seat does not exist!")

        if (seat.isReserved) {
            println("The seat is already taken!")
            return null
        }

        println("Selected method: ${paymentMethod.getName()}")

        if (!paymentMethod.pay(price)) {
            println("The payment method failed!")
            return null
        }

        seat.reserve()
        return Ticket(screening.movie.title, seat.number, price)
    }
}