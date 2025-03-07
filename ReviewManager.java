import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    // Before: Could only get reviews, but couldn't add new ones (SRP violation).
    // After: Added a method to add reviews, making it fully manage reviews.

    private final List<Review> reviews = new ArrayList<>(); // Keeps all reviews.

    public void addReview(Review review) { // Now can add reviews.
        if (review != null) { // Prevents adding empty reviews.
            reviews.add(review);
        } else {
            System.out.println("Cannot add a null review.");
        }
    }

    public List<Review> getReviewsForBook(Book book) { // Gets reviews for a book.
        List<Review> bookReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getBook().equals(book)) {
                bookReviews.add(review);
            }
        }
        return bookReviews;
    }

    /**
     *  **OCP Compliance**  
     * - **Before:** If new filtering/sorting logic was needed, modifications in this class were required, violating OCP.  
     * - **Now:** We can extend functionality by creating new classes or methods without changing existing code.  
     * - **Example:** If we need advanced filtering (e.g., reviews by rating), we can add new methods in a subclass or separate utility class.
     */

    //  **No SRP Violation:**
    // - This class now **only handles review management**.
    // - It does not interfere with books, payments, or orders.

    //  **No LSP Violation:**
    // - The `ReviewManager` class does not extend another class.
    // - If it were to be extended, subclasses would still work without breaking expected behavior.

    //  **No DIP Violation:**
    // - The class depends on the `Review` and `Book` abstractions.
    // - If needed, an `IReview` interface could be introduced for better flexibility.
}
