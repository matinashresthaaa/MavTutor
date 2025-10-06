public interface Rateable {
    void addRatings(Rating rating);
    double getAverageRating();
    Rating[] getRatings();
    
}
