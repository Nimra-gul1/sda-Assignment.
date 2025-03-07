public class Book {

    private final String title;
    private final String author;
    private final double price;

    /**
     * Constructor initializes Book object with title, author, and price.
     * No SRP violation: This class is only responsible for representing a book entity.
     * No LSP violation: Any subclass of Book would not break expected behavior.
     * No DIP violation:
     *   - This class does not depend on any low-level module or concrete implementation.
     *   - High-level modules (like InventoryManager or OrderProcessor) may use Book, but Book itself remains independent.
     */
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getter methods provide access to book properties
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

