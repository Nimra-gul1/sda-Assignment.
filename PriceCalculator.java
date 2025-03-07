
import java.util.List;

public interface PriceCalculator {

    double calculateTotalPrice(List<Book> books);

    //  DIP Not Violated:
    // - This interface provides an **abstraction** for price calculation.
    // - Concrete classes (e.g., `StandardPriceCalculator`, `DiscountPriceCalculator`) implement this interface.
    // - High-level modules (like `Order`) depend on this abstraction, not on specific implementations.

    //  LSP Not Violated:
    // - Any class implementing `PriceCalculator` must follow the expected contract.
    // - Substituting a different pricing strategy (e.g., `DiscountPriceCalculator`) does not break functionality.

    //  OCP Not Violated:
    // - New pricing strategies can be added **without modifying** this interface.
    // - Example: `PremiumPriceCalculator` or `SeasonalDiscountCalculator` can be introduced easily.

    //  SRP Not Violated:
    // - The `PriceCalculator` interface has **only one responsibility**: defining price calculation behavior.
    // - It does not handle orders, inventory, or other unrelated concerns.
}