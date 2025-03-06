// Now, both OCP and SRP violations are resolved!

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final Customer customer;
    private final List<Book> purchasedBooks = new ArrayList<>();
    private boolean isCompleted = false;
    private final PriceCalculator priceCalculator;  //  OCP Fix: Delegated calculation to a separate class

    /**
     * **Before (OCP & SRP Violation)**
     * - `Order` handled price calculation, violating **OCP** (modifications needed for new pricing logic).
     * - Mixed order management & pricing, violating **SRP**.
     *
     * **Resolution:**
     * - Introduced `PriceCalculator` interface for pricing logic.
     * - Created `StandardPriceCalculator` & `DiscountPriceCalculator` for flexibility.
     * - Now, new pricing strategies can be added **without modifying** `Order` (OCP-compliant).
     */
    public Order(Customer customer, PriceCalculator priceCalculator) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        this.customer = customer;
        this.priceCalculator = priceCalculator;  //  Delegated pricing logic
    }

    public void addBookToOrder(Book book) {
        if (book != null) {
            purchasedBooks.add(book);
        } else {
            System.out.println("Cannot add a null book to the order.");
        }
    }

    public double getTotalPrice() {
        return priceCalculator.calculateTotalPrice(purchasedBooks); //  Removed price calculation from Order
    }

    public List<Book> getPurchasedBooks() {
        return new ArrayList<>(purchasedBooks);
    }

    public void completeOrder() {
        if (purchasedBooks.isEmpty()) {
            System.out.println("Cannot complete an empty order.");
            return;
        }

        isCompleted = true;
        System.out.println("Order for " + customer.getUsername() + " is complete.");
        for (Book book : purchasedBooks) {
            System.out.println("- " + book.getTitle() + " ($" + String.format("%.2f", book.getPrice()) + ")");
        }
        System.out.println("Total: $" + String.format("%.2f", getTotalPrice()));
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Before, the Order class handled price calculation itself, violating OCP.
    // The Order class had multiple responsibilities (order management & pricing), violating SRP.
    // Introduced a PriceCalculator interface and separate pricing classes to delegate pricing.
    // Now, new pricing logic can be added without modifying Order, ensuring OCP compliance.

    // LSP Not Violated:
    // - Order depends on PriceCalculator abstraction, allowing substitution of different pricing strategies.
    // - Substituting any valid PriceCalculator (e.g., DiscountPriceCalculator) does not break Order's behavior.
    // - Order ensures valid inputs (customer cannot be null, books cannot be null) without imposing unexpected restrictions.
}
