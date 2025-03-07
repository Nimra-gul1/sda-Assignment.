
public class Review {

    private final Customer reviewer;
    private final Book book;
    private final String comment;
    private final int rating;

    public Review(Customer reviewer, Book book, String comment, int rating) {
        this.reviewer = reviewer;
        this.book = book;
        this.comment = comment;
        this.rating = rating;
    }

    public Book getBook() {
        return book;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review by " + reviewer.getUsername() + " for " + book.getTitle() + ": " 
                + comment + " (Rating: " + rating + "/5)";
    }

    //  No OCP Violation:
    // - The class is **open for extension** but **closed for modification**.
    // - If new review-related features are needed (e.g., upvoting reviews, adding images), 
    //   new classes or decorators can be added **without modifying this class**.

    //  No LSP Violation:
    // - The `Review` class does not extend another class, but if it did, 
    //   it does not break the expected behavior of its parent.
    // - Any valid `Customer` or `Book` object can be reviewed without changing class functionality.

    //  No DIP Violation:
    // - `Review` depends on **abstractions (`Customer`, `Book`)** rather than concrete implementations.
    // - If needed, interfaces like `Reviewer` could be introduced for more flexibility.

    //  No SRP Violation:
    // - This class has **one responsibility**: handling book reviews.
    // - It does not deal with books, customers, or ratings beyond their relation to a review.
}
