/**
 *  No SRP Violation:
 * - The `User` class is only responsible for storing user credentials and authentication.
 * - It does not handle unrelated concerns like order processing, payments, or inventory management.
 * 
 *  No OCP Violation:
 * - If new authentication mechanisms (e.g., hashing, multi-factor authentication) are needed,
 *   they can be added through extension rather than modifying this class.
 * 
 *  No LSP Violation:
 * - If a subclass extends `User`, it can override `authenticate()` without breaking expected behavior.
 * 
 *  No ISP Violation:
 * - No unnecessary methods or dependencies are forced on subclasses.
 * 
 *  No DIP Violation:
 * - This class does not depend on concrete implementations of other classes.
 * - It can be used in a flexible way within different authentication strategies.
 */
public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password); // Simple authentication logic
    }

    public String getUsername() {
        return username;
    }
}