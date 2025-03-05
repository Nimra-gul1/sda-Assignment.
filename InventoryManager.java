import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    // Before SRP Violation:
    // - The book list was exposed, allowing unwanted changes.
    // - No validation when adding books.

    // After SRP Fix:
    // - The book list is private and final for better control.
    // - Null checks prevent invalid books from being added.
    // - A copy of the list is returned to keep the original safe.

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        } else {
            System.out.println("Cannot add a null book to inventory.");
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
