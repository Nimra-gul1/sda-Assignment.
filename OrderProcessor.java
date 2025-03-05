public class OrderProcessor {
    public Order createOrder(Customer customer) {
        return new Order(customer);
    }

    public void completeOrder(Order order) {
        order.completeOrder();
    }
}