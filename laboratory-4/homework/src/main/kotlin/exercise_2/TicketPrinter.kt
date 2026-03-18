package exercise_2

class TicketPrinter {
    fun print(ticket: Ticket) {
        println("Movie: ${ticket.movieTitle}")
        println("Seat: ${ticket.seatNumber}")
        println("Price: ${ticket.price} lei")
    }
}