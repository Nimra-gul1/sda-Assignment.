
public interface PaymentMethod {

    boolean processPayment(Customer customer, double amount);
}
