import java.util.List;

public class DiscountPriceCalculator implements PriceCalculator {

    private final double discountPercentage;

    public DiscountPriceCalculator(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateTotalPrice(List<Book> books) {
        double totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice - (totalPrice * discountPercentage / 100);
    }

     // No DIP Violation:
    // - This class depends on an abstraction (PriceCalculator) instead of a concrete implementation.
    // - High-level modules using PriceCalculator do not need to depend on this specific class.
    // - This allows easy extension with new pricing strategies (e.g., SeasonalDiscountCalculator).

    // LSP Not Violated:
    // - DiscountPriceCalculator correctly implements PriceCalculator.
    // - It can be used as a substitute for PriceCalculator without breaking functionality.
    // - It does not change the expected behavior of calculateTotalPrice.

}
