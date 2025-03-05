
// public class PaymentProcessor {
//     // Responsible only for handling payments (SRP )
//     public boolean processPayment(Customer customer, double amount) {
//         if (customer == null) {
//             System.out.println("Error: Customer information is missing.");
//             return false; // Prevent processing if customer is null
//         }
//         if (amount <= 0) {
//             System.out.println("Error: Invalid payment amount.");
//             return false; // Prevent invalid payment amounts
//         }
//         // Show how payment works
//         System.out.println("Processing payment of $" + String.format("%.2f", amount) + " for " + customer.getUsername());
//         return true; // Assume payment is always successful in this simulation
//     }
// }
public class PaymentProcessor {

    // The PaymentProcessor now does not care about the type of payment, just that it implements PaymentMethod.
    public boolean processPayment(PaymentMethod paymentMethod, Customer customer, double amount) {
        if (customer == null) {
            System.out.println("Error: Customer information is missing.");
            return false; // Prevent processing if customer is null
        }

        if (amount <= 0) {
            System.out.println("Error: Invalid payment amount.");
            return false; // Prevent invalid payment amounts
        }

        // Delegate payment processing to the appropriate PaymentMethod
        return paymentMethod.processPayment(customer, amount);
    }
}
