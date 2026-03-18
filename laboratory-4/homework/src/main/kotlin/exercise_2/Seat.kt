package exercise_2

class Seat(val number: Int) {
    var isReserved: Boolean = false
        private set

    fun reserve() {
        if (isReserved) {
            throw IllegalStateException("The seat is reserved!")
        }
        isReserved = true
    }
}