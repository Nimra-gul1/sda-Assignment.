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
}
