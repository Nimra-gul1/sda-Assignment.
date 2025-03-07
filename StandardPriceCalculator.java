
import java.util.List;

/**
 *  No SRP Violation:
 * - This class is only responsible for calculating the total price of books.
 * - It does not handle orders, payments, or inventory management.
 * 
 *  No OCP Violation:
 * - New pricing strategies (e.g., discounts, taxes) can be added via separate classes
 *   implementing the `PriceCalculator` interface without modifying this class.
 * 
 *  No LSP Violation:
 * - This class correctly implements `PriceCalculator`, ensuring it can be used 
 *   interchangeably with other pricing strategy implementations.
 * 
 *  No ISP Violation:
 * - `PriceCalculator` interface defines only one method, avoiding unnecessary dependencies.
 * 
 *  No DIP Violation:
 * - This class depends on an abstraction (`PriceCalculator`), making it flexible 
 *   and allowing easy substitution with other pricing strategies.
 */
public class StandardPriceCalculator implements PriceCalculator {

    @Override
    public double calculateTotalPrice(List<Book> books) {
        double totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
}
