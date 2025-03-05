
//  No OCP Violation: Extending review functionality doesn't require modifying this class.
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
        return "Review by " + reviewer.getUsername() + " for " + book.getTitle() + ": " + comment + " (Rating: " + rating + "/5)";
    }
}
