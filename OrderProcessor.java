public class OrderProcessor {

    /**
     * **Before SRP Violation:**
     * - OrderProcessor was tightly coupled with order details.
     * - It handled pricing logic, which should be a separate responsibility.
     * 
     * **Fix:**
     * - Now, it only creates orders and delegates price calculation via `PriceCalculator`.
     */
    public Order createOrder(Customer customer) {
        return new Order(customer, new StandardPriceCalculator());  //  Fix: PriceCalculator passed correctly
    }

    public void completeOrder(Order order) {
        order.completeOrder();
    }

    // **LSP Not Violated:**
    // - `OrderProcessor` creates an `Order` using a `PriceCalculator`, allowing substitution of different implementations.
    // - Any `PriceCalculator` (e.g., `DiscountPriceCalculator`) can be passed without breaking functionality.
    // - It does not enforce additional constraints on `Customer` or `Order`, ensuring proper substitution.
}
