
import java.util.List;

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
