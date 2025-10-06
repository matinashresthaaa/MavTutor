public interface Rateable {
    void addRatings(Rating r);
    double getAverageRating();
    Rating[] getRatings();
    
}
