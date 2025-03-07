public class BankTransferPayment implements PaymentMethod {

    @Override
    public boolean processPayment(Customer customer, double amount) {
        // LSP is followed: This class can be used wherever PaymentMethod is expected.
        // OCP is followed: We can introduce new payment methods without modifying existing ones.
        // SRP is followed: This class is only responsible for processing bank transfer payments.

        // DIP is NOT violated:
        // - This class implements PaymentMethod (an abstraction), instead of being directly referenced.
        // - High-level modules (e.g., OrderProcessor) depend on the PaymentMethod interface, NOT directly on this class.
        
        // Simulating a bank transfer process
        if (amount <= 0) {
            System.out.println("Invalid payment amount. Transaction failed.");
            return false;
        }

        System.out.println("Processed payment of $" + String.format("%.2f", amount) + 
                           " via Bank Transfer for " + customer.getUsername());
        return true;
    }
}
