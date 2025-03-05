
// Before SRP Fix: Payment logic was inside Order.
// SRP Fix: Payment logic is now separate.
// and now 
// OCP is not violated as new payment methods can be added without modifying this class.
public class Payment {

    public static boolean processPayment(PaymentMethod paymentMethod, Customer customer, double amount) {
        return paymentMethod.processPayment(customer, amount);
    }
}
