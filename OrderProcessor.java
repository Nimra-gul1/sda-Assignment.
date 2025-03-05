
public class OrderProcessor {

    public Order createOrder(Customer customer) {
        return new Order(customer, new StandardPriceCalculator());  //  Fix: PriceCalculator pass kar diya
    }

    public void completeOrder(Order order) {
        order.completeOrder();
    }
}
