

 // Before SRP : Admin had direct control over inventory.
// follows SRP now: Now the Admin gives inventory tasks to the Inventory Manager
// OCP is not violated since Admin delegates inventory tasks, making the system extendable without modifying existing classes.
public class Admin extends User {

    private final InventoryOperations inventoryOperations; // Depend on an abstraction, not a concrete class

    /**
     * @param username             Admin's username
     * @param password             Admin's password
     * @param inventoryOperations  Abstraction to interact with inventory
     */
    Admin(String username, String password, InventoryOperations inventoryOperations) {
        super(username, password);
        this.inventoryOperations = inventoryOperations;
    }

    /**
     *
     * Before DIP Violation:
     * - Admin directly depended on InventoryManager, creating tight coupling.
     *
     * After DIP Fix:
     * - Admin now depends on InventoryOperations, which allows any implementation of inventory management.
     */
    public void addBookToInventory(Book book) {
        inventoryOperations.addBook(book); // Uses InventoryOperations instead of a concrete class
        System.out.println("Admin " + getUsername() + " added " + book.getTitle() + " to inventory.");
    }

    /**
     * @return Admin's username
     */
    @Override
    public String getUsername() {
        return super.getUsername();
    }
}
