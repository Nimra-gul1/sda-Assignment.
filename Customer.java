
// OCP Not Violated:
// This class does not violate the Open-Closed Principle because it focuses only on storing customer data.
public class Customer extends User {

    private final String email;

    public Customer(String username, String password, String email) {
        super(username, password);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

     // Before SRP Violation:
    // The Customer class was responsible for both storing user details and handling book purchases.
    // This violated the Single Responsibility Principle because a class should only have one reason to change.
    // 
    // After SRP Resolution:
    // Now, the Customer class only manages customer-related data (username, password, email).
    // The book purchasing logic has been removed.
    // Purchasing functionality should now be handled by a separate class like PaymentProcessor.

    // No LSP Violation:
    // - Customer correctly extends User without changing expected behavior.
    // - It maintains all properties of a User while adding email functionality.
    //
    // No DIP Violation:
    // - This class does not depend on low-level implementations.
    // - High-level modules (like OrderProcessor or PaymentProcessor) interact with Customer without directly relying on it.
    // - If needed, an abstraction (e.g., an interface) could be introduced, but it is not required in this case because Customer is just a data holder.
}
