public class Payment {
    public static boolean processPayment(Customer customer, double amount) {
        // Before SRP Fix: Payment logic was inside Order.
        // SRP Fix: Payment logic is now separate.
        System.out.println("Processed payment of $" + String.format("%.2f", amount) + " for " + customer.getUsername());
        return true;
    }
}