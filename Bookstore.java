
// OCP is not violated since responsibilities are properly delegated and extendable.
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
        OrderProcessor orderProcessor = new OrderProcessor();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Before SRP Violation:
        // The Admin class was responsible for both managing users and modifying the inventory.
        //
        // After SRP Resolution:
        // The Admin now delegates inventory tasks to InventoryManager, keeping responsibilities separate.
        Admin admin = new Admin("admin", "admin123", inventoryManager);
        Customer customer = new Customer("john_doe", "password123", "john@example.com");
        // Initialize PaymentProcessor

        // Use CreditCardPayment
        PaymentMethod creditCard = new CreditCardPayment();
        paymentProcessor.processPayment(creditCard, customer, 100.0);

        // Use PayPalPayment
        PaymentMethod payPal = new PayPalPayment();
        paymentProcessor.processPayment(payPal, customer, 50.0);

        // Creating book objects
        Book book1 = new Book("Java Basics", "John Smith", 20.99);
        Book book2 = new Book("Python 101", "Jane Doe", 15.99);
        Book book3 = new Book("C++ Programming", "Alice Johnson", 34.99);
        Book book4 = new Book("Data Structures in Java", "Bob Wilson", 27.99);
        Book book5 = new Book("JavaScript Fundamentals", "Mary Brown", 24.99);
        Book book6 = new Book("SQL Essentials", "David Davis", 22.99);
        Book book7 = new Book("Algorithms and Complexity", "Eva Evans", 39.99);
        Book book8 = new Book("Web Development with React", "Frank Lee", 29.99);
        Book book9 = new Book("Artificial Intelligence", "Grace Adams", 44.99);
        Book book10 = new Book("Machine Learning Basics", "Henry Harris", 36.99);
        // Before SRP Violation:
        // The Admin was directly managing inventory.
        //
        // After SRP Resolution:
        // Now, the Admin only delegates inventory-related tasks to InventoryManager.

        admin.addBookToInventory(book1);
        admin.addBookToInventory(book2);
        admin.addBookToInventory(book3);
        admin.addBookToInventory(book4);
        admin.addBookToInventory(book5);
        admin.addBookToInventory(book6);
        admin.addBookToInventory(book7);
        admin.addBookToInventory(book8);
        admin.addBookToInventory(book9);
        admin.addBookToInventory(book10);

        // Before SRP Violation:
        // Order creation and book additions were handled within the main function.
        //
        // After SRP Resolution:
        // Now, OrderProcessor is responsible for order creation and completion.
        Order order = orderProcessor.createOrder(customer);
        order.addBookToOrder(book1);
        order.addBookToOrder(book2);
        order.addBookToOrder(book3);
        order.addBookToOrder(book4);
        order.addBookToOrder(book5);
        order.addBookToOrder(book6);
        order.addBookToOrder(book7);
        order.addBookToOrder(book8);
        order.addBookToOrder(book9);
        order.addBookToOrder(book10);
        orderProcessor.completeOrder(order);

        // Before SRP Violation:
        // Payment processing was mixed with order handling.
        //
        // After SRP Resolution:
        // Payment processing is now handled separately by PaymentProcessor.
    }
}


//OCP is not violated since responsibilities are properly delegated and extendable
