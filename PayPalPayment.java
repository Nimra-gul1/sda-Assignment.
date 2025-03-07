
public class PayPalPayment implements PaymentMethod {

    @Override
    public boolean processPayment(Customer customer, double amount) {
        //  LSP Not Violated:
        // - `PayPalPayment` implements `PaymentMethod` correctly.
        // - It follows the expected contract of `processPayment()`, meaning it can be used wherever `PaymentMethod` is expected.

        //  OCP Not Violated:
        // - New payment methods (e.g., `CryptoPayment`) can be added **without modifying** this class.
        // - This class **only** implements PayPal-specific logic without affecting the existing system.

        //  SRP Not Violated:
        // - This class is **only** responsible for processing PayPal payments.
        // - It does not mix unrelated functionalities like customer management or inventory processing.

        //  DIP Not Violated:
        // - `PayPalPayment` implements the **abstraction** (`PaymentMethod`) instead of depending on concrete classes.
        // - The `PaymentProcessor` class **depends on `PaymentMethod`**, allowing flexible payment method injection.

        System.out.println("Processed payment of $" + String.format("%.2f", amount) + 
                           " via PayPal for " + customer.getUsername());
        return true;
    }
}
