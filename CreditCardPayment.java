
public class CreditCardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(Customer customer, double amount) {
        System.out.println("Processed payment of $" + String.format("%.2f", amount) + " via Credit Card for " + customer.getUsername());
        return true;
    }
}
