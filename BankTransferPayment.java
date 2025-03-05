
public class BankTransferPayment implements PaymentMethod {

    @Override
    public boolean processPayment(Customer customer, double amount) {
        System.out.println("Processed payment of $" + String.format("%.2f", amount) + " via Bank Transfer for " + customer.getUsername());
        return true;
    }
}
