
public class PayPalPayment implements PaymentMethod {

    @Override
    public boolean processPayment(Customer customer, double amount) {
        System.out.println("Processed payment of $" + String.format("%.2f", amount) + " via PayPal for " + customer.getUsername());
        return true;
    }
}
