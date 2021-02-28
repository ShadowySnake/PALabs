package compulsoryPackage;

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
