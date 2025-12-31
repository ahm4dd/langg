import java.util.Scanner;

public class LingoVaultApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VaultManager vault = new VaultManager();

    public static void main(String[] args) {
        System.out.println("=== LINGO VAULT HYBRID SYSTEM ===");
        boolean running = true;

        while (running) {
            System.out.println("\n-------------------------------------------");
            System.out.println(" 1. Search (Hash Map Strategy) - O(1)");
            System.out.println(" 2. Search (Tree Set Strategy) - O(log n)");
            System.out.println(" 3. Add Word (Updates Both)");
            System.out.println(" 4. Remove Word (Updates Both)");
            System.out.println(" 5. Show All (Sorted)");
            System.out.println(" 6. Exit");
            System.out.print(">> Select: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    doSearch(true); // true = use map
                    break;
                case "2":
                    doSearch(false); // false = use set
                    break;
                case "3":
                    doAdd();
                    break;
                case "4":
                    doRemove();
                    break;
                case "5":
                    vault.displaySorted();
                    break;
                case "6":
                    running = false;
                    System.out.println("Terminating...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void doSearch(boolean useMap) {
        System.out.print("Enter word to find: ");
        String term = scanner.nextLine();
        long startTime = System.nanoTime(); // For measuring efficiency

        WordEntry result;
        if (useMap) {
            result = vault.searchViaMap(term);
        } else {
            result = vault.searchViaSet(term);
        }
        
        long endTime = System.nanoTime();

        if (result != null) {
            System.out.println("\n FOUND:");
            System.out.println(" " + result);
            System.out.println(" [Technique: " + (useMap ? "HashMap" : "TreeSet") + "]");
            System.out.println(" [Time taken: " + (endTime - startTime) + " ns]");
        } else {
            System.out.println("\n [X] Word not found.");
        }
    }

    private static void doAdd() {
        System.out.print("Word: ");
        String w = scanner.nextLine();
        if(w.isEmpty()) return;
        System.out.print("Definition: ");
        String d = scanner.nextLine();
        System.out.print("Category: ");
        String c = scanner.nextLine();

        if (vault.addWord(w, d, c)) {
            System.out.println(" [V] Successfully added to Database.");
        } else {
            System.out.println(" [!] Word already exists.");
        }
    }

    private static void doRemove() {
        System.out.print("Enter word to delete: ");
        if (vault.removeWord(scanner.nextLine())) {
            System.out.println(" [V] Deleted.");
        } else {
            System.out.println(" [!] Word not found.");
        }
    }
}