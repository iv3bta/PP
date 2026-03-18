package exercise_3

import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class NoteManager(private val storage: NoteStorage) {

    fun createNote(title: String, content: String, author: User): Note {

        val note = Note(
            id = UUID.randomUUID().toString(),
            title = title,
            content = content,
            author = author,
            date = LocalDate.now().toString(),
            time = LocalTime.now().withNano(0).toString()
        )

        storage.save(note)
        return note
    }

    fun loadNote(id: String): Note? {
        return storage.load(id)
    }

    fun deleteNote(id: String): Boolean {
        return storage.delete(id)
    }

    fun listNotes(): List<String> {
        return storage.list()
    }
}