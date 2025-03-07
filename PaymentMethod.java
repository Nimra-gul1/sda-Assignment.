
/**
 * **No DIP Violation:**
 * - High-level modules (e.g., PaymentProcessor) depend on this abstraction 
 *   instead of concrete implementations like CreditCardPayment or PayPalPayment.
 * - This allows flexibility to introduce new payment methods without modifying 
 *   the PaymentProcessor class, adhering to the **Dependency Inversion Principle (DIP)**.
 * 
 * **No LSP Violation:**
 * - Any class implementing PaymentMethod (e.g., CreditCardPayment, PayPalPayment) 
 *   can be substituted without breaking functionality, ensuring compliance with 
 *   the **Liskov Substitution Principle (LSP)**.
 * 
 * **No OCP Violation:**
 * - We can add new payment methods by creating new implementations of PaymentMethod 
 *   without modifying this interface, following the **Open/Closed Principle (OCP)**.
 */
public interface PaymentMethod {

    /**
     * Processes a payment for the given customer and amount.
     * Implementing classes will define the payment processing logic.
     *
     * @param customer The customer making the payment.
     * @param amount   The amount to be paid.
     * @return true if payment is successful, false otherwise.
     */
    boolean processPayment(Customer customer, double amount);
}
