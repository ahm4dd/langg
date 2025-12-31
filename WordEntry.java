import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class WordEntry implements Comparable<WordEntry> {
    private String word;
    private String definition;
    private String category;
    private String timestamp;

    public WordEntry(String word, String definition, String category) {
        this.word = word.toLowerCase().trim(); 
        this.definition = definition;
        this.category = category;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public WordEntry(String word) {
        this.word = word.toLowerCase().trim();
    }

    public String getWord() { return word; }

    @Override
    public String toString() {
        return String.format("%-15s | [%s] %s (Added: %s)", 
            word.toUpperCase(), category, definition, timestamp);
    }

    // --- REQUIRED FOR SET (Sorting & Binary Search) ---
    @Override
    public int compareTo(WordEntry other) {
        return this.word.compareToIgnoreCase(other.word);
    }

    // --- REQUIRED FOR HASHMAP (Key Hashing) ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordEntry wordEntry = (WordEntry) o;
        return Objects.equals(word, wordEntry.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}