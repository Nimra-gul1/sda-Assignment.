import java.util.ArrayList;
import java.util.List;

public class Order {
    // Before SRP Violation:
    // - No validation for null customers or books.
    // - Order completion logic was mixed with displaying order details.
    // - The purchased book list was directly accessible, allowing unwanted modifications.

    // After SRP Fix:
    // - Added null checks to ensure valid input for customers and books.
    // - Introduced 'isCompleted' flag to track order status separately.
    // - Returning a copy of purchased books list to protect data integrity.

    private final Customer customer;  // Made final to ensure customer is assigned only once
    private final List<Book> purchasedBooks = new ArrayList<>(); 
    private boolean isCompleted = false; // Added to track order status

    public Order(Customer customer) {
        if (customer == null) { // Added validation to prevent null customers
            throw new IllegalArgumentException("Customer cannot be null"); 
        }
        this.customer = customer;
    }

    public void addBookToOrder(Book book) {
        if (book != null) { // Added null check to prevent invalid books from being added
            purchasedBooks.add(book);
        } else {
            System.out.println("Cannot add a null book to the order.");
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Book book : purchasedBooks) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    public List<Book> getPurchasedBooks() {
        return new ArrayList<>(purchasedBooks); // Returning a copy to avoid direct modification
    }

    public void completeOrder() {
        if (purchasedBooks.isEmpty()) { // Added check to prevent empty order completion
            System.out.println("Cannot complete an empty order.");
            return;
        }
        
        isCompleted = true; // Order status updated
        System.out.println("Order for " + customer.getUsername() + " is complete.");
        for (Book book : purchasedBooks) {
            System.out.println("- " + book.getTitle() + " ($" + String.format("%.2f", book.getPrice()) + ")");
        }
        System.out.println("Total: $" + String.format("%.2f", getTotalPrice()));
    }

    public boolean isCompleted() {
        return isCompleted; // Added method to check order status separately
    }
}
