
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
}
