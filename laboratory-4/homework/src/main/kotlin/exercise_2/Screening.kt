package exercise_2

class Screening(
    val movie: Movie,
    val dateTime: String,
    val seats: List<Seat>
) {
    fun getAvailableSeats(): List<Seat> {
        return seats.filter { !it.isReserved }
    }
}