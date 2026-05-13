import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun main() {
    val inputStream = object {}.javaClass.classLoader.getResourceAsStream("history")

    if (inputStream == null) {
        println("Fișierul nu există în resources.")
        return
    }

    val content = inputStream.bufferedReader().use { it.readText() }

    val entries = content
        .split(Regex("\\r?\\n\\s*\\r?\\n"))
        .map { it.trim() }
        .filter { it.isNotEmpty() }

    val last50Entries = entries.takeLast(50)

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    val historyMap: HashMap<Long, HistoryLogRecord> = HashMap()

    for (entry in last50Entries) {
        val lines = entry.lines()

        var startDate: String? = null
        var commandLine: String? = null

        for (line in lines) {
            when {
                line.startsWith("Start-Date:") -> {
                    startDate = line.removePrefix("Start-Date:").trim()
                }
                line.startsWith("Commandline:") -> {
                    commandLine = line.removePrefix("Commandline:").trim()
                }
            }
        }

        if (startDate != null && commandLine != null) {
            val normalizedDate = startDate.replace(Regex("\\s+"), " ")
            val localDateTime = LocalDateTime.parse(normalizedDate, formatter)
            val timestamp = localDateTime
                .atZone(ZoneId.systemDefault())
                .toEpochSecond()

            val record = HistoryLogRecord(timestamp, commandLine)
            historyMap[timestamp] = record
        }
    }

    println("Conținutul HashMap-ului:")
    for ((timestamp, record) in historyMap) {
        println("$timestamp -> $record")
    }

    println("\nÎnregistrări sortate după timestamp:")
    val sortedRecords = historyMap.values.sorted()
    for (record in sortedRecords) {
        println(record)
    }
}