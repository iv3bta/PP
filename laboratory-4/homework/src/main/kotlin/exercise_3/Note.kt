package exercise_3

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val author: User,
    val date: String,
    val time: String
)