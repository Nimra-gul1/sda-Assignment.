public class OrderProcessor {
    private final PriceCalculator priceCalculator; // Now depends on abstraction

    public OrderProcessor(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator; // Injecting PriceCalculator
    }

    public Order createOrder(Customer customer) {
        return new Order(customer, priceCalculator); // Now uses the injected instance
    }

    public void completeOrder(Order order) {
        order.completeOrder();
    }
}
