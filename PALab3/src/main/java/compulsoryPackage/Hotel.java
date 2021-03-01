package compulsoryPackage;

/**
 * author: Zamfir Adrian-Iulian
 * Hotel is a class that shows a Location which is only Classifiable.
 */
public class Hotel extends Locations implements Classifiable{

    public Hotel(String hotelName){
        super(hotelName);
    }

    public void setRating(int givenRating) {
        this.rating = givenRating;
    }

    public int getRating() {
        return this.rating;
    }
}
