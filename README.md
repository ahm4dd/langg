# Langg (Simple Dictionary)

Langg is a dictionary simulation (built with Java) designed to demonstrate Data Structures and Algorithms (DSA) concepts (Taught at TIU). 

This project stores words in both a `HashMap` and a `TreeSet` for comparison.

## Project Structure

The project consists of three specific Java files:

1.  **`WordEntry.java`** - The Object Model. 
    *   Implements `Comparable` (for sorting in Sets).
    *   Implements `hashCode` & `equals` (for collision handling in Maps).
    *   Stores word, definition, category, and timestamp.
2.  **`VaultManager.java`** - The Logic Controller.
    *   Manages the `HashMap`.
    *   Manages the `TreeSet`.
    *   Ensures data consistency between both structures.
3.  **`LangApp.java`** - The User Interface.
    *   Console-based menu system.
    *   Includes **Simple Performance Benchmarking** to measure search time in nanoseconds.

## How to Run

1.  **Compile the code:**
    Open your terminal/command prompt in the project folder and run:
    ```bash
    javac *.java
    ```

2.  **Run the application:**
    ```bash
    java LingoVaultApp
    ```
---
*Created for the DSA Course at TIU [2025]*
