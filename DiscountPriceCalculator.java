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

    // LSP Not Violated:
    // - DiscountPriceCalculator correctly implements PriceCalculator.
    // - It can be used as a substitute for PriceCalculator without breaking functionality.
    // - It does not change the expected behavior of calculateTotalPrice.
}
