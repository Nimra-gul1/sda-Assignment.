
// Before SRP Fix: Payment logic was inside Order.
// - This violated SRP because Order was responsible for both managing orders and processing payments.
// - If payment logic changed, Order had to be modified, violating SRP.

// SRP Fix: Payment logic is now separate in this `Payment` class, improving maintainability.
// - Order no longer handles payment processing, and responsibilities are clearly defined.

// OCP is not violated: 
// - New payment methods can be added without modifying this class.
// - Since this class relies on the `PaymentMethod` interface, any new payment method 
//   (e.g., `GooglePayPayment`, `CryptoPayment`) can be introduced without changes here.
public class Payment {

    //  DIP Not Violated:
    // - `Payment` depends on the abstraction `PaymentMethod`, not a concrete class.
    // - This allows **flexibility** to pass any `PaymentMethod` implementation (e.g., `CreditCardPayment`).
    public static boolean processPayment(PaymentMethod paymentMethod, Customer customer, double amount) {
        return paymentMethod.processPayment(customer, amount); 
    }
}

