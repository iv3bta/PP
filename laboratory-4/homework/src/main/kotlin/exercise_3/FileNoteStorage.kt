package exercise_3

import java.io.File

class FileNoteStorage(private val folderPath: String) : NoteStorage {

    init {
        File(folderPath).mkdirs() // create folder if it doesn't exist
    }

    override fun save(note: Note) {
        val file = File("$folderPath/${note.id}.txt")

        file.writeText(
            """
            title=${note.title}
            author=${note.author.username}
            email=${note.author.email}
            date=${note.date}
            time=${note.time}
            content=${note.content}
            """.trimIndent()
        )
    }

    override fun load(id: String): Note? {
        val file = File("$folderPath/$id.txt")

        if (!file.exists()) return null

        val lines = file.readLines()

        val map = lines.associate {
            val parts = it.split("=", limit = 2)
            parts[0] to parts[1]
        }

        val user = User(
            username = map["author"] ?: "unknown",
            email = map["email"] ?: "unknown"
        )

        return Note(
            id = id,
            title = map["title"] ?: "",
            content = map["content"] ?: "",
            author = user,
            date = map["date"] ?: "",
            time = map["time"] ?: ""
        )
    }

    override fun delete(id: String): Boolean {
        val file = File("$folderPath/$id.txt")
        return file.exists() && file.delete()
    }

    override fun list(): List<String> {
        val folder = File(folderPath)

        return folder.listFiles()
            ?.filter { it.isFile && it.extension == "txt" }
            ?.map { it.nameWithoutExtension }
            ?: emptyList()
    }
}