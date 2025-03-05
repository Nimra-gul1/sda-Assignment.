
// OCP is not violated since Admin delegates inventory tasks, making the system extendable without modifying existing classes.
public class Admin extends User {

    private final InventoryManager inventoryManager;

    public Admin(String username, String password, InventoryManager inventoryManager) {
        super(username, password);
        this.inventoryManager = inventoryManager;
    }

    public void addBookToInventory(Book book) {
        // Before SRP : Admin had direct control over inventory.
        // follows SRP now: Now the Admin gives inventory tasks to the Inventory Manager
        inventoryManager.addBook(book);
        System.out.println("Admin " + getUsername() + " added " + book.getTitle() + " to inventory.");
    }
}
