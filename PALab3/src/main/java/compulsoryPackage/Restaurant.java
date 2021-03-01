package compulsoryPackage;

/**
 * author: Zamfir Adrian-Iulian
 * Restaurant is a class that shows a location which is only Classifiable.
 */
public class Restaurant extends Locations implements Classifiable{

    public Restaurant(String restaurantName){
        super(restaurantName);
    }

    public void setRating(int givenRating) {
        this.rating = givenRating;
    }

    public int getRating() {
        return this.rating;
    }
}
