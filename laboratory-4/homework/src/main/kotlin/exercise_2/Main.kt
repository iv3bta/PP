package exercise_2

fun main() {
    val movie = Movie("Morometii", "Drama", 148)
    val seats = listOf(Seat(1), Seat(2), Seat(3), Seat(4), Seat(5))
    val screening = Screening(movie, "2020-10-10 00:00", seats)

    val service = ReservationService()
    val printer = TicketPrinter()

    println("Movie: ${movie.title}")
    println("Available places: ")
    screening.getAvailableSeats().forEach { println("Seat ${it.number}") }

    print("Choose your seat: ")
    val seatNumber = readln().toInt()

    println("Payment method:")
    println("1. Cash")
    println("2. Card")

    print("Opțiunea ta: ")
    val option = readln().toInt()

    val paymentMethod: PaymentMethod = when (option) {
        1 -> {
            print("Input money: ")
            val amount = readln().toDouble()
            CashPayment(amount)
        }
        2 -> {
            print("Card number: ")
            val cardNumber = readln()
            print("CVC number: ")
            val balance = readln().toDouble()
            CardPayment(cardNumber, balance)
        }
        else -> {
            println("Invalid option!")
            return
        }
    }

    val ticket = service.buyTicket(
        screening = screening,
        seatNumber = seatNumber,
        price = 25.0,
        paymentMethod = paymentMethod
    )

    if (ticket != null) {
        printer.print(ticket)
    } else {
        println("Ticket could not be bought!")
    }
}