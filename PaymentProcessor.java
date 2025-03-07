
public class PaymentProcessor {
    
    //  LSP Not Violated:
    // - This class relies on the `PaymentMethod` interface, meaning any valid subclass (e.g., `CreditCardPayment`, 
    //   `BankTransferPayment`, `PayPalPayment`) can be used interchangeably without breaking functionality.
    // - It does not impose any unexpected restrictions on subclasses.

    //  DIP Not Violated:
    // - `PaymentProcessor` depends on the abstraction (`PaymentMethod`), not specific implementations.
    // - This allows **flexibility** to use any payment method without modifying `PaymentProcessor`.

    public boolean processPayment(PaymentMethod paymentMethod, Customer customer, double amount) {
        if (customer == null) {
            System.out.println("Error: Customer information is missing.");
            return false; // Prevent processing if customer is null
        }

        if (amount <= 0) {
            System.out.println("Error: Invalid payment amount.");
            return false; // Prevent invalid payment amounts
        }

        //  Following DIP: Delegating payment processing to the `PaymentMethod` interface.
        // - This allows different payment implementations to be injected dynamically.
        // - New payment methods can be added without modifying this class.
        return paymentMethod.processPayment(customer, amount);
    }
}