public class Bookstore {
    public static void main(String[] args) {
        // Before SRP Violation:
        // The main class was handling too many responsibilities directly:
        // - Inventory management
        // - Order processing
        // - Payment handling
        // - Review management
        // - Printing book ratings
        //
        // After SRP Resolution:
        // Now each responsibility has been delegated to separate classes.
        // - InventoryManager handles book storage
        // - OrderProcessor manages order creation and completion
        // - PaymentProcessor handles payments

        InventoryManager inventoryManager = new InventoryManager();
        PriceCalculator priceCalculator = new StandardPriceCalculator(); // Use any implementation
        OrderProcessor orderProcessor = new OrderProcessor(priceCalculator);

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        //  LSP Compliance:
        // Admin extends User correctly and interacts with InventoryManager without altering its expected behavior.
        Admin admin = new Admin("admin", "admin123", inventoryManager);
        Customer customer = new Customer("john_doe", "password123", "john@example.com");

        // DIP is NOT violated:
        // - High-level module (PaymentProcessor) depends on an abstraction (PaymentMethod) instead of concrete implementations.
        // - We can easily introduce new payment methods without modifying existing logic.
        PaymentMethod creditCard = new CreditCardPayment();
        paymentProcessor.processPayment(creditCard, customer, 100.0);

        PaymentMethod payPal = new PayPalPayment();
        paymentProcessor.processPayment(payPal, customer, 50.0);

        // Creating book objects
        Book[] books = {
            new Book("Java Basics", "John Smith", 20.99),
            new Book("Python 101", "Jane Doe", 15.99),
            new Book("C++ Programming", "Alice Johnson", 34.99),
            new Book("Data Structures in Java", "Bob Wilson", 27.99),
            new Book("JavaScript Fundamentals", "Mary Brown", 24.99),
            new Book("SQL Essentials", "David Davis", 22.99),
            new Book("Algorithms and Complexity", "Eva Evans", 39.99),
            new Book("Web Development with React", "Frank Lee", 29.99),
            new Book("Artificial Intelligence", "Grace Adams", 44.99),
            new Book("Machine Learning Basics", "Henry Harris", 36.99)
        };

        //  DIP is NOT violated:
        // - Admin interacts with InventoryManager through an abstraction (InventoryOperations) instead of a concrete class.
        // - InventoryManager implements InventoryOperations, ensuring flexibility for future changes.
        for (Book book : books) {
            admin.addBookToInventory(book);
        }

        //  LSP Compliance:
        // OrderProcessor correctly follows the expected order workflow without modifying existing behavior.
        Order order = orderProcessor.createOrder(customer);
        for (Book book : books) {
            order.addBookToOrder(book);
        }
        orderProcessor.completeOrder(order);
    }
}