import java.util.ArrayList;
import java.util.List;

// OCP is not violated because InventoryManager is well-structured and allows extension without modification.

public class InventoryManager implements InventoryOperations { // Implementing an interface for LSP & DIP compliance

    // Before SRP Violation:
    // - The book list was exposed, allowing unwanted changes.
    // - No validation when adding books.

    // After SRP Fix:
    // - The book list is private and final for better control.
    // - Null checks prevent invalid books from being added.
    // - A copy of the list is returned to keep the original safe.
    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        } else {
            System.out.println("Cannot add a null book to inventory.");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // LSP Not Violated:
    // - InventoryManager follows expected behavior without altering base assumptions.
    // - It does not introduce unexpected constraints on adding or retrieving books.
    // - Any subclass extending this class can use addBook() without breaking existing functionality.

    // DIP Not Violated:
    // - High-level modules depend on the abstraction (InventoryOperations) instead of InventoryManager.
    // - This allows easy swapping of implementations (e.g., DatabaseInventoryManager, FileInventoryManager).
    // - Loose coupling improves testability and flexibility.
}

// New Interface for LSP & DIP Compliance
interface InventoryOperations {
    void addBook(Book book);
    List<Book> getAllBooks();
}
