import java.util.HashMap;
import java.util.TreeSet;

public class VaultManager {
    private HashMap<String, WordEntry> fastMap;
    private TreeSet<WordEntry> sortedSet;

    public VaultManager() {
        fastMap = new HashMap<>();
        sortedSet = new TreeSet<>();
        
        // Adding random data
        addWord("array", "A collection of items stored at contiguous memory locations", "DSA");
        addWord("stack", "A linear data structure following LIFO order", "DSA");
        addWord("queue", "A linear structure following FIFO order", "DSA");
    }

    public boolean addWord(String word, String definition, String category) {
        String key = word.toLowerCase().trim();
        
        // Check duplication
        if (fastMap.containsKey(key)) {
            return false;
        }

        WordEntry entry = new WordEntry(key, definition, category);
        
        // Adding for both (map and set)
        fastMap.put(key, entry);
        sortedSet.add(entry);
        
        return true;
    }

    public boolean removeWord(String word) {
        String key = word.toLowerCase().trim();
        
        if (fastMap.containsKey(key)) {
            // Remove from both (map and set)
            WordEntry removed = fastMap.remove(key);
            sortedSet.remove(removed); 
            return true;
        }
        return false;
    }

    public WordEntry searchViaMap(String word) {
        return fastMap.get(word.toLowerCase().trim());
    }

    public WordEntry searchViaSet(String word) {
        if (word == null || word.isEmpty()) return null;
        
        // We need a dummy object to compare against inside the Set
        WordEntry searchKey = new WordEntry(word);
        
        // Use 'ceiling' to perform O(log n) binary search in the tree
        WordEntry result = sortedSet.ceiling(searchKey);
        
        // Confirm exact match (ceiling returns the next closest if exact not found)
        if (result != null && result.getWord().equalsIgnoreCase(word)) {
            return result;
        }
        return null;
    }

    public void displaySorted() {
        if (sortedSet.isEmpty()) {
            System.out.println("   (Empty)");
            return;
        }
        // TreeSet iteration is always sorted
        for (WordEntry w : sortedSet) {
            System.out.println("   " + w);
        }
    }
}