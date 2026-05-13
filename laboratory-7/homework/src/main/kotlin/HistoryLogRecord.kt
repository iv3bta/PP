data class HistoryLogRecord(
    val timestamp: Long,
    val commandLine: String
) : Comparable<HistoryLogRecord> {

    override fun compareTo(other: HistoryLogRecord): Int {
        return this.timestamp.compareTo(other.timestamp)
    }

    override fun toString(): String {
        return "HistoryLogRecord(timestamp=$timestamp, commandLine='$commandLine')"
    }
}f