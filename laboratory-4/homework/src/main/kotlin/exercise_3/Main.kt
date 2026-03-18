package exercise_3

fun main() {

    val user = User("Ivebta", "rares.iventa@gmail.com")
    val storage = FileNoteStorage("notes")
    val manager = NoteManager(storage)

    while (true) {
        println("1. Show list")
        println("2. View note")
        println("3. Create note")
        println("4. Delete note")
        println("0. Exit")
        print("Choose an option: ")

        when (readln()) {

            "1" -> {
                val notes = manager.listNotes()

                if (notes.isEmpty()) {
                    println("There are no notes.")
                } else {
                    println("Existing notes:")
                    notes.forEach { println("- $it") }
                }
            }

            "2" -> {
                print("Enter note ID: ")
                val id = readln()

                val note = manager.loadNote(id)

                if (note == null) {
                    println("Note could not be found!")
                } else {
                    println("Title: ${note.title}")
                    println("Author: ${note.author.username}")
                    println("Date: ${note.date}")
                    println("Time: ${note.time}")
                    println("Content: ${note.content}")
                }
            }

            "3" -> {
                print("Note title: ")
                val title = readln()

                print("Note content: ")
                val content = readln()

                val note = manager.createNote(title, content, user)
                println("Note created with ID: ${note.id}")
            }

            "4" -> {
                print("Enter ID of the note to delete: ")
                val id = readln()

                if (manager.deleteNote(id)) {
                    println("Note has been deleted.")
                } else {
                    println("Note does not exist.")
                }
            }

            "0" -> {
                break
            }

            else -> println("Invalid option.")
        }
    }
}