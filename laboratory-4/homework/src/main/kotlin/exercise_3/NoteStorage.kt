package exercise_3

interface NoteStorage {

    fun save(note: Note)

    fun load(id: String): Note?

    fun delete(id: String): Boolean

    fun list(): List<String>
}