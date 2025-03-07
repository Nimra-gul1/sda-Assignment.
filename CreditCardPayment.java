/**
     * No SRP (Single Responsibility Principle) Violation:
     * - This class is only responsible for processing credit card payments.
     * - It does not handle order processing, inventory management, or other tasks.
     *
     * No OCP (Open-Closed Principle) Violation:
     * - We can introduce new payment methods (e.g., PayPal, Bank Transfer) without modifying this class.
     * - This class extends functionality without changing existing code.
     *
     * No LSP (Liskov Substitution Principle) Violation:
     * - It correctly implements PaymentMethod, meaning it can be used interchangeably with other payment classes.
     * - If another class expects a PaymentMethod, this class can be used without breaking functionality.
     *
     * No DIP (Dependency Inversion Principle) Violation:
     * - High-level modules (like PaymentProcessor) rely on the PaymentMethod interface, not this specific class.
     * - This class does not depend on concrete implementations, ensuring flexibility.
     */
    public class CreditCardPayment implements PaymentMethod {

        @Override
        public boolean processPayment(Customer customer, double amount) {
            System.out.println("Processed payment of $" + String.format("%.2f", amount) + " via Credit Card for " + customer.getUsername());
            return true;
        }
    }
